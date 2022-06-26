# Console Drawing Application

A simple drawing application, which uses console for initiating a canvas and painting of lines and rectangles. 
Application also allows filling areas with color represented by character. 
Program accepts user commands through CLI.

## Motivation

I got task to program this application as one of the step during application process for 
Test Automation Engineer position in one of the leading Swiss bank.

## Task assignment

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quite limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit
 
```
Command 		Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behavior of this is the same as that of the "bucket fill" tool in paint
                programs.
Q               Should quit the program.

__Sample I/O__

Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q

```

The expectation is that as TestAutomation Engineer you should be able to complete the exercise and create a good number of Tests and handling errors.

- Please complete the exercise using Java
- Add a README file with instructions on how to run the program
- If there are special cases etc, that are not covered as part of the requirement, please make your own decision on how this should be handled
- If you do make assumptions, please detail why you made them in the readme file

Please take some time to go through it, and build a solution you will be proud to discuss and show to other developers..
Both the test and implementation code will be assessed. This will be primarily, but not solely, based upon: 
 - How comprehensively the code is tested
 - The design choices made when implementing the solution (maintainability, legibility, refactorability, extensibility.)
 - Exception and special case handling
You should aim to implement to a level where you would be happy to have somebody look at it and judge your result.

## Implementation notes

- I decided that input commands are case sensitive. eg. 'Q' is valid command, but 'q' is not.
- I decided to Canvas be singleton. In my application, you can't instantiate more than one canvas.
- You can create new Canvas any time, but you will lose your previous Canvas and all objects drawn on it
	(in this case there is no save, undo-step or warning implemented)
- I decided to evaluate input command against allowed regex. This significantly helps to minimize bad input command cases.
- It is not possible to draw any object (Line, Rectangle) without existing canvas. Application doesn't allow it.
- I decided that you can draw object inside canvas, but also on border position of Canvas. In this case graphical representation 
	of canvas border is replaced by drawn object.
- I decided that it is not allowed to draw objects, which are fully or partially outside of canvas. 
	In this case object won't be drawn at all and user will be notified by error message. Program won't be interrupted.
- You can drawn as many objects over previous objects as you want. Always latest object is displayed on the top. 
- I decided that neither Canvas nor program remember objects which were previously drawn. Objects are drawn on Canvas, but there is no history of objects. 
	As soon as object is drawn, you can't work with it again and its instance is lost. It exists only as imprint on graphical representation of canvas.
	This would be one of the first improvements I would suggest for next iteration.
- Rectangle is drawn by drawing 4 Lines.
- There is lot of unit tests specifically for Canvas, Line, Rectangle, CollorPalette, FloodFill, InputValidator etc. 
- In Smoke tests I put your exactly defined cases from task assignment.
- Most tricky part was to implement algorithm for filling entire area by color. I admit that I used existing recursive algorithm 
	for this implementation. Thank you for possibility to learn something new and interesting.
- Following TDD and writing unit tests first was really useful for this application.


# How to run

Run All tests:

```
mvn test
```

Run application:

```
mvn exec:java
```

You can also run distributed JAR (Java must be set on Path):

```
cd target
java -jar ConsoleDrawingApplication-0.0.1-SNAPSHOT.jar
```


# Suggested Improvements

- learn program to remember all objects drawn in past (save them in some data structure). 
	This would allow operations like undo/redo step, removing or repositioning already drawn objects etc.
- Implement own errors eg. DrawableObjectOutOfCanvas extends ArrayIndexOutOfBoundsException 
	to provide better and more accurate error handling.
- It would be fine to detach even more functionality from main Application.class into 
	specialized classes. Eg. Scanner, InputParser etc. This should free lot of code from main method.









