package assignment5;

import java.awt.Color;
import java.util.Objects;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;
import zombies.ZombieSimulationFiles;

/**
 * A Zombie Simulator!
 */
public class ZombieSimulator {
	public static final int X = 0;
	public static final int Y = 1;
	private static final String ZOMBIE_TOKEN_VALUE = "Zombie";

	private static final Color ZOMBIE_COLOR = new Color(146, 0, 0);
	private static final Color NONZOMBIE_COLOR = new Color(0, 0, 0);
	private static final Color TEXT_COLOR = new Color(73, 0, 146);
	public static final double ENTITY_RADIUS = 0.008;

	public static final double RANDOM_DELTA_HALF_RANGE = 0.006;

	

	/**
	 * Read entities from a file.
	 */
	public static void readEntities(ArgsProcessor ap, boolean[] areZombies, double[][] positions) {

		// TODO: Implement this function 
		// (you can probably adjust code from Assignment 4)
		// read the array length 
		int N = areZombies.length;
		
		// read "Zombies" or "Nonzombie" into the array
		for (int i = 0; i<N; ++i) {
			String ifZombie = ap.nextString();
			double x = ap.nextDouble();
			double y = ap.nextDouble();
			
			// if it is Zombie, then true. if true, store true in array
			if (ifZombie.equals("Zombie")) {
				areZombies[i] = true;
			}
			// if it is Nonzombie, then true, if ture, store false in array
			if (ifZombie.equals("Nonzombie")) {
				areZombies[i] = false;
			}
			
			// store the position x and y
			positions[i][X] = x;
			positions[i][Y] = y;
			}
	}

	/**
	 * Draw all the entities. Zombies are drawn as ZOMBIE_COLOR filled circles of
	 * radius ENTITY_RADIUS and non-zombies with filled NONZOMBIE_COLOR filled
	 * circles of radius ENTITY_RADIUS). Further, add feedback for nonzombie count
	 * (when ready to do so), and any additional desired drawing features.
	 * 
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 */
	public static void drawEntities(boolean[] areZombies, double[][] positions) {
		// DONE: Clear the frame
		StdDraw.clear();

		// TODO: Write the loop that displays all the entities 
		// (you can probably adjust code from Assignment 4)
		int N = areZombies.length;
		int cntNonz = 0;
		
		for (int i = 0; i<N; ++i) {
			
			double xCoordinate = positions[i][X];
			double yCoordinate = positions[i][Y];
			
			// if true: Zombie, filled ZOMBIE_COLOR circle with a radius of ENTITY_RADIUS;
			if (areZombies[i]) {
				StdDraw.setPenColor(ZOMBIE_COLOR);
				StdDraw.filledCircle(xCoordinate, yCoordinate, ENTITY_RADIUS);
			// if false: Nonzombie, filled NONZOMBIE_COLOR circle with a radius of ENTITY_RADIUS;
			}else {
				cntNonz = cntNonz+1;
				StdDraw.setPenColor(NONZOMBIE_COLOR);
				StdDraw.filledCircle(xCoordinate, yCoordinate, ENTITY_RADIUS);
			}
		}
		
		// ratio of nonzombies to total entities
		String ratio = "";
		ratio = ratio+cntNonz;
		ratio = ratio+" / ";
		ratio = ratio+N;
		
		StdDraw.setPenColor(Color.MAGENTA);
		StdDraw.text(0.1, 0.95, ratio);
		
		// DONE: Show everything that was drawn (show the updated frame). This should be
		// the only "show()" command!
		StdDraw.show();
	}

	/**
	 * Check if the entity at the given index is touching a zombie. (HINT: You know
	 * the location of the center of each entity and that they all have a radius of
	 * ENTITY_RADIUS. If the circles representing two entities overlap they are
	 * considered to be touching. Consider using the distance formula.)
	 *
	 * @param index      the index of the entity to check
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 * @return true if the entity at index is touching a zombie, false otherwise
	 */
	public static boolean touchingZombie(int index, boolean[] areZombies, double[][] positions) {
		// TODO: Complete this method
		int N = areZombies.length;
		double xCoordinate = positions[index][X];
		double yCoordinate = positions[index][Y];
		
		boolean ifTouch = false;
		
		for (int i=0; i<N; ++i) {
//			the entity should not be itself
			if (i!=index) {
				double xEntity = positions[i][X];
				double yEntity = positions[i][Y];
				
//			calculate the distance between the entity at index and zombies				
				double distance = Math.sqrt(Math.pow(xEntity - xCoordinate, 2) + Math.pow(yCoordinate - yEntity, 2));

//			the distance is close and the entity is a zombie
				if (distance <= (2 * ENTITY_RADIUS) && areZombies[i]) {
					ifTouch = true;
				}
			}
		}
		
		return ifTouch; // FIXME: Replace this so it returns the value of interest
	}

