If written answers are required, you can add them to this file. Just copy the
relevant questions from the root of the repo, preferably in
[Markdown](https://guides.github.com/features/mastering-markdown/) format :)

#### Task 1

##### Buggy Code 1
1. The issue with the original code is that it attempts to send a value into 
an unbuffered channel without the presence of a receiver, which causes a deadlock.
2. To fix this I just made the channel buffered with a capacity of 1 which allowed the 
value to be stored and then printed in the print statement.

##### Buggy Code 2
1. The issue with the orignal code is that the main function
closes the ch channel before all values 1-11 have been sent and processed by
the Print goroutine. This leads to the Print function ending
before it has printing all intended values.
2. To fix this I just wait group to ensure that the main function waits
for the Print goroutine to finish printing all values before the channel is closed.

#### Task 2

| Question | What I expected | What happened | Why I believe this happened |
|-|-|-|-|
| What happens if you do X? |  Program would still work as before | Program ended up in a deadlock | Because of reasons 🤷 |
| What happens if you switch the order of the statements `wgp.Wait()` and `close(ch)` in the end of the `main` function? | I expected the channel would close before all producers finished. | Terminal generates a panic error | This happens because closing the channel prematurely prevents producers from sending all of their strings |
| What happens if you move the `close(ch)` from the `main` function and instead close the channel in the end of the function `Produce`?  | I expected the channel to be closed after each producer finishes producing its strings. | Terminal generates the panic error "panic: send on closed channel" | Since the close(ch) statement is called each time a producer finishes producing its strings, any communication with the channel afterwards will result in this error. |
| What happens if you remove the statement `close(ch)` completely?  | I expected the program to continue running indefinitely |The program does not run indefinitely but it takes slightly more time. | The program doesn't run indefinitely because the main function still waits for all producers to finish before exiting |
| What happens if you increase the number of consumers from 2 to 4?  | Program would still work as before | The time taken for the program to run was considerably reduced. | Allocating more consumers to serve the same producers improves parallelism and leads to the, on average faster program execution |
| Can you be sure that all strings are printed before the program stops?  | Yes | They are | | Because all producers are waited upon to finish before closing the channel |