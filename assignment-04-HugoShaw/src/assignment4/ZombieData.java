package assignment4;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;
import zombies.ZombieSimulationFiles;

public class ZombieData {

	public static void main(String[] args) throws Exception {
		// NOTE: The line below will prompt the user with a file open dialog box.
		//       The contents of the selected file will be made available via the ArgsProcessor ap.
		ArgsProcessor ap = ZombieSimulationFiles.createArgsProcessorFromFile(args);

		// TODO: 1. Read in the number of entities from the ArgsProcessor
		int N = ap.nextInt();
//		String x = ap.nextString();
//		double y = ap.nextDouble();
//		double z = ap.nextDouble();
//		
//		boolean zom = x.equals("Zombie");
//		boolean notZom = x.equals("Nonzombie");
//				
//		System.out.println(N+x+y+z+zom+notZom);
		// TODO: 2. Create the arrays that will hold entity data
		// [ [], [], [] ]
		boolean[] areZombies = new boolean[N];
		double[] xs = new double[N];
		double[] ys = new double[N];
		
		// TODO: 3. Read in all the Entity data
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
			
			xs[i] = x;
			ys[i] = y;
		}
		
		// print 
//		for (int i = 0; i<N; ++i) {
//			System.out.println(areZombies[i]);
//			System.out.println(xs[i]);
//			System.out.println(ys[i]);
//		}
//		
		// TODO: 4. Iterate through all the data and display it using StdDraw
		int cntNonz = 0;
		
		for (int i = 0; i<N; ++i) {
			// if true: Zombie, filled red circle with a radius of 0.008;
			if (areZombies[i]) {
				StdDraw.setPenColor(Color.RED);
				StdDraw.filledCircle(xs[i], ys[i], 0.008);
			// if false: Nonzombie, filled black circle with a radius of 0.008
			// if zombie, count zombie +=1
			}else {
				cntNonz = cntNonz+1;
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledCircle(xs[i], ys[i], 0.008);
			}
		}
		
		// ratio of non-zombies to total entities
		String ratio = "";
		ratio = ratio+cntNonz;
		ratio = ratio+" / ";
		ratio = ratio+N;
		
		StdDraw.setPenColor(Color.MAGENTA);
		StdDraw.text(0.1, 0.95, ratio);
		
		StdDraw.show();
	}
}
