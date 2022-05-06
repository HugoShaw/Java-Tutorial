package studio4;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.*;

public class Flag {
	public static void main(String[] args) {
		double[] xs = {0.3,0.5,0.7,0.5};
		double[] ys = {0.5,0.2,0.5,0.8};
		StdDraw.filledPolygon(xs, ys);
		StdDraw.show();
		
	}
}