package assignment3;

import support.cse131.ArgsProcessor;

public class SymmetricalImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		// create nxm array
		int n = ap.nextInt("how many rows?");
		int m = ap.nextInt("how many columns?");
		boolean[][] array = new boolean[n][m];
		
		// assign all the initial position is false
		for (int i=0; i<n; ++i) {
			for (int j=0; j<m; ++j) {
				array[i][j] = false;
			}
		}
		
		// generate randomly cntPoints points
		int cntPoints = n*m / 4;
		for (int i=0; i<cntPoints; ++i) {
			int row = (int) (Math.random()*n);
			int col = (int) (Math.random()*m);
			array[row][col] = true;
		}
		
		// even columns
		if (m%2 == 0) {
			for (int r=0; r<n; ++r) {
				// go through every column to check if there is a point
				for (int c=0; c<m; ++c) {
					// on the left side, if the position is true, then copy to the right side, vice versa
					// i.e. (2,3) --- (2,6)
					if (array[r][c]) {
						array[r][m-1-c] = array[r][c];
					}
				}
		
			}
		//odd columns
		}else {
			//at the middle, the position will be constant
			for (int r=0; r<n; ++r) {
				// left side
				for (int c=0; c<m/2; ++c) {
					if (array[r][c]) {
						array[r][m-1-c] = array[r][c];
					}
				}
				
				// right side
				for (int c=m/2+1; c<m; ++c) {
					if (array[r][c]) {
						array[r][m-1-c] = array[r][c];
					}
				}
			}
		}
		
		// print out the image
		System.out.println("A randomly generated, symmetrical "+n+" x "+m+" image:");
		for (int i=0; i<n; ++i) {
			String line = "";
			for (int j=0; j<m; ++j) {
				if (array[i][j]) {
					line = line + "*";
				}else {
					line = line + " ";
				}
			}
			System.out.println(line);
		}
		
	}

}
