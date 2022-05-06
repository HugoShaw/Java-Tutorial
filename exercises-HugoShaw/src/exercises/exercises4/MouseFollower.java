package exercises.exercises4;

import edu.princeton.cs.introcs.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		
		StdDraw.enableDoubleBuffering();
		while (true) {
			StdDraw.clear();
			//
			// Render one frame of your animation below here
			//

			
			//  
			// End of your frame
			//
			// Stdraw.show() achieves double buffering and
			//   the pause(10) avoids the tight spinning loop
			StdDraw.show();
			StdDraw.pause(10);
		}

	}

}
