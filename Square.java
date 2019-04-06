import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;


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
 * <p>Creation of a square class to display a square instance on screen.</p>
 */
/**
 *
 * Square is an Square shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * Square's bounding rectangle
 */

public class Square extends ClosedShape {
    private int side;
    private int min, max;

    /**
     * Creates an oval.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the oval (in pixels).
     * @param height The height of the oval (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the oval is filled with colour, false if opaque.
     * @param isPulsing true if the oval is resizing false if not.
     */
    public Square (int x, int y, int vx, int vy,boolean isFilled, int side, Color colour, int insertionTime,boolean isPulsing) {
        super (insertionTime, x, y, vx, vy, colour, isFilled,isPulsing);
        this.side = side;
        this.max = side*2;
        this.min = side/2;

    }

    /**
     * Method to convert a Square  to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its height and width are " + this.side + "\n";
        return result;
    }

    /**
     * @param Resets the side .
     */
    public void setSide  (int side) {
        this.side = side;
    }

    /**
     * @return The length of the side of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * @return The width of the square
     */
    public int getWidth() {
        return side;
    }

    /**
     * @return The height of the square
     */
    public int getHeight() {
        return side;
    }


    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect(x,y,side,side);
        }else {
            g.strokeRect( x, y, side, side);
        }
    }

    /*
     * make the shape grow to double its size and shrink back down to its original.
     * */
    public void pulsing(){
        /*Begin pulsing if pulsing attribute is true.*/
        if(isPulsing){
            /*begin contraction if the size of the shape begins to exceed the max*/
            if(this.side + getPulseRate()>this.max){
                setPulseRate(-1);
                this.side = this.max;
                /*begin enlargement of the shape if it drops lower than defined minimum.*/
            }else if (this.side + getPulseRate()<this.min){
                setPulseRate(1);
                this.side = this.min;
            }
            this.side += getPulseRate();
        }
    }
}
