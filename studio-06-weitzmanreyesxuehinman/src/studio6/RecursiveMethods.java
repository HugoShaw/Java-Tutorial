package studio6;

import java.util.Arrays;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
		if (n==0) {
			return 0;
		}
		else {
			double sum = Math.pow(0.5, n) + geometricSum(n-1);
			return sum;
		}
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (p%q == 0) {
			return 0;
		}
		else {
			return gcd(q,p%q);
		}
		
	}
	public static void main(String[] args) {
		System.out.println(gcd(48,14));
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] cp = Arrays.copyOf(array, array.length);
		int index = 0;
		return helper(cp, index);
		
	}
	
	public static int[] helper(int[] array, int index) {
		if (index >= array.length/2) {
			return array;
		}
		else {
			int tmp = array[index];
			array[index] = array[array.length-1-index];
			array[array.length-1-index] = tmp;
			index = index+1;
			return helper(array, index);
		}
	}
	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		
		if (radius <= radiusMinimumDrawingThreshold) {
			return;
		}
		else {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.circle(xCenter, yCenter, radius);
			circlesUponCircles(xCenter+radius,yCenter,radius/3.0,radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter-radius,yCenter,radius/3.0,radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter,yCenter+radius,radius/3.0,radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter,yCenter-radius,radius/3.0,radiusMinimumDrawingThreshold);
		}
		StdDraw.show();
	}

}
