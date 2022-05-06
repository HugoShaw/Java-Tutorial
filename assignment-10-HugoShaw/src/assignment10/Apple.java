package assignment10;

import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 * @author Hugo Xue
 *
 */
public class Apple {
	// initialize Apple's position
	private double x;
	private double y;
	private double radius = 0.03;
	
	/**
	 * constructor
	 * @param x apple x position
	 * @param y apple y position
	 */
	public Apple(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * get x position
	 * @return position x
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * get y position
	 * @return position y
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * get apple radius
	 * @return apple's radius
	 * 
	 */
	public double getRadius(){
		return this.radius;
	}
	
	/**
	 * depreciated
	 */
	public void newState() {
		this.x = Math.random();
		this.y = Math.random();
	}
	
	/**
	 * draw apple
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.ORANGE);
		StdDraw.filledCircle(getX(), getY(), getRadius());
	}

}
