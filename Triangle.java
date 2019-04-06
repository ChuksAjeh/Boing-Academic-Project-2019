import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.Graphics;


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
 * <p>Creation of a triangle class to be displayed on screen.</p>
 */
/**
 *
 * Triangle is an triangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * triangle's bounding rectangle
 */
public class Triangle extends ClosedShape{
    private int width;
    private int height;
    private int minW, minH, maxW, maxH;

    /**
     * Creates a triangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the triangle (in pixels).
     * @param height The height of the triangle  (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the triangle  is filled with colour, false if opaque.
     * @param isPulsing true if the triangle  is resizing false if not.
     */
    public Triangle(int x, int y,int vx, int vy, boolean isFilled,int width,int height ,Color colour,int insertionTime,boolean isPulsing) {
        super(insertionTime, x, y, vx, vy, colour, isFilled,isPulsing);
        this.width = width;
        this.height= height;
        this.maxH = height*2;
        this.minH = height/2;
        this.maxW = width*2;
        this.minW = width/2;
    }

    /**
     * Method to convert a triangle to a string.
     */
    public String toString () {
        String result = "This is a Triangle\n";
        result += super.toString ();
        result += "width of triangle is "+this.width + " length of triangle is " + this.width + "\n";
        return result;
    }

    /**
     * @return The width of the triangle
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return The height of the triangle
     */
    public int getHeight() {
        return this.height;
    }


    /**
     * Draw the triangle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g){
         g.setFill(colour);
         g.setStroke(colour);
        double[] xPoints ={(x+this.getWidth()/2),x + this.getWidth(),x};
        double[] yPoints ={y,y+this.getHeight(),y+ this.getHeight()};
         if(isFilled){
             g.fillPolygon(xPoints,yPoints,3);
         }else{
             g.strokePolygon(xPoints,yPoints,3);
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
                this.width = this.minW;
                setPulseRate(1);

            }
            this.height += getPulseRate();
            this.width += getPulseRate();
        }
    }
}
