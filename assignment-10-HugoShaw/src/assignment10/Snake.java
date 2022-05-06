package assignment10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 * @author Hugo Xue
 *
 */
public class Snake {
	// initialize the snake's head position
	private double x;
	private double y;
	private double radius = 0.01;
	private double movingAmount = 0.02;
	private boolean died = false;
	// indicate head direction
	private String direction = "left";
	private LinkedList<Body> body;
	
	// put all keyboard direction into directions
	private LinkedList<String> directions = new LinkedList<String>();
	private LinkedList<Integer> directionTimes = new LinkedList<Integer>();
	private LinkedList<Integer> curPoint = new LinkedList<Integer>();
	
	/**
	 * 
	 * @param x snake head position x
	 * @param y snake head position y
	 * @param radius snake head radius
	 * 
	 */
	public Snake(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.body = new LinkedList<Body>();
		
		// snake have not ate a apple, assume there is the snake head position
		// first snake body is the snake head
		Body elem = new Body(x, y, radius, this.direction);
		this.body.add(elem);
	}
	
	/**
	 * 
	 * @return snake head position x
	 * 
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @return snake head position y
	 * 
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * 
	 * @return snake head radius
	 * 
	 */
	public double getRadius(){
		return this.radius;
	}
	
	/**
	 * 
	 * @return snake current direction 
	 * 
	 */
	public String getDirection() {
		return this.direction;
	}
	
	/**
	 * 
	 * @return snake last body element 
	 * 
	 */
	public Body getLastBody(){
		return body.getLast();
	}
	
	/**
	 * 
	 * @return is the snake dead or not ?
	 * 
	 */
	public boolean isDied() {
		isTouchedWall();
		isTouchedSelf();
		return died;
	}
	
	/** 
	 * 
	 * draw the snake 
	 * 
	 */
	public void draw() {
		if (!died) {
			StdDraw.setPenColor(StdDraw.RED);
			for (Body elem: body) {
				StdDraw.filledCircle(elem.getX(), elem.getY(), elem.getRadius());
			}
		} else {
			StdDraw.setPenColor(StdDraw.GRAY);
			for (Body elem: body) {
				StdDraw.filledCircle(elem.getX(), elem.getY(), elem.getRadius());
			}
		}

	}
	
	/**
	 * 
	 * @param xApple apple's position x
	 * @param yApple apple's position y
	 * @param radiusApple apple's radius
	 * 
	 * @return distance between apple and snake
	 * 
	 */
	public double distanceEdgeToEdge(double xApple, double yApple, double radiusApple) {
		return Math.sqrt(Math.pow(this.x - xApple, 2) + Math.pow(this.y - yApple, 2)) - this.radius - radiusApple;
	}
	
	/**
	 * 
	 * @param apple apple class
	 * @return distance between apple and snake
	 * 
	 */
	public double distanceEdgeToEdge(Apple apple) {
		return distanceEdgeToEdge(apple.getX(), apple.getY(), apple.getRadius());
	}
	
	/**
	 * 
	 * @param xApple apple's position x
	 * @param yApple apple's position y
	 * @param radiusApple apple's radius
	 * 
	 * @return did the snake touch the apple or not
	 * 
	 */
	public boolean isAppleTouched(double xApple, double yApple, double radiusApple) {
		return distanceEdgeToEdge(xApple, yApple, radiusApple) <= 0;
	}
	
	/**
	 * 
	 * @param apple apple class
	 * @return did the snake touch the apple or not
	 * 
	 */
	public boolean isAppleTouched(Apple apple) {
		return isAppleTouched(apple.getX(), apple.getY(), apple.getRadius());
	}
	
	/**
	 * 
	 * when the snake touched the apple, eat the apple
	 * @param elem get a new body element
	 * 
	 */
	public void eatApple(Body elem) {
		// snake eat an apple will generate a new body
		this.body.add(elem);
	}
	
