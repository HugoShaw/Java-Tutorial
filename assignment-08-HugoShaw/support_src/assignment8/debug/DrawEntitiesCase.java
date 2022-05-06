package assignment8.debug;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import assignment8.Entity;
import assignment8.ZombieSimulator;
import support.cse131.ArgsProcessor;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawEntitiesCase {
	private final boolean[] areZombies;
	private final double[][] positions;
	private final String text;

	public DrawEntitiesCase(boolean[] areZombies, double[][] positions, String text) {
		this.areZombies = areZombies;
		this.positions = positions;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<>(areZombies.length);
		for (int i = 0; i < areZombies.length; ++i) {
			entities.add(new Entity(areZombies[i], positions[i][0], positions[i][1]));
		}
		return entities;
	}

	public ZombieSimulator createZombieSimulator() {
		List<String> args = new LinkedList<>();
		args.add(Integer.toString(areZombies.length));
		for (int i = 0; i < areZombies.length; ++i) {
			args.add(areZombies[i] ? "Zombie" : "Nonzombie");
			args.add(Double.toString(positions[i][0]));
			args.add(Double.toString(positions[i][1]));
		}
		ArgsProcessor ap = new ArgsProcessor(args.toArray(new String[args.size()]));
		ZombieSimulator zombieSimulator = new ZombieSimulator();
		zombieSimulator.readEntities(ap);
		return zombieSimulator;
	}
}
