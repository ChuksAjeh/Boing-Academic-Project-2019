


/**
 * Circle.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Circle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the circle's bounding rectangle.
 */

public class Circle extends ClosedShape {
    //The diameter of the circle
	private int diameter;
	private int min, max;

	/**
	 * Creates an Circle.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the circle (in pixels).
	 * @param height The height of the circle (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the circle is filled with colour, false if opaque.
	 * @param isPulsing true if the circle is resizing false if not.
	 */
    public Circle (int x, int y, int vx, int vy,  boolean isFilled, int diameter, Color colour,int insertionTime,boolean isPulsing) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled,isPulsing);
    	this.diameter = diameter;
		this.max = diameter*2;
		this.min = diameter/2;
    }
    
    /**
     * Method to convert a circle to a string.
     */
    public String toString () {
    	String result = "This is a circle\n";
    	result += super.toString ();
	result += "Its diameter is " + this.diameter + "\n";
    	return result;
    }
    
    /**
     * @param Resets the diameter.
     */
    public void setDiameter (int diameter) {
    	this.diameter = diameter;
    }
    
    /**
     * @return The diameter of the circle.
     */
    public int getDiameter() {
    	return this.diameter;
    }

    /**
     * @return The width of the circle
     */
 	public int getWidth() {
		return this.diameter;
	}

 	/**
 	 * @return The height of the circle
 	 */
 	public int getHeight() {
		return this.diameter;
	}
    
    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillOval( x, y, diameter, diameter );
    	}else {
    		g.strokeOval( x, y, diameter, diameter );
	    }
    }

	/*
	 * make the shape grow to double its size and shrink back down to its original.
	 * */
    public void pulsing(){
		/*Begin pulsing if pulsing attribute is true.*/
    	if(isPulsing){
			/*begin contraction if the size of the shape begins to exceed the max*/
    		if(this.diameter + getPulseRate()>this.max){
    			setPulseRate(-1);
    			this.diameter = this.max;
				/*begin enlargement of the shape if it drops lower than defined minimum.*/
			}else if (this.diameter + getPulseRate()<this.min){
				setPulseRate(1);
				this.diameter = this.min;
			}
    		this.diameter += getPulseRate();
		}
	}
}
