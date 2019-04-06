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
 * <p>Creation of a rectangle class to be a displayed on screen.</p>
 */
/**
 *
 * Rectangle is an rectangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * rectangle.
 */
public class Rect extends ClosedShape{
    //The width and height of the rectangle (major and minor axis)
    private int width, height;
    private int minW, minH, maxW, maxH;
    /**
     * Creates an rectangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle  (in pixels).
     * @param height The height of the rectangle (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if opaque.
     * @param isPulsing true if the rectangle is resizing false if not.
     */
    public Rect (int x, int y, int vx, int vy, boolean isFilled, int width, int height, Color colour, int insertionTime, boolean isPulsing) {
        super (insertionTime, x, y, vx, vy, colour, isFilled,isPulsing);
        this.width = width;
        this.height = height;
        this.maxH = height*2;
        this.minH = height/2;
        this.maxW = width*2;
        this.minW = width/2;
    }

    /**
     * Method to convert a rectangle to a string.
     */
    public String toString () {
        String result = "This is a rectangle \n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.width = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.height = height;
    }

    /**
     * @return The width of the oval.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the oval.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Draw the rectangle.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, width, height );
        }else {
            g.strokeRect( x, y, width, height );
        }
    }


    /*
     * make the shape grow to double its size and shrink back down to its original.
     * */
    public void pulsing(){
        /*Begin pulsing if pulsing attribute is true.*/
        if(isPulsing){
            /*begin contraction if the size of the shape begins to exceed the max*/
            if(this.height + getPulseRate()>this.maxH){
                setPulseRate(-1);
                this.height = this.maxH;
                /*begin enlargement of the shape if it drops lower than defined minimum.*/
            }else if (this.height + getPulseRate()<this.minH){
                setPulseRate(1);
                this.height = this.minH;
            }
            /*begin contraction if the size of the shape begins to exceed the max*/
            if(this.width + getPulseRate()>this.maxW){
                setPulseRate(-1);
                this.width = this.maxW;
                /*begin enlargement of the shape if it drops lower than defined minimum.*/
            }else if (this.width + getPulseRate()<this.minW){
                setPulseRate(1);
                this.width = this.minW;
            }
            this.height += getPulseRate();
            this.width += getPulseRate();
        }
    }
}
