package assignment9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import assignment9.scenes.Bubbles;
import assignment9.scenes.Circle;
import assignment9.scenes.Clear;
import assignment9.scenes.Empty;
import assignment9.scenes.Forest;
import assignment9.scenes.Leaves;
import assignment9.scenes.Line;
import assignment9.scenes.Poly;
import assignment9.scenes.Sequence;
import assignment9.scenes.Square;
import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;

public class SceneComposer {
	
//	Use a List<Drawable> as needed to store a list of Drawables.
	private static Sequence hist;	
	
	public static Sequence init() {
		List<Drawable> init = new LinkedList<Drawable>();
		init.add(generateForest());
		init.add(generateLeaves());
		init.add(generatePoly());
		return new Sequence(init);
	}
	
	public static Circle generateCicle() {
		double cX = Math.random();
		double cY = Math.random();
		double cR = Math.random()*0.5;
		Circle c = new Circle(cX, cY, cR);
		return c;
	}
	
	public static Square generateSquare() {
		double sX = Math.random();
		double sY = Math.random();
		double sR = Math.random()*0.5;
		Square s = new Square(sX, sY, sR);
		return s;
	}
	
	public static Forest generateForest() {
		int numOfForest = (int) (50 * Math.random());
		return new Forest(numOfForest);
	}
	
	public static Leaves generateLeaves() {
		int numTrees = (int) (100 * Math.random());
		return new Leaves(numTrees);
	}
	
	public static Poly generatePoly() {
		int numSides = (int) (5 * Math.random());
		return new Poly(numSides);
	}


	public static void main(String[] args) {
//		Use a Map<String,Drawable> to allow users to recall existing scenes and create new ones.
		Map<String, Drawable> sceneExisting = new HashMap<String, Drawable>(); 
		// store basic scenes in map
		// b0: 3 bubbles
		sceneExisting.put("b0", new Bubbles(3));
		// b0: 6 bubbles
		sceneExisting.put("b1", new Bubbles(6));
		// b0: 3 bubbles
		sceneExisting.put("b2", new Bubbles(9));
		// c0: 1 circle
		sceneExisting.put("c0", generateCicle());
		// c1: 1 circle
		sceneExisting.put("c1", generateCicle());
		// c2: 1 circle
		sceneExisting.put("c2", generateCicle());
		// e0: Empty
		sceneExisting.put("e0", new Empty());
		// f0: Forest
		sceneExisting.put("f0", generateForest());
		// f1: Forest
		sceneExisting.put("f1", generateForest());
		// f2: Forest
		sceneExisting.put("f2", generateForest());
		// l0: Leaves
		sceneExisting.put("l0", generateLeaves());
		// l1: Leaves
		sceneExisting.put("l1", generateLeaves());
		// l2: Leaves
		sceneExisting.put("l2", generateLeaves());
		// L0: Line
		sceneExisting.put("L0", new Line());
		// L1: Line
		sceneExisting.put("L1", new Line());
		// L2: Line
		sceneExisting.put("L2", new Line());
		// p0: Poly
		sceneExisting.put("p0", generatePoly());
		// p1: Poly
		sceneExisting.put("p1", generatePoly());
		// p2: Poly
		sceneExisting.put("p2", generatePoly());
		// s0: Square
		sceneExisting.put("s0", generateSquare());
		// s1: Square
		sceneExisting.put("s1", generateSquare());
		// s2: Square
		sceneExisting.put("s2", generateSquare());
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		// Note: Double Buffering is enabled!  
		//       You'll need to call show() to update the screen.
		//       In most cases you'll want to call show() after you've drawn something
		StdDraw.enableDoubleBuffering();
		
		
		//
		// for demo only, remove this code and write your own to do what
		//   is needed for this assignment
//		while(true) {
//			StdDraw.show();
//			StdDraw.pause(10);
//			for (int i=0; i < 10; ++i) {
//				Forest f = new Forest(5);
//				f.draw(); f.draw(); f.draw(); f.draw();
//				Leaves l = new Leaves(5);
//				l.draw(); l.draw();
//			}
//			Bubbles b = new Bubbles(10);
//			b.draw();
//			StdDraw.show();
//			StdDraw.pause(10);
//			String resp = ap.nextString("Again?");
//			if (resp.equals("no")) {
//				break;
//			}
//			else {
//				new Clear().draw();
//			}
//		}
		
//		Use a Map<String,Drawable> to allow users to recall existing scenes and create new ones.
		// 1. existing scenes
		StdDraw.show();
		StdDraw.pause(10);
		// Create an initial scene with multiple objects and store it under the name "init"
		Sequence seq = init();
		seq.draw();
		while(true) {
			StdDraw.show();
			StdDraw.pause(10);
			String resp = ap.nextString("Again?");
			
			if (resp.equals("end")) {
				break;
			} else if (resp.equals("clear")) {
				// clear the canvas
				new Clear().draw();
			} else if (resp.equals("init")) {
				new Clear().draw();
				seq.draw();
			} else if (resp.equals("record start")) {
				new Clear().draw();
				List<Drawable> recordSeq = new LinkedList<Drawable>();
				while (true) {
					
					String response = ap.nextString("record next");
					// draw the specific chart 
					for (Map.Entry<String, Drawable> e: sceneExisting.entrySet()) {
						if (response.equals(e.getKey())) {
							StdDraw.show();
							StdDraw.pause(10);
							e.getValue().draw();
							// store the drawable into list
							recordSeq.add(e.getValue());
							StdDraw.show();
							StdDraw.pause(10);
						}
					}
					
					if (response.equals("record end")) {
						break;
					}
				
				}
				hist = new Sequence(recordSeq);
			} else if (resp.equals("show record")) {
				StdDraw.show();
				StdDraw.pause(10);
				new Clear().draw();
				hist.draw();
				StdDraw.show();
				StdDraw.pause(10);
			}
			else {
				// draw the specific chart 
				for (Map.Entry<String, Drawable> e: sceneExisting.entrySet()) {
					if (resp.equals(e.getKey())) {
						e.getValue().draw();
					}
				}
				StdDraw.show();
				StdDraw.pause(10);
			}

			
		}
		//
		// end of demo code
		//
	}

}
