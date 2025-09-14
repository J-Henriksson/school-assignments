package main

import (
	"fmt"
	"io/ioutil"
	"regexp"
	"strings"
	"time"
)

const DataFile = "loremipsum.txt"

// Return the word frequencies of the text argument.
func WordCount(text string) map[string]int {
	freqs := make(map[string]int)

	reg, _ := regexp.Compile("[^a-zA-Z\\s]+")
	text = reg.ReplaceAllString(text, "")
	text = strings.ToLower(text)

	words := strings.Fields(text)

	for _, word := range words {
		freqs[word]++
	}
	return freqs
}

// Benchmark how long it takes to count word frequencies in text numRuns times.
//
// Return the total time elapsed.
func benchmark(text string, numRuns int) int64 {
	start := time.Now()
	for i := 0; i < numRuns; i++ {
		WordCount(text)
	}
	runtimeMillis := time.Since(start).Nanoseconds() / 1e6

	return runtimeMillis
}

// Print the results of a benchmark
func printResults(runtimeMillis int64, numRuns int) {
	fmt.Printf("amount of runs: %d\n", numRuns)
	fmt.Printf("total time: %d ms\n", runtimeMillis)
	average := float64(runtimeMillis) / float64(numRuns)
	fmt.Printf("average time/run: %.2f ms\n", average)
}

func main() {
	// Read in DataFile as a string called data
	data, err := ioutil.ReadFile(DataFile)
	if err != nil {
		fmt.Printf("Error reading file: %v", err)
		return
	}

	text := string(data)

	wordFreqs := WordCount(text)
	fmt.Printf("Word Frequencies: %#v\n", wordFreqs)

	numRuns := 100
	runtimeMillis := benchmark(text, numRuns)
	printResults(runtimeMillis, numRuns)
}
