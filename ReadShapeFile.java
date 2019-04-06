
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Chuks Ajeh (991129)
 * @version 1.5
 * <h1>Version History: </h1>
 *<p>
 *     Version 1.0 original code provided by CS-115 lecturer
 *     Version 1.1 readShapeFile method implementation
 *     Version 1.2 rectangle and Square classes are implemented and methods created in readShapeFile.
 *     Version 1.3 Implementation of the queue class.
 *     Version 1.4 Introduction of Triangle Class and triangle method in readShape File.
 *     Version 1.5 Introduction of pulsing.
 *</p>
 * <h1>Creation Date:</h1>
 * <p>Created on 12/02/2019</p>
 *<h1>Last Modified:</h1>
 * <p>Last modified at 21/03/2019 at 22:49</p>
 * <h1>Copyright Notice</h1>
 * <p>
 *     Not subject to copyright.
 * </p>
 * <h1>Program Purpose:</h1>
 * <p>We create instance of shape methods and read the data from text files
 * and separate them into their respective methods and tokens. the shapes are queued
 * in shapeQueue and displayed in a window</p>
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * @param Line takes in the read line and reads each token within the line
	 * @return returns an instance of the Circle
	 * */
	public static Circle  constructCircle(Scanner Line){
		int x = Line.nextInt();
		int y = Line.nextInt();
		int vx = Line.nextInt();
		int vy = Line.nextInt();
		boolean isFilled = Line.nextBoolean();
		int diameter = Line.nextInt();
		Color colour = Color.rgb(Line.nextInt(),Line.nextInt(),Line.nextInt());
		int insertionTime = Line.nextInt();
		boolean isPulsing = Line.nextBoolean();
		Circle c = new Circle(x, y, vx, vy,isFilled,diameter,colour,insertionTime, isPulsing); /*Create an instance of Circle class*/
		 /*close the scanner when done*/
		//System.out.println(c.toString());
		return c;
	}

	/**
	 * @param Line takes in the read line and reads each token within the line
	 * @return returns an instance of the Oval
	 * */
	public static Oval constructOval(Scanner Line){
		int x = Line.nextInt();
		int y = Line.nextInt();
		int vx = Line.nextInt();
		int vy = Line.nextInt();
		boolean isFilled = Line.nextBoolean();
		int width = Line.nextInt();
		int height = Line.nextInt();
		Color colour = Color.rgb(Line.nextInt(),Line.nextInt(),Line.nextInt()); //set the values of the
		int insertionTime = Line.nextInt();
		boolean isPulsing = Line.nextBoolean();
		Oval o = new Oval ( x,  y,  vx,  vy,isFilled, width, height,colour,insertionTime, isPulsing);
		//System.out.println(o.toString());
		return o;
	}

	/**
	 * @param Line takes in the read line and reads each token within the line
	 * @return returns an instance of the Square
	 * */
	public static Square constructSquare(Scanner Line){
		int x = Line.nextInt();
		int y = Line.nextInt();
		int vx = Line.nextInt();
		int vy = Line.nextInt();
		boolean isFilled = Line.nextBoolean();
		int side = Line.nextInt();
		Color colour = Color.rgb(Line.nextInt(),Line.nextInt(),Line.nextInt());
		int insertionTime = Line.nextInt();
		boolean isPulsing = Line.nextBoolean();
		Square s = new Square(x,y,vx,vy,isFilled,side,colour,insertionTime,isPulsing); /*Create an instance of Circle class*/
		/*close the scanner when done*/
		//System.out.println(s.toString());
		return s;
	}

	/**
	 * @param Line takes in the read line and reads each token within the line
	 * @return returns an instance of the Rectangle
	 * */
	public static Rect constructRect(Scanner Line){
		int x = Line.nextInt();
		int y = Line.nextInt();
		int vx = Line.nextInt();
		int vy = Line.nextInt();
		boolean isFilled = Line.nextBoolean();
		int width = Line.nextInt();
		int height = Line.nextInt();
		Color colour = Color.rgb(Line.nextInt(),Line.nextInt(),Line.nextInt()); //set the values of the
		int insertionTime = Line.nextInt();
		boolean isPulsing = Line.nextBoolean();
		Rect r = new Rect (x,  y,  vx,  vy, isFilled, width, height,colour,insertionTime,isPulsing);
		//System.out.println(r.toString());
		return r;
	}

	/**
	 * @param Line takes in the read line and reads each token within the line
	 * @return returns an instance of the Triangle.
	 * */
	public static Triangle constructTriangle(Scanner Line){
		int x = Line.nextInt();
		int y = Line.nextInt();
		int vx = Line.nextInt();
		int vy = Line.nextInt();
		boolean isFilled = Line.nextBoolean();
		int width = Line.nextInt();
		int height = Line.nextInt();
		Color colour = Color.rgb(Line.nextInt(),Line.nextInt(),Line.nextInt());
		int insertionTime = Line.nextInt();
		boolean isPulsing = Line.nextBoolean();
		Triangle t = new Triangle(x,  y,  vx,  vy,isFilled, width, height,colour,insertionTime,isPulsing); /*Create an instance of Circle class*/
		/*close the scanner when done*/
		//System.out.println(t.toString());
		return t;
	}

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		//read in the shape files and place them on the Queue
		while(in.hasNextLine()){
			Scanner curLine = new Scanner(in.nextLine()); //Looks at the next line of the file.
			String id = curLine.next(); //this checks the first string of the line.
			// To be used as identifier for the line
			if(id.equals("circle")){
				shapeQueue.enqueue(constructCircle(curLine));
			}
			if(id.equals("oval")){
				shapeQueue.enqueue(constructOval(curLine));
			}
			if(id.equals("square")){
				shapeQueue.enqueue(constructSquare(curLine));
			}
			if(id.equals("rect")){
				shapeQueue.enqueue(constructRect(curLine));
			}
			if(id.equals("tri")){
				shapeQueue.enqueue(constructTriangle(curLine));
			}
		}
		return shapeQueue;
	}




	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */

	/*This method works fine*/
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.
		File fileIn = new File(filename); /*open up our file */
	    Scanner in = null;
	    try{
			in = new Scanner (fileIn);
		} catch( FileNotFoundException e){ /*Catch in the event the file is not found.*/
			System.out.println("Can not open file or file does not exist.");
			System.exit(0);
		}
	    return ReadShapeFile.readDataFile(in);
	    
	}



}
