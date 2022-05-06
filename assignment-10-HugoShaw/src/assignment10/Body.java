package assignment10;

/**
 * 
 * @author Hugo Xue
 *
 */
public class Body {
	private double x;
	private double y;
	private double radius = 0.01;
	// right, left, up, and down
	private String direction;
	
	/**
	 * constructor
	 * @param x body position x 
	 * @param y body position y
	 * @param radius body radius
	 * @param direction body direction
	 */
	public Body(double x, double y, double radius, String direction) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.direction = direction;
	}
	
	/**
	 * getter
	 * @return x position
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * getter
	 * @return y position
	 * 
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * getter 
	 * @return radius
	 */
	public double getRadius(){
		return this.radius;
	}
	
	/**
	 * getter
	 * @return body direction
	 */
	public String getDirection() {
		return this.direction;
	}
	
	/**
	 * updated position x
	 * @param amount moving amount
	 */
	public void updateX(double amount) {
		this.x = this.x + amount;
	}
	
	/**
	 * updated position y
	 * @param amount moving amount
	 * 
	 */
	public void updateY(double amount) {
		this.y = this.y + amount;
	}
	
	/**
	 * updated direction
	 * @param direction moving direction
	 */
	public void updateDirection(String direction) {
		this.direction = direction;
	}
	
}
