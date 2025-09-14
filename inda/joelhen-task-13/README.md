# Correctness
First assignment of the year! We shall not beat around the bush, trying to establish correctness can be challenging. However, the aim here is to illustrate how math and programming skills can work together to tell us something that will always be true for our algorithms. Being able to translate between code and math representations is vital and really all we are doing is saying the same thing in different notations.

### 💀 Deadline
This work should be completed before the exercise on **Friday 19th January** (early groups) or **Monday 22nd January** (later groups).

### 👩‍🏫 Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-23/course-instructions#assignments).

### 📝 Preparation
- Read and answer all questions in Module 4: [Correctness](https://qbl.sys.kth.se/sections/dd1338_ht23_algoritmer_och_dat/container/correctness)
- You can access the OLI material both:
  - via Canvas (see the [OLI Torus SE](https://canvas.kth.se/courses/42831/external_tools/4248) link in the left menu)
  - or directly at this [webpage](https://qbl.sys.kth.se/sections/dd1338_ht23_algoritmer_och_dat/container/correctness)

### ✅ Learning Goals
* Understand basic aspects of inheritance in Java
* Use loop invariants to establish correctness
* Use proof by induction to establish correctness
* Use Master Theorem to estimate the time complexity of recursive functions
* Translate between code and math representations when analysing algorithms

### 🚨 Troubleshooting Guide
If you have any questions or problems, follow this procedure: <br/>

1. Look at this week's [posted issues](https://gits-15.sys.kth.se/inda-23/help/issues). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://gits-15.sys.kth.se/inda-23/help/issues/new). Add a descriptive title, beginning with "Task *x*: *summary of problem here*"
3. Ask a TA in person during the [weekly lab](https://queue.csc.kth.se/Queue/INDA). Check your schedule to see when the next lab is.

We encourage you to discuss with your course friends, but **do not share answers**! Similarily, use of AI services  🤖 are great to *help explain things*, but please **do not submit AI-generated solutions** - you must be both responsible for your own solutions and be able to explain them under examination.

### 🏛 Assignment

Please commit any Java code developed to the [`src`](src) folder and any
written answers to the [`docs`](docs) folder.

#### Exercise 13.1.1 - Inheritance

Assume that we have four classes: `Person`, `Teacher`, `Student`, and
`PhDStudent`. `Teacher` and `Student` are both subclasses of `Person`.
`PhDStudent` is a subclass of `Student`.

a. Which of the following assignments are legal, and why or why not?

```java
Person p1 = new Student();
Person p2 = new PhDStudent();
PhDStudent phd1 = new Student();
Teacher t1 = new Person();
Student s1 = new PhDStudent();
```

b. Suppose that we have the following legal declarations and assignments:

```java
Person p1 = new Person();
Person p2 = new Person();
PhDStudent phd1 = new PhDStudent();
Teacher t1 = new Teacher();
Student s1 = new Student();
```

Based on those just mentioned, which of the following assignments are legal,
and why or why not?

```java
s1 = p1;
s1 = p2;
p1 = s1;
t1 = s1;
s1 = phd1;
phd1 = s1;
```

#### Exercise 13.1.2 (src - use `newsfeed`)

The newsfeed project simulates a social media application and uses inheritance to reduce code duplication and improve its software architecture. Review the source code in [`src/newsfeed`](src/newsfeed) and make sure the application works as expected. You can either create your own `main` method in `NewsFeed` to simulate using the newsfeed application, or use an interactive tool like BlueJ instead, e.g.

```Java
public class NewsFeed {

    // ...

    public static void main(String[] args) {
        NewsFeed app = new NewsFeed();
        app.addPost(new PhotoPost("Alice", "photo.jpg", "sunset over the sea"));
        // add more posts
        app.show();

    }
}
```

Then your task is to:

- Create a new type of post, `EventPost`, that _inherits_ from `Post`.
- `EventPost` should have additional fields: `String title`, `String location` and `LocalDate date` to model where and when the event occurs.
- Make sure you follow the example in `PhotoPost` and include `super()` in the constructor method for `EventPost`.
- The `display` method of `EventPost` should print out the above fields in a nice format.
- The `display` method also needs to call `Post.display()` to work correctly. Include `super.display();` as the final line in your `display` method.
- Confirm you can add instances of `EventPost` to the newsfeed application and display it's fields, and its inherited fields.

> **Assistant's note:** LocalDate can be found in the java.time package. To use:
> ```java
> import java.time.*;
> ...
> LocalDate date = LocalDate.of(2021, 1, 1);
> System.out.println(date.toString());
> ```
>
> Note the use of a class method `of` to return an instance.

#### Exercise 13.1.3
Answer these questions about the newsfeed project in [`docs`](docs):

- What behaviour happens if you removed the `extends Post` from the class definition of `EventPost` then call `NewsFeed.addPost`? Explain why you think this happens.
- What behaviour happens if you removed `super()` from the constructor of `EventPost` then call `NewsFeed.show`? Explain why you think this happens.
- What behaviour happens if you removed `super.display()` from the display methods `EventPost`? then call `NewsFeed.show`? Explain why you think this happens.
- When we have two classes with an inheritance relationship and they have a method with the same signature, what is this called?

> **Assistant's note:** Don't forget to revert these changes so that newsfeed works on submission - in fact you have to revert each one to see a difference between each question! :)

#### Exercise 13.2 - Induction Warmup

Using proof by induction, prove the following statements (assume _n_ is a natural number).

(1) ![induction ex 2](img/induction_ex2.png)

(2) ![induction ex 1](img/induction_ex1.png)

> **Assistant's note:** You may wish to solve these exercises by using paper (then taking a picture of your proof, or even better by practicing using LaTeX to generate more complex math equations. The following sourcecode may help and full [template for a proof](docs/template.tex) is provided.)

```latex
(1) $$\sum_{i=1}^{n} i^2 = \frac{n(n+1)(2n+1)}{6}$$
(2) $$\sum_{j=1}^{n} (2j-1) = n^2$$

```

#### Exercise 13.3 - Correctess and Complexity Analysis

Here are two algorithms that calculate x<sup>n</sup>, where x is a real number and n is a non-negative integer. We wish to prove their correctness as well as establish their respective time complexities.

#### Iterative Solution
The first algorithm uses a for loop and is quite easy to understand how it operates.

```java
double expIterative(double x, int n) {
    double res = 1.0;

    for (int i = 0; i < n; i++) {
        res *= x;
    }
    return res;
}
```
It should be relatively simple to substitute simple values to confirm this algorithm does what is expected, e.g. when `x=2` and `n=3` we get the result `8`.

#### Exercise 13.3.1
Provide a loop invarient for `expIterative` that proves its correctness before, during and after the loop has concluded.
> **Assistant's note:** Try to find a relationship between the loop counter `i`
> and the `res` variable.

#### Exercise 13.3.2
Calculate the time-complexity as a function of n for `expIterative`. Give the result using Big-O notation.
> **Assistant's note:** As this is an iterative algorithm then we should just need to find a summation that counts the frequency of the basic operation.

#### Recursive Solution
Now here is a recursive version. It achieves the same result as `expIterative`, but is much harder to see how.

```java
double expRecursive(double x, int n) {
    if (n <= 4) {
        return expIterative(x, n);
    }

    return expRecursive(x, n/2) *
           expRecursive(x, (n + 1)/2);
}
```

To help understand the behaviour of this algorithm, it is worth thinking through some simple exponents. Consider the following progression:

| expression | is composed of | giving the result |
|-----|-------------|--------|
| 2<sup>3</sup> |  2^1 * 2^2  | 8 |
| 2<sup>4</sup> |  2^2 * 2^2 | 16 |
| 2<sup>5</sup> |  2^2 * 2^3 | 32 |
| 2<sup>6</sup> |  2^3 * 2^3 | 64 |
| 2<sup>7</sup> |  2^3 * 2^4 | 128 |
| 2<sup>8</sup> |  2^4 * 2^4 | 256 |

Now notice the pattern. If the exponent is odd (2<sup>3</sup>), the composition is formed by an odd and even exponent (2^1 * 2^2). On the other hand, if the exponent is even (2<sup>4</sup>), both exponents are even.

Now think about how *integer division* works in Java - if we have an expression `int i = 3/2;` then we expect the result to be 1 because integer type cannot represent decimal points or fractional values. The convention here is to think in terms of the `floor function` and round down whenever we any division.

Putting this together, if we fill in some actual values (`x=2` and `n=5`) into the recursive step of the function above, we can see what is happening:

```java
// if x=2 and n=5
return expRecursive(x, n/2) * expRecursive(x, (n + 1)/2);
// becomes
return expRecursive(2, 5/2) * expRecursive(2, (5 + 1)/2);
// which is
return expRecursive(2, 2) * expRecursive(2, 3);
// check the table for 2^5 to confirm
```

Now we can also see how the recursive step converges to the base case and switches to `expIterative` when n <=4.

#### Exercise 13.3.3
Provide a proof by induction for `expRecursive` that proves its correctness. Some tips:
- We already can assume the correctness of `expIterative` for all `n>=0`
- It will help greatly to switch from code to math as soon as possible, so keep the target in mind - expRecursive(x, n) is really just another way of saying x^n.
- When choosing your bases cases for proof by induction, observe when the base case for recursion happens in the algorithm - make sure to choose both even and odd base cases for `n`.
- Keep in mind the effects of integer division at all steps! In math terms we can use the floor function with the funny mirrored 'L' brackets.

> **Assistant's note:** Using LaTeX will really make your proof look professtional and impress me! Don't forget to try the [template for a proof](docs/template.tex)).

#### Exercise 13.3.4
Calculate the time-complexity for `expRecursive` using the Master Theorem. Give the result using Big-O notation. The following steps should help:
  1. Express the algorithm as a recurrence
  2. Find the coefficients for the master theorem in the recurrence
  3. Solve the inequality and look up the time complexity

  > **Assistant's note:** Pro tip: LaTeX helps with writing recurrences using the \begin{case} ... \end{case} environment, which can be added with the \begin{align} ... \end{align} environment.

### 🙏 Acknowledgment
This task was designed by:               <br>
Simon Larsén                             <br>
Anton Lyxell                             <br>
Stefan Nilsson                           <br>
Ric Glassey                              <br>