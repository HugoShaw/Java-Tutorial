package studio2;

import support.cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		double startAmount = ap.nextDouble("The amount of money that you have");
		double winChance = ap.nextDouble("The win probability");
		double winLimit = ap.nextDouble("The limit amount of money");
		int totalSimulations = ap.nextInt("The number of days");
		
		for( int i=0; i<totalSimulations; i++ ) {
			int count = 0;
			while((winLimit > startAmount) && (startAmount > 0)) {
				count=count+1;
				if(winChance >= Math.random()) {
					startAmount += 1;
					
//					System.out.println("win $1");
				}else {
					startAmount -= 1;
//					System.out.println("lose $1");
				}
			}			
		}

	}

}