	/**
	 * Update the areZombies states and positions of all entities (assume Brownian
	 * motion).
	 *
	 * The rules for an update are:
	 * 
	 * Each entity should move by a random value between -RANDOM_DELTA_HALF_RANGE 
	 * and +RANDOM_DELTA_HALF_RANGE in both the x and the y coordinates.
	 * 
	 * Entities should not be able to leave the screen. x and y coordinates should
	 * be kept between [0-1.0]
	 *
	 * If a non-zombie is touching a zombie it should change to a zombie. (HINT: you
	 * need to check all entities. On each one that is NOT a zombie, you can re-use
	 * code you've already written to see if it's "touching" a Zombie and, if so,
	 * change it to a zombie.)
	 *
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 */
	public static void updateEntities(boolean[] areZombies, double[][] positions) {
		// TODO: Complete this method: It should update the positions of items in the
		// entities array
		int N = areZombies.length;
		
//		update entities' positions
		for (int i=0; i<N; ++i) {
			double moveX = Math.random()*2*RANDOM_DELTA_HALF_RANGE-RANDOM_DELTA_HALF_RANGE;
			double moveY = Math.random()*2*RANDOM_DELTA_HALF_RANGE-RANDOM_DELTA_HALF_RANGE;
			
			double xCoordinate = positions[i][X];
			double yCoordinate = positions[i][Y];
			
//			not leave the screen
			if (xCoordinate + moveX < 0) {
				positions[i][X] = 0;
			}
			else if (xCoordinate + moveX > 1.0) {
				positions[i][X] = 1.0;
			}
			else {
				positions[i][X] = positions[i][X] + moveX;
			}
			
			if (yCoordinate + moveY < 0) {
				positions[i][Y] = 0;
			}
			else if (yCoordinate + moveY > 1.0) {
				positions[i][Y] = 1.0;
			}
			else {
				positions[i][Y] = positions[i][Y] + moveY;
			}
		}
		
//		touch zombie will be come a zombie
		for (int i=0; i<N; ++i) {
//			the nonzombie will be a zombie
			if (!areZombies[i]) {
				boolean ifTouchZombie = touchingZombie(i, areZombies, positions);
				if (ifTouchZombie) {
					areZombies[i] = true;
				}
			}
		}
		
	}

	
	/**
	 * 
	 * Return the number of nonzombies remaining
	 * 
	 * @param areZombies: the zombie state of each entity
	 * @return the count number of nonzombies in the areZombies array
	 */
	public static int nonzombieCount(boolean[] areZombies) {
		int N = areZombies.length;
		int cntNonzombie = 0;
		
		for (int i = 0; i<N; ++i) {			
			// if not zombies
			if (!areZombies[i]) {
				cntNonzombie = cntNonzombie + 1;
			}
		}
		return cntNonzombie;
	}

	/**
	 * Run the zombie simulation.
	 */
	private static void runSimulation(ArgsProcessor ap) {
		StdDraw.enableDoubleBuffering(); // reduce unpleasant drawing artifacts, speed things up

		// TODO: Uncomment and fix the code below.
		 int N = ap.nextInt();
		 boolean[] areZombies = new boolean[N];
		 double[][] positions = new double[N][2];
		 readEntities(ap, areZombies, positions);
		 drawEntities(areZombies, positions);
		
		StdDraw.pause(500);

		// TODO: Write the loop that will run the simulation.
		// Continue if nonzombies remain
		// Update zombie state and positions
		// Redraw
		
		// count the remaining nonzombies
		int nonzombiesCnt = nonzombieCount(areZombies);
//		continue to run until all nonzombies become a zombie
		while (nonzombiesCnt > 0) {
//			update entities' position and status
			updateEntities(areZombies, positions);
//			draw again
			drawEntities(areZombies, positions);
//			count remaining nonzombies again
			nonzombiesCnt = nonzombieCount(areZombies);
		}
	}

	public static void main(String[] args) {
		ArgsProcessor ap = ZombieSimulationFiles.createArgsProcessorFromFile(args);
		runSimulation(ap);
	}

}
