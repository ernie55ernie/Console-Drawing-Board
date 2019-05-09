Console Drawing Board
============
Console Drawing Board is a Java program that provides a console interface and draws figures:
- Drawing rectangles and triangles in a 50 * 50 grid
- Erase any drawn figure
- Center any drawn figure

You can add more figures and functions by modifying the code.

- [How to Use](#how-to-use)
- [How to Run](#how-to-run)
- [More about this program](#more-about-this-program)

### How to Use

- At the start of the program, you can either enter 1 to draw a rectangle or a triangle or perform a sequence of example including drawing, erasing, and centering.  
![Start of the program](https://raw.githubusercontent.com/ernie55ernie/ConsoleDrawingBoard/master/img/initialize.PNG)
- After entering 1 to draw, you can draw a rectangle (enter 1) and specify the weight, height, and the center of this rectangle.  
![Draw a rectangle](https://raw.githubusercontent.com/ernie55ernie/ConsoleDrawingBoard/master/img/rectangle.PNG)
- After entering 1 to draw, you can draw a triangle (enter 2) and specify the locations of three vertices.  
![Draw a triangle (input)](https://raw.githubusercontent.com/ernie55ernie/ConsoleDrawingBoard/master/img/triangle-1.PNG)  
![Draw a triangle (result)](https://raw.githubusercontent.com/ernie55ernie/ConsoleDrawingBoard/master/img/triangle-2.PNG)
- To erase a triangle, enter 2 and then enter the number of a triange (2 in this case).  
![erase a triangle (result)](https://raw.githubusercontent.com/ernie55ernie/ConsoleDrawingBoard/master/img/delete-1.PNG)
- To center a rectangle, enter 3 and then enter the number of a rectangle (1 in this case).  
![Center a rectangle (result)](https://raw.githubusercontent.com/ernie55ernie/ConsoleDrawingBoard/master/img/center-1.PNG)
- To exit the console, enter 5.  
![Exit](https://raw.githubusercontent.com/ernie55ernie/ConsoleDrawingBoard/master/img/exit.PNG)

### How to Run
This project is built in [Eclipse](https://www.eclipse.org/)
The process of importing this project into [Eclipse](https://www.eclipse.org/) is below.
1. Open Eclipse
2. File -> New -> Java Project -> Enter project name as ConsoleDrawingBoard
3. Uncheck the checkbox of use default location -> select the folder of the cloned repository -> Finish
4. Open this project
5. Click on src -> default packge
6. Select ConsoleBoard.java and right click -> Run as 1.Java Application
7. Enter 4 to perform the example usage of this drawing board  
It will launch a thread to trigger keyboard events to 
    1. create a rectangle
    2. create a triangle
    3. erase a triangle
    4. create a triangle
    5. create a rectangle
    6. center a rectangle
    7. center a triangle
    8. center a rectangle
    9. delete a rectangle
    10. delete a triangle
    11. delete a rectangle
    12. exit the console

Here is a [youtube video](http://www.youtube.com/watch?v=CJoeA0b90B8) shown how to open this program in [Eclipse](https://www.eclipse.org/).

[![](http://img.youtube.com/vi/CJoeA0b90B8/0.jpg)](http://www.youtube.com/watch?v=CJoeA0b90B8 "Youtube Video")

### More about this program
Detailed descrptions about this program is in this blog post [Console Drawing Board with Java](https://ernie55ernie.github.io/java/2019/05/09/console-drawing-board-with-java.html).