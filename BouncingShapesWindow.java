
	



import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Dr D. Archambault, Modified  for JAVAFX by Dr J. L. Jones
 *
 */

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

 */
public class BouncingShapesWindow {
	
	private static final int ANIMATION_DELAY = 10;
	private static final String FRAME_TITLE = "Shape Booooiiinggg Frame";
	
	private GraphicsContext gc;
	private Queue<ClosedShape> shapesToAdd;
	private ArrayList<ClosedShape> activeShapes;
	private int currentTime = 0;
	private boolean flag=true;
	
	private String filename;
	
	
	public BouncingShapesWindow(GraphicsContext gc,String filename) {
		this.gc=gc;
		
		activeShapes=new ArrayList<ClosedShape>();
		this.initShapes(filename);
		this.insertShapes ();
		drawClosedShapes();
		actionPerformed();
	}
	
	private void drawClosedShapes () {
		for (ClosedShape s : activeShapes)
		{
			s.draw(gc);
		}
	}
	
	private void initShapes (String filename) {
		shapesToAdd = ReadShapeFile.readDataFile(filename);
	}
	
	private void insertShapes() {
		//no more shapes to add, we are done
		if (shapesToAdd.isEmpty ()) {
			return;
		}
		
		//add shapes if needed
		ClosedShape current = shapesToAdd.peek ();
		while (!shapesToAdd.isEmpty () && (current.getInsertionTime() <= currentTime*ANIMATION_DELAY)) {
			activeShapes.add(current);
			shapesToAdd.dequeue();
			if (!shapesToAdd.isEmpty ()) {
				current = shapesToAdd.peek();
			}
		}
	}
	
	public void actionPerformed()
	{
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5),ae -> onTime()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}
	
	private void onTime() {
		currentTime++;
		double h =gc.getCanvas().getHeight();
		double w = gc.getCanvas().getWidth();
		gc.clearRect(0, 0, w, h);
		moveShapes();
		insertShapes ();
		drawClosedShapes();
	}
	
	public void moveShapes()
	{
		double  dimsY = gc.getCanvas().getHeight() ;
		double  dimsX = gc.getCanvas().getWidth() ;
		for (ClosedShape s : activeShapes)
		{
			s.move();
			s.pulsing();
			// Move us back in and bounce if we went outside the drawing area.
			if (s.outOfBoundsX(dimsX))
			{
				s.putInBoundsX(dimsX);
				s.bounceX();
			}
			
			if (s.outOfBoundsY(dimsY))
			{
				s.putInBoundsY(dimsY);
				s.bounceY();
			}
			
		}
	}
	 
}

