package studio4;
import support.cse131.*;
import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class individualFlags {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String color = ap.nextString("What's your favor color?");
		String shape = ap.nextString("What's you country shape?");
		boolean isStar = ap.nextBoolean("Does ur country like star?");
		
		if (color.equals("red")) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		else if (color.equals("blue")) {
			StdDraw.setPenColor(StdDraw.BLUE);
		}
		else if (color.equals("green")) {
			StdDraw.setPenColor(StdDraw.GREEN);
		}
		
		if (shape.equals("rectangle")) {
			StdDraw.filledRectangle(0.5, 0.5, 0.2, 0.1);
		}
		else if (shape.equals("ellipse")) {
			StdDraw.filledEllipse(0.5, 0.5, 0.2, 0.2);
		}
		
		if (isStar) {
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledSquare(.5, 0.5, 0.01);
			StdDraw.filledSquare(.4, 0.4, 0.01);
			StdDraw.filledSquare(.3, 0.3, 0.01);
		}
		StdDraw.show();
	}

}
