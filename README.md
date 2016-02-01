# java8
This repository contains several examples of lambda expressions and the Stream API

There are only 3 classes:

 - `Employee.java` - A very simple class that we can test out our streams on.
 - `EmployeeManager.java` - Here's where the Java 8 code is.  There are 12 different methods, each showing an example of one or more stream operations in use.  There is also commented out code to show an equivalent method without streams or lambda expressions.
 - `Main.java` - Contains the main method and tests out each of the methods in `EmployeeManager.java`with simple `println` statements.

Between the 12 methods, various combinations of the following operations are used: `anymatch`, `allmatch`, `max`, `map`, `collect`, `filter`, `count`, `distinct`, `findAny`, `sorted`, `limit`, `mapToInt`, and `average`.  Peek inside to have a look!
