#### Exercise 14.1.1

During compile time the compiler only checks the static type of the object. This means that it makes sure that the device class implements the getName method. Therefore only the Device class need to have a definition of the getName method.

#### Exercise 14.1.2

When the method is called during runtime, the JVM will look at the dynamic type of the object that the getName method is called on, so the getName method in the subclass Printer will be the one that is executed.

#### Exercise 14.1.3

The code will compile, if the Student class does not have a declared superclass and does not override the toString method, it inherits the toString method from the Object class. This returns a string with the objects hashcode.

#### Exercise 14.1.4

In the same situation as before the code System.out.println(st) will compile without errors. When executed, it will print the string representation of the Student object, which will be the hashcode.

#### Exercise 14.1.5

Assuming the Student class overrides the toString method to return the student's name, the code will compile without errors. During execution it will iterate over each Student object in myList and print the result of calling the toString method, which will print the names of all the students in myList. If myList is empty, nothing will be printed.

#### Exercise 14.2.2

    addFirst:
    O(1)

    addLast:
    O(1)

    getFirst:
    O(1)

    getLast:
    O(1)

    get:
    O(n)

    removeFirst:
    O(1)

    clear:
    O(1)

    size:
    O(1)

    isEmpty:
   O(1)

    toString:
    O(n)