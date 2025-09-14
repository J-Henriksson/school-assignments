package main

import (
	"fmt"
	"io/ioutil"
	"regexp"
	"strings"
	"sync"
	"time"
)

const DataFile = "loremipsum.txt"
const numChunks = 4

func WordCountMap(text string, resultChan chan<- map[string]int) {
	freqs := make(map[string]int)

	reg, _ := regexp.Compile("[^a-zA-Z\\s]+")
	text = reg.ReplaceAllString(text, "")
	text = strings.ToLower(text)

	words := strings.Fields(text)

	for _, word := range words {
		freqs[word]++
	}
	resultChan <- freqs
}

// Uses a channel to combine the results from 2 maps into a single map.
func WordCountReduce(resultChans []chan map[string]int) map[string]int {
	totalFreq := make(map[string]int)
	for _, resultChan := range resultChans {
		freq := <-resultChan
		for word, count := range freq {
			totalFreq[word] += count
		}
	}
	return totalFreq
}

// WordCount splits the text into chunks to calculate the word count concurrently and then combines them using WordCountReduce.
func WordCount(text string) map[string]int {
	chunkSize := (len(text) + numChunks - 1) / numChunks
	resultChans := make([]chan map[string]int, numChunks)

	for i := range resultChans {
		resultChans[i] = make(chan map[string]int)
	}

	var wg sync.WaitGroup
	end := 0
	for i := 0; i < numChunks; i++ {
		start := end
		end = end + chunkSize
		if end > len(text) {
			end = len(text) - 1
		}
		for text[end] != byte(' ') && end != len(text)-1 {
			end++
		}
		wg.Add(1)
		go func(i int, text string) {
			defer wg.Done()
			WordCountMap(text, resultChans[i])
		}(i, text[start:end])
	}

	go func() {
		wg.Wait()
		for _, ch := range resultChans {
			close(ch)
		}
	}()

	return WordCountReduce(resultChans)
}

// Benchmark how long it takes to count word frequencies in text numRuns times.
//
// Return the total time elapsed
func Benchmark(text string, numRuns int) int64 {
	start := time.Now()
	for i := 0; i < numRuns; i++ {
		WordCount(text)
	}
	return time.Since(start).Milliseconds()
}

// Print the results of a benchmark
func PrintResults(runtimeMillis int64, numRuns int) {
	fmt.Printf("Amount of runs: %d\n", numRuns)
	fmt.Printf("Total time: %d ms\n", runtimeMillis)
	average := float64(runtimeMillis) / float64(numRuns)
	fmt.Printf("Average time/run: %.2f ms\n", average)
}

func main() {
	// Read in DataFile as a string called data
	data, err := ioutil.ReadFile(DataFile)
	if err != nil {
		fmt.Printf("Error reading file: %v\n", err)
		return
	}

	numRuns := 100
	runtimeMillis := Benchmark(string(data), numRuns)
	PrintResults(runtimeMillis, numRuns)
}
