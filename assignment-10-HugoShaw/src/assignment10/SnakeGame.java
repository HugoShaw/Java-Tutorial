package assignment10;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 * @author Hugo Xue
 *
 */
public class SnakeGame {
	
	/**
	 * 
	 *  draw the canvas
	 * 
	 */
	public static void drawCanvas() {
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledSquare(0.5, 0.5, 0.5);
		StdDraw.pause(500);
		StdDraw.show();
	}
	
	/**
	 * 
	 *  when start, prompt some info
	 * 
	 */
	public static void drawStart() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.8, "Press Space to Start the Game !!!");
		StdDraw.show();
	}
	
	/**
	 * 
	 * when lose the game, prompt some info
	 * 
	 */
	public static void drawEnd() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.8, "Sorry You Lose!!!");
		StdDraw.show();
	}
	
	/**
	 * 
	 * @param args main function to run the game
	 * 
	 */
	public static void main(String[] args) {

		StdDraw.enableDoubleBuffering();  // Probably want to do this
		// TODO: Remember that you will need to call StdDraw.show()
		//       every time you want to show something on the screen!
		// game start
		
		double xSnake = Math.random();
		double ySnake = Math.random();
		double xApple = Math.random();
		double yApple = Math.random();
		
		Snake snk = new Snake(xSnake, ySnake, 0.01);
		Apple apl = new Apple(xApple, yApple);
		
		
		// TODO: This is an example of how you can determine if a 
		// key is currently being pressed.  Test it:
		//  1. Run it.
		//  2. Click on the StdDraw window (and/or watch the "Console" in Eclipse)
		//  3. Press/release the left arrow to see it change the background
		//  X. When you're done you can press the space bar to exit.
		// (Replace/update the code below with code for your game!)
		
		boolean done = false;
		boolean ifStart = false;
		drawStart();
		while(!done) {
			if (ifStart) {
				
				// check the snake if died or not
				if (snk.isDied()) {
					done = true;	
				}
				
				// snake will move around without any control
				if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
					System.out.println("Left arrow pressed");
					String keyDirection = "left";	
					// snake will receive its direction order 
					snk.receiveNewDirection(keyDirection);
					// update the snake direction and position
					snk.updateDirection();
					snk.updatePosition();
				} else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
					System.out.println("Right arrow pressed");
					String keyDirection = "right";
					// snake will receive its direction order 
					snk.receiveNewDirection(keyDirection);
					// update the snake direction and position
					snk.updateDirection();
					snk.updatePosition();
				} else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
					System.out.println("Up arrow pressed");
					String keyDirection = "up";	
					snk.receiveNewDirection(keyDirection);
					// update the snake direction and position
					snk.updateDirection();
					snk.updatePosition();
				} else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
					System.out.println("Down arrow pressed");
					String keyDirection = "down";
					snk.receiveNewDirection(keyDirection);
					// update the snake direction and position
					snk.updateDirection();
					snk.updatePosition();
					
				}

				// update the snake direction and position
				snk.updateDirection();
				snk.updatePosition();
				
				
				// check the snake died or not 
				if (snk.isDied()) {
					done = true;
				}
				
				// check the snake eat the apple or not
				if (snk.isAppleTouched(apl)) {
					// generate a new body
					Body lastElem = snk.getLastBody();
					String lastElemDirection = lastElem.getDirection();
					double lastElemX = lastElem.getX();
					double lastElemY = lastElem.getY();
					double lastElemR = lastElem.getRadius();
					
					if (lastElemDirection.equals("left")) {
						Body elem = new Body(lastElemX+2*lastElemR, lastElemY,
								lastElemR, lastElemDirection);
						snk.eatApple(elem);
					} else if (lastElemDirection.equals("right")) {
						Body elem = new Body(lastElemX-2*lastElemR, lastElemY,
								lastElemR, lastElemDirection);
						snk.eatApple(elem);
					} else if (lastElemDirection.equals("up")) {
						Body elem = new Body(lastElemX, lastElemY-2*lastElemR,
								lastElemR, lastElemDirection);
						snk.eatApple(elem);
					} else if (lastElemDirection.equals("down")) {
						Body elem = new Body(lastElemX, lastElemY+2*lastElemR,
								lastElemR, lastElemDirection);
						snk.eatApple(elem);
					} 
					
//					snk.updateDirectionTimes();
					
					// apple will disappear and generate a new one
					double newX = Math.random();
					double newY = Math.random();
					apl = new Apple(newX, newY);
				}
				
				// canvas 
				drawCanvas();
				// snake
				snk.draw();
				// apple
				apl.draw();
				
				StdDraw.show();

			}
			
			// Press space to start the game
			if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				ifStart = true;
			}
		}
		drawEnd();
	}
}
