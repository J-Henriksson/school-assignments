# Indamon, I choose you!

For the second exercise of INDA, you are going to practice modeling objects in Java. You are going to acquaint yourself with the components of a Java class.

### 💀 Deadline
This work should be completed before the exercise, on **Friday 15th September**.

### 👩‍🏫 Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-23/course-instructions#assignments).

### 📝 Preparation

- Read and answer all questions in Module 2: [Looking Inside Classes](https://qbl.sys.kth.se/sections/dd1337_ht23_programmering_prog/container/looking_inside_classes)
- You can access the OLI material both:
  - via Canvas (see the [OLI Torus SE](https://canvas.kth.se/courses/41415/external_tools/4247) link in the left menu)
  - or directly at this [webpage](https://qbl.sys.kth.se/sections/dd1337_ht23_programmering_prog/container/dd1337__programming)


> **Assistant's Note:** The OLI material and tasks might be slightly out of line this year, so it is ok to read ahead if you did not find all the material.

### ✅ Learning Goals

This week's learning goals include:
* Designing Java classes
* Adding instance fields
* Adding a constructor method
* Creating *getters* and *setters*
* Using the dot operator
* Printing to the terminal
* Using the `main` method
* Scope (or *variable shadowing*)

### 🚨 Troubleshooting Guide
If you have any questions or problems, follow this procedure: <br/>

1. Look at this week's [posted issues](https://gits-15.sys.kth.se/inda-23/help/issues). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://gits-15.sys.kth.se/inda-23/help/issues/new). Add a descriptive title, beginning with "Task *x*: *summary of problem here*"
3. Ask a TA in person during the [weekly lab](https://queue.csc.kth.se/Queue/INDA). Check your schedule to see when the next lab is.

We encourage you to discuss with your course friends, but **do not share answers**!

### 🏛 Assignment

At the Campus of the Royal Institute of Technology in Stockholm, Sweden, there exists a mythical creature called *Indamon*. Your task at hand is to model these mythical creatures in Java! No one is alive to tell the story of how these creatures look, but with the help of [modern technology](https://huggingface.co/spaces/dalle-mini/dalle-mini) we have generated some pictures to spur your imagination:

<img src="images/Indamons.png" width="800">

If you are already familiar with `classes` and `objects`, you may want to skip directly to exercise 2.2 -- Fields. We won't look at the code you write for the two first tasks, but it might be a good idea to go through these exercises if you are new to classes and objects. 

#### Exercise 2.0 Our indamon journey begins!

> **Assistant's Note:** If you are familiar with the benefits of Object-Oriented Programming, you may skip exercise 2.0 and 2.1.

To get started, create a new Java file called `Indamon.java` in the [`src`](src) folder. This file will serve as the home for the `Indamon` class. Once the file is created, proceed to define the class `Indamon`within it.

Now, let's move on to creating our very first indamon. Add the main method provided in Example 1 to your indamon class. Then create the variables listed below in the main method and assign the corresponding values.  

- `String` name : Glassey
- `int` hp (**hit points**) : 10
- `int` attack : 5
- `int` defense : 5
- `boolean` fainted : false


<details>
  <summary> 🛠 Example 1 </summary>
 
  ```java
  class Indamon {

    public static void main(String[] args) {
      // Create your variables here!

      // Print information of the assigned values
      System.out.println("This is your first indamon: ");
      System.out.println("Name: " + name);
      System.out.println("HP: " + hp);
      System.out.println("Attack value: " + attack);
      System.out.println("Defense value: " + defense);
      System.out.println("Has fainted: " + fainted);
    } // end main method

  } // end class
  ```
</details>

Test your code and check that everything works before continuing.

#### Exercise 2.1 More indamons
In the previous exercise, you successfully created an indamon. However, the indamon realm is vast, and there are many more fascinating creatures to discover. Let's broaden our horizons by creating two additional indamons, bringing the total count to three. Just like before, we'll print the information of all three indamons to the console. 

> **Assistant's Note:** It might be effective to copy-paste the code you already have and rename the variables. 

While this approach works, it has its limitations and potential problems:
1. Limited Scalability: Creating indamons individually becomes impractical when dealing with a large number of them. Imagine having to create hundreds or even thousands of indamons using this manual approach! It would be highly inefficient and prone to errors.
2. Maintenance Challenges: If you need to make changes or updates to the indamon creation process, you would have to replicate those changes across all the manually created indamons. This increases the risk of inconsistencies and can be time-consuming.

However, Java provides a much more powerful solution: Classes and `objects`. 

<details>
    <summary> 📚 What are objects? </summary>
    
In Java, a class serves as a blueprint or template for creating something called an `object`. An object can be thought of as a concrete representation of a concept or entity. Think of it as a container that holds information and provides functionality related to that particular concept.

To better understand this, let's consider an example using the Indamon class. In our case, the Indamon class acts as a blueprint that defines the characteristics and behaviors shared by all indamons. These characteristics may include their name, HP (Hit Points), attack power, defense capability, and whether they have fainted or not.

When we create an object from the Indamon class, it's like bringing that blueprint to life and constructing a unique indamon with its own set of attributes. Each object is independent and can have different values assigned to its variables. For instance, we can create multiple indamons, each with its name, hp, attack power, defense, and fainted status.
</details>

By using classes and objects, we can easily create, manage, and manipulate data in a structured way. The class provides the blueprint or template, defining the common properties and behaviors, while the objects are the actual instances that possess specific values and behaviors based on that blueprint. In the next task, we will recreate our first indamon as an object. 

#### Exercise 2.2 -- Fields
Let's create the indamon class from the start. If you skipped the two first tasks, create a new Java file called `Indamon.java` in the [`src`](src) folder and define the class `Indamon`within it containing a main method. If you followed exercises 2.0 and 2.1, clear the main method from its content. Instead of creating the variables to store the indamons data inside of the main method, we want to use [fields](https://docs.oracle.com/javase/tutorial/java/javaOO/variables.html). Fields are just variables that belong to a specific class or object and represent the state of that object. They are written outside of the main method but within the class itself. Create the following fields for the Indamon class but don't assign any values to them yet! 

- `String` name 
- `int` hp (**hit points**) 
- `int` attack 
- `int` defense 
- `boolean` fainted 

Then you must create a new indamon object inside the main method. Have a look at the Class outline-example for help!

<details>
  <summary> 🛠 Class outline </summary>
 
  ```java
  class Indamon {
  
    // put your fields here!

    public static void main(String[] args) {
      // Create a new "Indamon" object
      Indamon glassey = new Indamon();
    } // end main method

  } // end class
  ```
</details>

You have now created new object from the class `Indamon`. The left-hand side is just like creating any other variable. `Indamon` specifies the variable type and `glassey` the variables name. The right-hand side however is a bit different. In Java, the `new` keyword is used to create a new object from a class. After the `new` keyword we have to specify what we want to create. In this case, it is just an empty indamon. 

<details>
    <summary> 📚 Why use the "new" keyword? </summary>

Classes are a bit different from normal variables such as `int` and `boolean`. One key difference is that there is no set size for objects. Booleans can only have two states; true and false, integers can only range between -2.147.483.648 and 2.147.483.647, and so on. However, your class may contain `x` booleans and `y` integers, so Java has to figure out how much memory to allocate to your new object. By calling the `new` keyword, Java does exactly that. 

Later in this task, we will learn about the `constructor` which is the method used to initialize objects of that class. It is called when you create a new instance (object) of the class using the `new` keyword.

  ---
</details>

To access the fields of an object we use a dot (.) operator followed by the field name we want to access. For example, we can access glassey's name by writing `glassey.name` or his hp by writing `glassey.hp`. This can be used both to read and write to the fields of an object directly from our main method. Assign the below values to `glassey`:

- `String` name : Glassey
- `int` hp (**hit points**) : 10
- `int` attack : 5
- `int` defense : 5
- `boolean` fainted : false

> **Assistant's Note:** Initializing fields without assigning a specific value will give them a default value. `int` will automatically be set to `0`, `boolean` will automatically be set to `false`, and so on. The complete list is available in [Oracle's official documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html).

If done correctly, the main method provided in Example 2 should compile and print the correct information about glassey if added to `Indamon.java`.

<details>
  <summary> 🛠 Example 2 </summary>
  <!-- it need to be a blankspace here! -->

  ```java
  class Indamon {

    // Put your fields here!

    public static void main(String[] args) {
      // Create a new "Indamon" object
      Indamon glassey = new Indamon();

      // Assign values to the glassey object here! 

      // Print the information of the assigned values
      System.out.println("Name: " + glassey.name);
      System.out.println("HP: " + glassey.hp);
      System.out.println("Attack value: " + glassey.attack);
      System.out.println("Defense value: " + glassey.defense);
      System.out.println("Fainted status: " + glassey.fainted);
    } // end main method

  } // end class
  ```
</details>

#### Exercise 2.3 -- Getters and Setters
A defining concept in object-oriented programming is [encapsulation](https://en.wikipedia.org/wiki/Encapsulation_(computer_programming)). Encapsulation means preventing direct access to the state of your indamon from outside the object. This can be done by setting the [access modifiers](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html) of the fields in the indamon class to `private`.

However, we might still want to be able to read from and write to the fields.
We can do this by adding **accessors** and **mutators** (so-called *getters* and *setters* methods). 

<details>
    <summary> 📚 Why use accessors and mutators? </summary>
    
In Java, we use accessors (also known as getters) and mutators (also known as setters) to enhance the security and flexibility of our code.

Here's a simpler explanation: Let's say you have a safe deposit where you keep important information. If everyone can access and change what's in the deposit, things might get messy or lost. So, you want to control who can see and change that information.

Accessors (a.k.a *getters*) are like security guards who check someone's ID before letting them see what's inside the safe deposit. Mutators (a.k.a *setters*), on the other hand, are like guards who ensure someone has the right permission before they can change what's inside.

So, we use accessors and mutators in Java to protect our important information (data), ensure it's managed correctly, and keep our safe deposit (or Java class) tidy and secure.

    The usage of `accessors` and `modifiers` in this exercise is primarily to make you familiar with them.
</details>

Now you are facing a potential pitfall. If an argument and a field share the same name in a method, the argument takes priority inside that method. This means the argument's value is used, not the field's. We call this 'variable shadowing', and we'll talk more about it in the last exercise.

In this case you have two options: 1) use a different argument name, e.g `parameterHp`, or, 2) use the keyword `this` before the field's name to signal that you want to alter the current object's field. The second option is always preferable. 

All fields should be accompanied by *getters* and *setters*, which makes a total of ten methods! Make sure they all follow the naming convention `getXXX`/`setXXX` where `XXX` is the name of the field your working with. For example, to set the `name` field we would create a setter method called `setName` and a getter method called `getName`. 

> **Assistant's Note:** The getters and setters of a field of `boolean` type follows a different naming convention from the usual `getXXX` and `setXXX`: `isFainted()` and `setFainted()`.

For now, we will just set and retrieve the values without any restriction, but in later exercises, this is where we will prevent some unwanted behavior. 

To use the setters and getters we use the dot (.) operator just like we did to access the objects fields. If done correctly, the provided main method in Example 3 should compile, if added to `Indamon.java`.

<details>
  <summary> 🛠 Example 3 </summary>
  <!-- it need to be a blankspace here! -->

  ```java
  class Indamon {

    // Put your fields here!

    // Put your getters and setters here!

    public static void main(String[] args) {
      // Create a new "Indamon" object
      Indamon glassey = new Indamon();

      // Assign values to the glassey object 
      glassey.setName("Glassey");
      glassey.setHp(10);
      glassey.setAttack(5);
      glassey.setDefense(2);

      // get the information of the assigned values
      System.out.println("Name: " + glassey.getName());
      System.out.println("HP: " + glassey.getHp());
      System.out.println("Attack value: " + glassey.getAttack());
      System.out.println("Defense value: " + glassey.getDefense());
      System.out.println("Is fainted: " + glassey.isFainted());
    } // end main method

  } // end class
  ```
</details>

#### Exercise 2.4 -- Constructor
Example 3 might seem tedious as you're setting each field value individually. A more efficient way is to use a constructor. Constructors let you provide all the attribute values at once when you create a new object. They take in these values as arguments, and then assign them to the fields, either directly or using mutators.

Implement a constructor following the examples in the OLI material (or the [Official Oracle tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)) for the indamon class.

Instead of calling each setter from the main method we can now directly pass all information we need to each indamon when we initialize it. Remember how we initialized a new instance of the indamon class before? Here is a reminder:

```java
Indamon glassey = new Indamon();
```
Here `Indamon()` is a call to the constructor method. Inside the parenthesis, we can pass all the information we need to the constructor just like we would to any other method. Simply pass the values you want to set for your indamon when initializing it. 

Replace the `accessors` used to assign values with a call to the constructor. Since the values you provide will be passed to the constructor so the `accessors` won't be needed anymore. If your constructor is correctly set up, Example 4 should compile. 

<details>
  <summary> 🛠 Example 4 </summary>

  ```java
  class Indamon {

    // Put your fields here!

    // Put your constructor here!

    // Put your getters and setters here!
  
    public static void main(String[] args){
      // Create a new "Indamon" object called glassey with arguments here!

      // get the information of the assigned values
      System.out.println("Name: " + glassey.getName());
      System.out.println("HP: " + glassey.getHp());
      System.out.println("Attack value: " + glassey.getAttack());
      System.out.println("Defense value: " + glassey.getDefense());
      System.out.println("Is fainted: " + glassey.isFainted());
    } // end main method

  } // end class
  ```
</details>

If you want to change any of the fields later, you can still call the setter methods as before. 

#### Exercise 2.5 -- More indamons, (again)
Add two more indamon objects using the constructor. Compared to the previous approach, it should now be clear how much more efficient and compact it is to wrap functionality inside a class.

#### Exercise 2.6 -- `printInfo()`
By adding a class we have improved the scalability and maintainability of the indamons. Let's also improve the way we print the indamons information to the terminal. Take a look at Example 5 and implement a method called `printInfo()`. The return type should be `void`. 

<details>
  <summary> 🛠 Example 5 </summary>

  ```java
  public static void main(String[] args){
    // Create a new "Indamon" object called glassey with arguments here!

    // Print information
    glassey.printInfo();
  }
  ```

  This call should print a message to the terminal:

  ```
  > INFO
  > Indamon: Glassey.
  > HP: 10
  > Attack: 5
  > Defense: 2
  > Fainted: false
  ```

</details>

#### Exercise 2.7 -- Indamon, attack!
Indamons are fierce creatures, and now we want to model a fight between them. To abstract this new functionality you must implement a method called `attack` which will receive an indamon object as an argument that represents the opponent in battle. If indamon *A* is attacking indamon *B*, the damage done is following the formula: 

<img src="images/indamon-attack.jpg" alt="Indamon, attack!" width="400"/>

To follow the events of the battle, you should print them to the console. During the attack, we also want to update the hp of the target so that it loses hp if attacked multiple times. 

Inside the `attack` method you can access and modify the fields just like you did in the main method. The only difference is that you do so on the indamon object passed to the method. In later tasks, we will discuss how this works but we won't dive any deeper into this right now.

> **Assistant's Note:** When determining the return type of a method, consider the expected outcome and any instructions provided about the return process. Utilize the getter and setter methods to modify the object's value.

<details>
  <summary> 🛠 Example 6 </summary>

  ```java
  public static void main(String[] args){
    // Create two new "indamon" objects called glassey and siberov

    // Call the "attack" method 
    glassey.attack(siberov);

  }
  ```

  This call should print a similar message to the terminal:

  ```
  > Indamon Glassey attacked indamon Siberov for 1 damage! 
  > Indamon Siberov has 9 hp left!
  ```

</details>

#### Exercise 2.8 -- Variable Shadowing
Take a look at the *Variable shadowing*-examples below. You might be asked to explain how to fix this example in class, so be prepared.

You can look at the article on Variable Shadowing on [Wikipedia](https://en.wikipedia.org/wiki/Variable_shadowing) and how the Java keyword [this](https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html) works.


```Java
public class Shadow1 {
    private int number = 0; // I want this number printed :(

    public void printShadow() {
        int number = 5;
        System.out.println(number); // It is printing the wrong number :(
    }
    
    public static void main(String[] args){
        new Shadow().printShadow();
    }
}
```

Here is another example:

```Java
import java.awt.Color;

public class Horse {
  private String name;
  private Color color;
  
  public Horse(String name, Color color) {
    name = name; // this doesn't work :( Why?
    color = color;
  }
  
  public void neigh(){
    String name = "Uncle Dolan";
    System.out.println(name + " neighs! Eiiigha!"); // It is printing the wrong name :( 
  }
}
```

> **Assistant's Note:** Think about the *local scope*, *global variables* and *instance fields* of the provided examples.

### ❎ Checklist 
- [ ] **OPTIONAL:** Create three indamons directly in the main method and print their information to the console. Delete this code when done. 
- [ ] Create five fields for the indamon class: `String name`, `int hp`, `int attack`, `int defense`, and `boolean fainted`. Test modifying their values directly using the dot operator on an indamon object.
- [ ] Create getters and setters for all fields, and use these to access and modify the indamons fields. 
- [ ] Create a constructor method for the indamon class and create a few indamons using the constructor only.
- [ ] Make the `printInfo()` method that prints all information about the indamon, (name, hp, attack, defense, and fainted status). 
- [ ] Create an `attack()` method so indamons can attack each other. The method should take the indamon which is being attacked as an argument and print the events of the battle. 
- [ ] Look at the variable shadowing examples.

> **Assistant's note:** We have added this checklist for you to make a final check before handing in your work. You don't have to tick the boxes unless you want to (to tick a box, place an "x" within the brackets when editing the README.md)

### 🐞 Bugs and errors?
If you find any inconsistences or errors in this exercise, please open a [New Issue](https://gits-15.sys.kth.se/inda-23/help/issues/new) with the title "Task *x* Error: *summary of error here*". Found bugs will be rewarded by mentions in the acknowledgment section.

### 🙏  Acknowledgment
This task was designed by                <br>
[Linus Östlund](mailto:linusost@kth.se)  <br>
[Sofia Bobadilla](mailto:sofbob@kth.se)  <br>
[Gabriel Skoglund](mailto:gabsko@kth.se) <br>
[Arvid Siberov](mailto:asiberov@kth.se)  <br>
[Alexander Runebou](mailto:alerun@kth.se)<br>

Proofreading & Bug fixes by <br>
[Mattias Kvist]() <br>
