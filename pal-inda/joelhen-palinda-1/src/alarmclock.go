package main

import (
	"fmt"
	"time"
)

func Remind(text string, delay time.Duration) {
	for {
		now := time.Now()
		fmt.Printf("The time is %02d:%02d:%02d: %s\n", now.Hour(), now.Minute(), now.Second(), text)
		time.Sleep(delay)
	}
}

func main() {
	go Remind("Time to eat", 10*time.Second)
	go Remind("Time to work", 30*time.Second)
	go Remind("Time to sleep", 60*time.Second)

	select {}
}
