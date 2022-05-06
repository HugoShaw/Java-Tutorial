package exercises.exercises3;

import support.cse131.ArgsProcessor;

public class TimesTable {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Max value for table?");
		
		//  Table should include rows and columns for 0...N  
		//     mkaing N+1 rows and columns
		int[][] table = new int[N+1][N+1];
		for (int r=0;r<=N;++r) {
//			each row
			for (int c=0; c<=N; ++c) {
//				each column
				table[r][c] = r*c;
			}
			
		}
		
//		we need to print out the table with the table label
		System.out.print("     ");
		for (int c = 0; c<=N ; ++c) {
			System.out.print(c + "  ");
		}
		System.out.println();
		for (int c=0; c<=N+1; ++c) {
			System.out.print("---");
		}
		System.out.println("");
		for (int r = 0; r<=N; ++r) {
			System.out.print(r+" | ");
			for (int c=0; c<=N;++c) {
				int entry = table[r][c];
				if (entry<10) {
					System.out.print(" "+table[r][c]+" ");
				}else {
					System.out.print(table[r][c]+" ");
				}
			}
			System.out.print("\n");
		}
	}

}
