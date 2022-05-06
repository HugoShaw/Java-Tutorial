package assignment8.tests;

import java.util.List;

import assignment8.Entity;
import assignment8.ZombieSimulator;
import support.cse131.ArgsProcessor;
import zombies.ZombieSimulationFiles;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ZombieTestUtils {
	public static ZombieSimulator readZombieSimulator(String filename) {
		ArgsProcessor ap = ZombieSimulationFiles.createArgsProcessorFromFile(new String[] { filename });
		ZombieSimulator zombieSimulator = new ZombieSimulator();
		zombieSimulator.readEntities(ap);
		return zombieSimulator;
	}

	public static List<Entity> readEntities(String filename) {
		return readZombieSimulator(filename).getEntities();
	}
}
