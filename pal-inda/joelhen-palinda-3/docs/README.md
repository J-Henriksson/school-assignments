#### Task 1 - Matching Behaviour

* What happens if you remove the `go-command` from the `Seek` call in the `main` function?
  The Seek function will be executed synchronously instead of concurrently.

* What happens if you switch the declaration `wg := new(sync.WaitGroup)` to `var wg sync.WaitGroup` and the parameter `wg *sync.WaitGroup` to `wg sync.WaitGroup`?
  Since the declaration of wg is changed from a pointer to a value type and the parameter wg *sync.WaitGroup is changed to wg sync.WaitGroup, each Seek function operates on its own copy of the WaitGroup. This makes the Seek functions not be able to properly decrement the WaitGroup counter, making the main goroutine wait indefinitely for the counter to reach zero, which causes a deadlock. 

* What happens if you remove the buffer on the channel match?  
  Removing the buffer makes the match channel unbuffered and since the Seek function sends a value to the unbuffered channel without waiting for a receiver this will result in a deadlock.

* What happens if you remove the default-case from the case-statement in the `main` function?
  This won't cause any noticeable change to the program since there will always be a message from someone that isn't received, and the default case will therefore never be called upon.

#### Task 3 - MapReduce

|Variant       | Runtime (ms) |
| ------------ | ------------:|
| singleworker |      34.88ms |
| mapreduce    |       4.10ms |