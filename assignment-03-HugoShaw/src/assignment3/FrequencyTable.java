package assignment3;

import support.cse131.ArgsProcessor;

public class FrequencyTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int x = ap.nextInt("Generate x integers?");
		int n = ap.nextInt("x should between 1 and n");
		while (n<1) {
			n = ap.nextInt("x should between 1 and n");
		}
		
		int[] array = new int[x];
		for (int i=0; i<x; ++i) {
			int number = (int) (Math.round(Math.random()*n));
			array[i] = number;
		}
		
		// view through 1 to n 
		for (int i=1; i<=n; ++i) {
			System.out.print(i+": ");
			// view through the array 0 to x-1
			int cnt = 0;
			for (int j=0; j<x; ++j) {
				if (array[j] == i) {
					cnt = cnt+1;
				}
			}
			System.out.print(cnt+"\n");
		}
		
	}

}
