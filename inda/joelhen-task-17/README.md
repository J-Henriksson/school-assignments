# Trees
Order can be very important to maintain in a datastructure. Whilst lists naturally support sequential ordering (as elements are added), they must be sorted to support natural ordering (such as priority). Hashtables on the other hand give up any guarantee of ordering, but to remain fast for all operations. Binary trees provide a solution that supports ordering without sacrificing too much performance. Furthermore, they are a natural home for recursive thinking as their structure is recursively defined - a tree consists of a root and zero or more sub-trees.

### 💀 Deadline
This work should be completed before the exercise on **Friday 16th February**.

### 👩‍🏫 Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-23/course-instructions#assignments).

### 📝 Preparation
- Read and answer all questions in Module 8: [Trees](https://qbl.sys.kth.se/sections/dd1338_ht23_algoritmer_och_dat/container/trees)
- You can access the OLI material both:
  - via Canvas (see the [OLI Torus SE](https://canvas.kth.se/courses/42831/external_tools/4248) link in the left menu)
  - or directly at this [webpage](https://qbl.sys.kth.se/sections/dd1338_ht23_algoritmer_och_dat/container/trees)

### ✅ Learning Goals
* Implementing a tree in Java
* Implementing recursive and iterative versions of tree algorithms
* Estimating the time complexity of tree operations

### 🚨 Troubleshooting Guide
If you have any questions or problems, follow this procedure: <br/>

1. Look at this week's [posted issues](https://gits-15.sys.kth.se/inda-23/help/issues). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://gits-15.sys.kth.se/inda-23/help/issues/new). Add a descriptive title, beginning with "Task *x*: *summary of problem here*"
3. Ask a TA in person during the [weekly lab](https://queue.csc.kth.se/Queue/INDA). Check your schedule to see when the next lab is.

We encourage you to discuss with your course friends, but **do not share answers**! Similarily, use of AI services  🤖 are great to *help explain things*, but please **do not submit AI-generated solutions** - you must be both responsible for your own solutions and be able to explain them under examination.

### 🏛 Assignment

#### Task 17.1 - Implement a BST
Implement a Binary Search Tree (BST) in Java. As usual, all public methods
should be well-documented.

The keys are Objects that implement the interface `java.lang.Comparable`
(recall the `Box` class from week-11?). A generic class with a type-parameter
that matches classes that implement `Comparable` can be written as follows:

```java
class Tree<T extends Comparable<T>> { ... }
```

Each node in the tree should be represented by an object that contains two
references, one to the left and one to the right sub-tree. Methods with the
following headers must be implemented. Pay careful attention to the instructions
here!

* `public boolean search(T elem)` -- test for presence of a value.
    - Should be implemented iteratively!
* `public boolean insert(T elem)` -- add value to tree; duplicates are not allowed.
  Return true if the element is not already present (and is thus inserted),
  false otherwise.
    - Should be implemented iteratively!
* `public int size()` -- the number of elements in the tree.
    - Should be implemented to run in `O(1)` time.
* `public int height()` -- the height of the tree. The empty tree and the tree
  with only the root node both have height 0.
    - Should be implemented recursively!
    - The height of the empty tree is
      [often undefined](https://web.archive.org/web/20181013022358/https://xlinux.nist.gov/dads/HTML/height.html),
      but we decide that it is 0 (because we need it to be something). Another
      common choice is -1, to differentiate between the empty tree and the
      root-only tree.
* `public int leaves()` -- the number of leaves in the tree.
    - Should be implemented recursively!
* `public String toString()` -- a string describing the tree.
    - Should be implemented recursively!
    - The string should represent the tree in ascending order, like a sorted
      list. E.g, a tree with elements `1`, `54` and `-3` should be represented
      as `[-3, 1, 54]`.
    - Choose the most appropriate traversal technique out of in-, pre- and
      post-order.

You are of course free to add any number of helper methods that you deem
appropriate, but the public API of the class may not be changed.

> **Assistant's requirement:** You should use `Comparable.compareTo` to navigate
> the tree! You can assume that `compareTo` is consistent with `equals`. That
> is to say, `x.compareTo(y) == 0 <==> x.equals(y)`.

#### Task 17.2 - Time Complexity
Calculate the worst-case time complexity for all operations of the BST and
complete the table below.  As usual, motivate your answers.

| Operation (BST)     | Time Complexity (worst case)    |
| ------------------- | ------------------------------- |
| search              |                                 |
| insert              |                                 |
| size                |                                 |
| height              |                                 |
| leaves              |                                 |
| toString            |                                 |

### Testing
The testing this week is simpler than in the previous weeks. There is only the
one test class, at [src/TreeTest.java](src/TreeTest.java), and you are to
implement the methods with the `fail("Not implemented!")` statements.

### 🙏 Acknowledgment
This task was designed by:               <br>
Simon Larsén                             <br>
Anton Lyxell                             <br>
Stefan Nilsson                           <br>
Ric Glassey                              <br>