package main

import (
	"fmt"
	"sync" // Import sync package for WaitGroup
	"time"
)

// This program should go to 11, but it seemingly only prints 1 to 10.
func main() {
	ch := make(chan int)
	var wg sync.WaitGroup
	wg.Add(1)
	go Print(ch, &wg)
	for i := 1; i <= 11; i++ {
		ch <- i
	}
	close(ch)
	wg.Wait()
}

// Print prints all numbers sent on the channel.
// The function returns when the channel is closed.
func Print(ch <-chan int, wg *sync.WaitGroup) {
	defer wg.Done() // Decrement the WaitGroup counter when the function returns
	for n := range ch {
		time.Sleep(10 * time.Millisecond)
		fmt.Println(n)
	}
}
