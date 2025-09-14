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
Legal
A superclass is allowed to hold an object of the subclass.

Legal
A superclass is allowed to hold an object of the subclass (even though it's a subclass of a subclass to the superclass).

Illegal
A reference of the subclass cannot hold an object of the superclass.

Illegal
A reference of the subclass cannot hold an object of the superclass.

Legal
A superclass is allowed to hold an object of the subclass (even though Student is a subclass to Person it's still a superclass to PhDStudent)


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

Illegal
You can't assign an instance of the superclass to a reference of the subclass.

Illegal
You can't assign an instance of the superclass to a reference of the subclass.

Legal
You can assign an instance of the subclass to a reference of the superclass since a subclass object can be treated as an instance of its superclass.

Illegal
You can't assign an instance of the subclass to a reference of another subclass.

Legal
You can assign an instance of a subclass to it's superclass even though the superclass is also a subclass to another superclass.

Illegal
You can't assign an instance of the superclass to a reference of the subclass.

#### Exercise 13.1.3
Answer these questions about the newsfeed project in [`docs`](docs):

- What behaviour happens if you removed the `extends Post` from the class definition of `EventPost` then call `NewsFeed.addPost`? Explain why you think this happens.
- What behaviour happens if you removed `super()` from the constructor of `EventPost` then call `NewsFeed.show`? Explain why you think this happens.
- What behaviour happens if you removed `super.display()` from the display methods `EventPost`? then call `NewsFeed.show`? Explain why you think this happens.
- When we have two classes with an inheritance relationship and they have a method with the same signature, what is this called?

1. 
Removing "the extends Post" from the class definition makes it so that EventPost no longer inherits from the Post class. This means that EventPost will no longer be a subtype of Post, and you won't be able to add an instance of EventPost to the NewsFeed using the addPost method, which expects a Post as a parameter. This incongruency will cause a compile error.

2. 
The "super()" in the constructor of EventPost is used to invoke the constructor of the superclass. If it's removed the author field of the superclass won't be initialized and the error message: "Implicit super constructor Post() is undefined. Must explicitly invoke another constructor".

3.
The display method from the superclass (Post) won't be called and a lot of information regarding the post won't be displayed when running the NewsFeed class.

4.
It's called method overriding

As there are more math than code this week, it is a very good opportunity to practice using LaTeX skills; love it or hate it, one of the main reasons for LaTeX is to typeset math beautifully. Whilst you can submit a scan of a handwritten proof, do consider taking the time to convert it to LaTeX, as it will greatly ease the job of your TA.

- Template for LaTeX Proof ([pdf](template.pdf), [tex](template.tex)) - this will get you started
- [LaTeX Math for Undergrads](undergradmath.pdf) - this will cover almost any symbol you need

#### Exercise 13.3.1

```java
double expIterative(double x, int n) {
    double res = 1.0;

    for (int i = 0; i < n; i++) {
        // Invariant: res = x^i 
        res *= x;
    }
    return res;
}
```

#### Exercise 13.3.2

```java
double expIterative(double x, int n) {
    double res = 1.0;

    for (int i = 0; i < n; i++) {
        // Invariant: res = x^i 
        res *= x;
    }
    return res;
}
```

1 operation in the first line from the assignment of the res variable.

1 operation from the initialization i, n + 1 operations from the comparison, and n operations from the incrimination of i

n operations from within the for loop (if res *= counts as 1 operation instead of 2) 
1 operation from the return statement.

This makes it so that the total amount of operations as a function of n can be expressed as:
T(n) = 1 + 1 + n + 1 + n + n + 1 = 3n + 4
Meaning that the time complexity and Big-O notation will be O(n).

#### Exercise 13.3.4

```java
double expRecursive(double x, int n) {
    if (n <= 4) {
        return expIterative(x, n);
    }

    return expRecursive(x, n/2) *
           expRecursive(x, (n + 1)/2);
}
```

In the given recursive function expRecursive, each recursive call generates two subproblems, each of size n/2​. Therefore, a=2 because there are two recursive branches per recursive call.

The problem size is divided in half in each recursive call, leading to b=2.

For the amount of work per recursive call, each call performs a constant amount of work (computing the product of the two numbers) therefore, c=2.

Now, applying the Master Theorem, since a=2, b=2, and c=1, the case were a = b^c is fulfilled, and the time complexity is O(n * log(n)).