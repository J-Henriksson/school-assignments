# Welcome to DD1338 

This week the focus is on maniuplating ArrayLists and arrays, as well as using recursion in simple algorithms.

### 💀 Deadline
This work should be completed before the exercise on **Friday 24th November**.

### 👩‍🏫 Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-23/course-instructions#assignments).

### 📝 Preparation
- Read the [DD1338 specific course instructions](https://gits-15.sys.kth.se/inda-23/course-instructions/tree/master/DD1338/README.md)
- Review the [general INDA instructions](https://gits-15.sys.kth.se/inda-23/course-instructions).
- Read and answer all questions in Module 1: [Algorithms](https://qbl.sys.kth.se/sections/dd1338_ht23_algoritmer_och_dat/container/algorithms)
- You can access the OLI material both:
  - via Canvas (see the [OLI Torus SE](https://canvas.kth.se/courses/42831/external_tools/4248) link in the left menu)
  - or directly at this [webpage](https://qbl.sys.kth.se/sections/dd1338_ht23_algoritmer_och_dat/container/algorithms)

An important part of each task is testing. We provide an almost complete test suite where relevant and you should use this to test your implementation. We also expect you to complete the test suite where test methods are incomplete. If you need a reminder of running unittests in Java, follow these guides:

- [Running JUnit4 from the command line](https://gits-15.sys.kth.se/inda-23/course-instructions/blob/master/junit4_12_command_line.md)
- [Using IntelliJ with JUnit4](https://www.youtube.com/watch?v=HU0Ittkjx4Y)

### ✅ Learning Goals
* Using arrays and ArrayLists
* Using recursion in algorithms
* Running unit tests against your implementation

### 🚨 Troubleshooting Guide
If you have any questions or problems, follow this procedure: <br/>

1. Look at this week's [posted issues](https://gits-15.sys.kth.se/inda-23/help/issues). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://gits-15.sys.kth.se/inda-23/help/issues/new). Add a descriptive title, beginning with "Task *x*: *summary of problem here*"
3. Ask a TA in person during the [weekly lab](https://queue.csc.kth.se/Queue/INDA). Check your schedule to see when the next lab is.

We encourage you to discuss with your course friends, but **do not share answers**!

### 🏛 Assignment
In this assignment, you will perform basic list processing tasks using both the
primitive array and lists from the Collections hierarchy.  It is important that
you can implement algorithms in either form.  Collectively, we shall refer to
both `int[]` number and `List<Integer>` as "lists of numbers" in this
assignment. Please commit any Java code developed to the [`src`](src) folder and any
written answers to the [`docs`](docs) folder.

This week, you've been given the a complete reference test class. Take advantage of this and run it as you are implementing each of your methods. You can find it here: [`ListProcessorTest`](src/ListProcessorTest.java).

#### Exercise 10.0 -- Setup
- Create a Java class called `ListProcessor` in [`src`](src)
  - `ListProcessor` will contain all of the following methods specified in the following exercises
  - You must use the method signatures provided (as usual)
  - You must document with Javadoc appropriately (both class and methods)
  - You may also include a main method if desired for informal testing

#### Exercise 10.1 -- Populating Lists
Implement methods with the following headers:

```java
public int[] arraySequence(int from, int to)
```

and

```java
public List<Integer> listSequence(int from, int to)`
```

These methods should return populated lists with integer values in the range
from the lower bound `from` (inclusive) until the upper bound `to` (exclusive).

e.g. `arraySequence(0, 5);` should return the following array `[0,1,2,3,4]`

**Special cases:**
1. If `from == to`, an empty list should be returned.

2. If `to < from`, an `IllegalArgumentException` should be thrown.

#### Exercise 10.2 -- Shuffling Lists
Implement methods with the following headers:

```java
public int[] shuffled(int[] numbers)
```

and

```java
public List<Integer> shuffled(List<Integer> numbers)
```

These methods should return a shuffled list of numbers, by randomly swapping
elements to randomise the ordering.

> **Assistant's requirement:** You are not allowed to use
> `Collections.shuffle()`, and the argument list should _not_ be mutated.
> That is to say, you must make a local copy of the argument.

> **Assistant's note:** These two methods, as well as the pairs in exercise 3
> and 4 are _overloaded_. In short, the compiler can distinguish between two
> methods with the same name based on the _type(s)_ of the parameter(s) it is passed.
> Overloading should be used sparingly as it can affect readability, but in
> this case, it is reasonable to say that the programmer should know whether
> he/she is shuffling a list or an array, so naming the methods `shuffleArray`
> and `shuffleList` instead adds no extra information. Note that you cannot
> overload by _return type_, as overloading works only by looking at different
> signatures. For the official definition (with examples), please see
> [Overloading Methods section at the bottom of this page](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html#overloading-methods).

#### Exercise 10.3 -- Summing Lists Iteratively
Implement methods with the following headers:

```java
public int sumIterative(int[] numbers)
```

and

```java
public int sumIterative(List<Integer> numbers)
```

These methods should return the sum of a list of numbers using iteration.

**Special cases:**
1. The sum of an empty list should be 0.

> **Assistant's requirement:** Again, the argument should _not_ be mutated.

#### Exercise 10.4 -- Summing Lists Recursively
Implement methods with the following headers:

```java
public int sumRecursive(int[] numbers)
```

and

```java
public int sumRecursive(List<Integer> numbers)
```

These methods should do exactly the same thing as the ones in Exercise 3, but using
recursion instead of iteration. There are several strategies that you may use
here. You may also create private helper methods if required. Finally, there
are some useful methods in `java.util.Arrays` and `java.util.ArrayList` that may
help depending on your strategy.

> **Assistant's requirement:** Again, the argument should _not_ be mutated.

#### Exercise 10.5 -- Testing
For this week's tests, you have been provided with a fully implemented test
class at [`ListProcessorTest.java`](src/ListProcessorTest.java). This
is the actual reference test class that the assistants use to verify your code,
meaning that if your code passes the tests, it's considered good enough in
terms of functionality - so run them before pushing so you are sure! 

For more information on how the unit tests are structured,
refer to the [DD1338 specific course instructions](https://gits-15.sys.kth.se/inda-23/course-instructions/tree/master/DD1338/README.md).

> **Assistant's note:** We have commented out two test cases as they deal with
> fairness in shuffle algorithms. We talk about this next week, but if you are
> curious you can uncomment them and try them, but do not worry if they do not
> pass.

### 🐞 Bugs and errors?
If you find any inconsistencies (spelling errors, grammatically incorrect sentences et c) or errors in this exercise, please open a [New Issue](https://gits-15.sys.kth.se/inda-23/help/issues/new) with the title "Task *x* Error: *summary of error here*". Found bugs will be rewarded by mentions in the acknowledgment section.

### 🙏 Acknowledgment
This task was designed by:               <br>
Simon Larsén                             <br>
Anton Lyxell                             <br>
Stefan Nilsson                           <br>
Ric Glassey                              <br>
