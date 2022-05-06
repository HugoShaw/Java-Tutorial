package studio3;

import support.cse131.ArgsProcessor;

public class Sieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int n = ap.nextInt("Your max number:");
		
		boolean[] A = new boolean[n+1];
		
		for (int i=2; i<=n; ++i) {
			A[i] = true;
		}
				
		for (int i=2; i<=Math.sqrt(n); ++i) {
			if (A[i]) {
				for (int c=0; c<=n; ++c) {
					int j = i^2+c*i;
					if (j<=n) {
						A[j]=false;
					}
				}
			}
		}
		
		for (int i=1; i<=n; ++i) {
			if (A[i]) {
				System.out.println(i);
			}
		}
	}

}
