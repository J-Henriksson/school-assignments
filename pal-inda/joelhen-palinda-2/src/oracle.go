// Stefan Nilsson 2013-03-13

// This program implements an ELIZA-like oracle (en.wikipedia.org/wiki/ELIZA).
package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strings"
	"time"
)

// Constants defining the oracle's name, venue, prompt symbol, and the
// timeout duration for how long the oracle should wait without user input before it sends a message.
const (
	star            = "Pythia"
	venue           = "Delphi"
	prompt          = "> "
	timeoutDuration = 15 * time.Second
)

var lastPrintedNonsensePhrase = ""

func main() {
	fmt.Printf("Welcome to %s, the oracle at %s.\n", star, venue)
	printWithDelay("Your questions will be answered in due time.")

	questions := Oracle()
	reader := bufio.NewReader(os.Stdin)
	timer := time.NewTimer(timeoutDuration)

	defer timer.Stop()

	// Goroutine that makes the oracle send a message if the user goes long enough without input.
	go func() {
		for {
			select {
			case <-timer.C:
				fmt.Printf("\n")
				printWithDelay("Hurry up and ask another question!")
				fmt.Printf(prompt)
			}
		}
	}()

	for {
		fmt.Print(prompt)
		line, _ := reader.ReadString('\n')
		line = strings.TrimSpace(line)
		if line == "" {
			continue
		}
		fmt.Printf("%s heard: %s\n", star, line)
		questions <- line            // The channel doesn't block.
		timer.Reset(timeoutDuration) // Reset the timer

	}
}

// Oracle returns a channel on which you can send your questions to the oracle.
// You may send as many questions as you like on this channel, it never blocks.
// The answers arrive on stdout, but only when the oracle so decides.
// The oracle also prints sporadic prophecies to stdout even without being asked.
func Oracle() chan<- string {
	questions := make(chan string)
	answers := make(chan string)

	go func() {
		for {
			question := <-questions
			prophecy(question, answers)
		}
	}()

	go func() {
		for answer := range answers {
			printWithDelay(answer)
			fmt.Printf(prompt)
		}
	}()
	return questions
}

// printWithDelay prints a given text with a delay between character to make it more human like.
func printWithDelay(text string) {
	for _, char := range text {
		fmt.Print(string(char))
		time.Sleep(100 * time.Millisecond)
	}
	fmt.Print("\n")
}

// This is the oracle's secret algorithm.
// It waits for a while and then sends a message on the answer channel.
// TODO: make it better.
func prophecy(question string, answer chan<- string) {
	// Keep them waiting. Pythia, the original oracle at Delphi,
	// only gave prophecies on the seventh day of each month.
	time.Sleep(time.Duration(2+rand.Intn(3)) * time.Second)

	// Find the longest word.
	longestWord := ""
	words := strings.Fields(question) // Fields extracts the words into a slice.
	for _, w := range words {
		if len(w) > len(longestWord) {
			longestWord = w
		}
	}

	switch {
	case strings.Contains(strings.ToLower(question), "weather"):
		prediction := generateWeatherPrediction()
		answer <- prediction
	case strings.Contains(strings.ToLower(question), "money"):
		response := "Don't forget buy at the dip and sell at the tip"
		answer <- response
	case strings.Contains(strings.ToLower(question), "future"):
		response := "The future is uncertain for you..."
		answer <- response
	default:
		// Cook up some pointless nonsense.
		nonsense := []string{
			"The moon is dark.",
			"The sun is bright.",
			"The wheel of fate turns ever onward.",
			"Wisdom is found in the whispers of the wind.",
			"The path to enlightenment is paved with curiosity.",
			"Seek not answers, but the questions that lead to truth.",
			longestWord + "I can't stop thinking about" + longestWord,
		}

		phrase := nonsense[rand.Intn(len(nonsense))]
		for phrase == lastPrintedNonsensePhrase {
			phrase = nonsense[rand.Intn(len(nonsense))]
		}
		lastPrintedNonsensePhrase = phrase

		answer <- longestWord + "... " + phrase
	}
}

// generateWeatherPrediction generates a random weather prediction
// for when "weather" is detected as a keyword in user input.
func generateWeatherPrediction() string {
	weatherPredictions := []string{
		"Expect sunny skies and warm temperatures.",
		"The moon will dance on the horizon.",
		"Bundle up! It's going to be cold and windy.",
		"The skies will fill with an unforgiving fire.",
	}

	return weatherPredictions[rand.Intn(len(weatherPredictions))]
}

func init() { // Functions called "init" are executed before the main function.
	// Use new pseudo random numbers every time.
	rand.Seed(time.Now().Unix())
}
