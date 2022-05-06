package studio4;

import java.io.FileNotFoundException;

import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import support.cse131.ArgsProcessor;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {
	public static void readFileViaArgsProcessorAndDraw(ArgsProcessor ap) {
		// TODO: Write studio code here
		String shape = ap.nextString();
		int redComponent = ap.nextInt();
		int greenComponent = ap.nextInt();
		int blueComponent = ap.nextInt();
//		System.out.println(shape);
		boolean isFilled = ap.nextBoolean();
		
		if (shape.equals("rectangle")) {
			double x = ap.nextDouble();
			double y = ap.nextDouble();
			double halfWidth = ap.nextDouble();
			double halfHeight = ap.nextDouble();
			
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			if (isFilled) {
				StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
			}
			else {
				StdDraw.rectangle(x, y, halfWidth, halfHeight);
			}
		}
		
		if (shape.equals("ellipse")) {
			double x = ap.nextDouble();
			double y = ap.nextDouble();
			double semix = ap.nextDouble();
			double semiy = ap.nextDouble();
			
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			if (isFilled) {
				StdDraw.filledEllipse(x, y, semix, semiy);
			}
			else {
				StdDraw.ellipse(x, y, semix, semiy);
			}
		}
		
		if (shape.equals("triangle")) {
			double x1 = ap.nextDouble();
			double y1 = ap.nextDouble();
			double x2 = ap.nextDouble();
			double y2 = ap.nextDouble();
			double x3 = ap.nextDouble();
			double y3 = ap.nextDouble();

			double[] xs = {x1,x2,x3};
			double[] ys = {y1,y2,y3};
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			if (isFilled) {
				StdDraw.filledPolygon(xs, ys);
			}
			else {
				StdDraw.polygon(xs,ys);
			}
		}
		StdDraw.show();
	}

	public static void main(String[] args) throws FileNotFoundException {
		SwingUtilities.invokeLater(()->{
			ArgsProcessor ap = DrawingFiles.createArgsProcessorFromFile(args);
			while (ap != null) {
				StdDraw.clear();
				readFileViaArgsProcessorAndDraw(ap);
				ap = DrawingFiles.createArgsProcessorFromFile(new String[] {});
			}
			System.exit(0);
		});
	}
}
