
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
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



import java.util.NoSuchElementException;

public class Queue<T> {
	 private QueueElement<T> head;
	 private QueueElement<T> tail;

	//TODO:  You need some data to store the queue.  Put the attributes here.

	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		this.head = null;
		this.tail = null;

	    //TODO: Write the Queue constructor
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
	    //TODO:  Needs to return true when empty and false otherwise
		if ((this.head == null )&&(this.tail==null)){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		/*Throw exception only if the queue is empty*/
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty.");
		}else{
			return head.getElement();
		} //DELETE AND CHANGE TO SOMETHING SENSIBLE
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		/*Throw exception only if the queue is empty*/
	    if(isEmpty()){
	    	throw new NoSuchElementException("Queue is empty.");
		}else{
	    	this.head = this.head.getNext();
	    	/*if the head equals null then set the tail to null as the queue is now empty.*/
	    	if(this.head == null){
	    		this.tail = null;
			}
		}
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
		QueueElement<T> temp = new QueueElement<>(element,null);
		/*tail and head set to be the new element only if the queue is empty.*/
		if(this.tail == null){
			this.head = this.tail = temp;

		}else{
			/*Set the tail to be the new element*/
			this.tail.setNext(temp);
			this.tail = temp;

		}
	    //Enqueue code is needed here
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */

	public void print () {
	    //Code to print the code is needed here
		/*outputs message stating queue is empty only if head is null*/
		if(this.head == null){
			System.out.println("Queue is empty");
		}else{
			System.out.println("Queue is not empty");

			QueueElement<T> curItem = this.head;
			/*evaluate whether curItem is null.
			* if not loop through and output the element and get the next.
			* will terminate when curItem is equal to null.*/
			while (curItem != null){
				System.out.println(curItem.getElement());
				curItem = curItem.getNext();
			}

		}
	}
}