	/**
	 * 
	 * snake touched the wall and died
	 * 
	 */
	public void isTouchedWall() {
		// check the head of a snake touched wall or not
		if (getX()-getRadius() <= 0 || getX()+getRadius() >= 1) {
			this.died = true;
		}
		
		if (getY()-getRadius() <= 0 || getY()+getRadius() >= 1) {
			this.died = true;
		}
	}
	
	/**
	 * 
	 * @param xBody snake's body position x
	 * @param yBody snake's body position y
	 * @param radiusBody snakes' body radius
	 * 
	 * @return distance between head to body
	 * 
	 */
	public double distanceHeadToBody(double xBody, double yBody, double radiusBody) {		
		return Math.sqrt(Math.pow(this.x - xBody, 2) + Math.pow(this.y - yBody, 2)) - this.radius - radiusBody;
	}
	
	/**
	 * 
	 * @param elem body element 
	 * @return distance between head to body
	 * 
	 */
	public double distanceHeadToBody(Body elem) {
		return distanceHeadToBody(elem.getX(), elem.getY(), elem.getRadius());
	}
	
	/**
	 * 
	 * snake will touch itself and dead
	 * 
	 */
	public void isTouchedSelf() {
		// check the head of a snake touched body or not 
		
		// start from the 3rd body
		if (body.size() >= 3) {
			for (int i=2; i<body.size(); i++) {
				if (distanceHeadToBody(body.get(i)) <= 0) {
					this.died=true;
				}
			}
		}
	}	
	
	/**
	 * snake can receive a new direction console
	 * @param direction left right up and down
	 * 
	 */
	public void receiveNewDirection(String direction) {
		// direction store into the list 
		directions.add(direction);  // "left"
		directionTimes.add(body.size()); // 1 bodies
		curPoint.add(0); // point to head (0) first
		// update head direction
		this.direction = direction;
//		System.out.println(this.direction);
	}
	
	/**
	 * when eating an apple, the length of body will increase and add direction time one more
	 */
//	public void updateDirectionTimes() {
//		for (int i=0; i<directionTimes.size(); i++) {
//			int dirTimes = directionTimes.get(i);
//			directionTimes.set(i, dirTimes+1);
//		}
//	}
	
	/**
	 * update the direction for all bodies
	 */
	public void updateDirection() {
		// update snake body direction 
		for (int i=0; i<directions.size(); i++) {
			int dirTimes = directionTimes.get(i);
			if (dirTimes <= 0) {
				// remove the directions
				directions.removeFirst();
				directionTimes.removeFirst();
				curPoint.removeFirst();
				continue;
			} 
			// update which body
			int pt = curPoint.get(i);
			// find the body
			Body elem = body.get(pt);
			// find the direction
			String dir = directions.get(i);

			elem.updateDirection(dir);
			body.set(pt, elem);
			
			// pointer + 1
			curPoint.set(i, pt+1);
			// direction times - 1
			directionTimes.set(i, dirTimes-1);
			
		}
		
	}
	
	/**
	 * update all body positions
	 * 
	 */
	public void updatePosition() {
		// update head position
		if (this.direction.equals("left")) {
			this.x = this.x - this.movingAmount;
		} else if (this.direction.equals("right")) {
			this.x = this.x + this.movingAmount;
		} else if (this.direction.equals("up")) {
			this.y = this.y + this.movingAmount;
		} else if (this.direction.equals("down")) {
			this.y = this.y - this.movingAmount;
		}
		
		// update body position
		for (int i=0; i<body.size(); i++) {
			Body elem = body.get(i);
			String bodyDirection = elem.getDirection();
			if (bodyDirection.equals("left")) {
				elem.updateX(-movingAmount);
			} else if (bodyDirection.equals("right")) {
				elem.updateX(movingAmount);
			} else if (bodyDirection.equals("up")) {
				elem.updateY(movingAmount);
			} else if (bodyDirection.equals("down")) {
				elem.updateY(-movingAmount);
			}
			body.set(i, elem);
		}
	}
	
}
