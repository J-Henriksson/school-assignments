package main

import (
	"strings"

	"golang.org/x/tour/wc"
)

// WordCount counts the occurrences of each word in s.
func WordCount(s string) map[string]int {
	words := strings.Fields(s)

	wordCounts := make(map[string]int)

	for _, word := range words {
		wordCounts[word]++
	}

	return wordCounts
}

func main() {
	wc.Test(WordCount)
}
