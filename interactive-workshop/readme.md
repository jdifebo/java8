View the presentation [here](http://jdifebo.github.io/java8/interactive-workshop/presentation.pdf)

This is a modified form of the presentation that allows the audience to write solutions to problems as the presentation goes on.  If you look inside of ```EmployeeManager.java```, the code compiles but is incomplete and does not pass the provided unit tests.  As the presentation progresses, participants should be able to implement all of the methods correctly using lambda expressions.  This interactive workshop will take approximately 1.5 to 2 hours.

To run in Eclipse:

1. Clone/download the project
2. Create a new Java Project in Eclipse, name it whatever you want and hit "Next"
3. Hit "Link additional source" and browse to the interactive-workshop directory and hit "Finish"
4. Choose the "Libraries" tab at the top, hit "Add Library" and select JUnit 4
5. You can now select ```EmployeeManagerTest.java``` and ```Run As -> JUnit Test```.  All of the tests should either fail or have errors, but it should at least compile.

To run in IntelliJ IDEA:

1. Clone/download the project
2. Import Project and browse to the interactive-workshop directory
3. Choose "Create project from existing sources" (the top radio button)
4. Hit "Next" a lot until the project is created
5. Open ```EmployeeManagerTest.java```, place the curser on a ```@Test``` annotation, and hit Alt + Enter.  You should be prompted to add JUnit 4 to classpath.
6. You can now select "Run EmployeeManagerTest"
