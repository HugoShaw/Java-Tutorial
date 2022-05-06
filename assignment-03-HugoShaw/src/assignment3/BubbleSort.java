package assignment3;

import support.cse131.ArgsProcessor;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int arrayLength = ap.nextInt("How big you would like the array to be?");
		int[] array = new int[arrayLength];
		
		// enter your values for the array
		for (int i=0; i<arrayLength; ++i) {
			array[i] = ap.nextInt("enter your values for sorted");
		}
		
		// print out results
		System.out.print("Given values: ");
		for (int i=0; i<arrayLength; ++i) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		// bubble sort algorithm
		for (int i=0; i<arrayLength; ++i) {
			for (int j=1; j<arrayLength-i; ++j) {
				if (array[j-1] > array[j]) {
					// swap the j-1 into j
					int tmp = array[j-1];
					array[j-1] = array[j];
					array[j] = tmp;
				}
			}
		}
		
		// print out results
		System.out.print("Sorted values: ");
		for (int i=0; i<arrayLength; ++i) {
			System.out.print(array[i]+" ");
		}
	}

}
