package assignment2;

import support.cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int stickNum = ap.nextInt("How many sticks in total?");
		double robSticks = Math.random();
		
		int count = 0;
		while (stickNum>0) {
			count = count + 1;
			
			if (count%2 != 0) {
				// odd turn -- human
				boolean val = false;
				int humSticks = 0;
				while (!val) {
					humSticks = ap.nextInt("How many sticks human takes?");
					if (humSticks == 1 || humSticks == 2) {
						if (stickNum>=2) {
							val = true;
						}else{
							if (humSticks==1) {
								val = true;
							}
						}
					}else {
						val = false;
					}
				}
				
				int OrgStick = stickNum;
				stickNum = stickNum-humSticks;
				
				System.out.println("Round "+(count-1)+": "+OrgStick+" at start human takes "+humSticks+", so "+stickNum+" remain");
		
			}else{
				// even turn -- robot
				int OrgStick = stickNum;
				if (robSticks > 0.5 && stickNum>=2) {
					stickNum = stickNum-2;
					System.out.println("Round "+(count-1)+": "+OrgStick+" at start computer takes 2, so "+stickNum+" remain");
				}else {
					stickNum = stickNum-1;
					System.out.println("Round "+(count-1)+": "+OrgStick+" at start computer takes 1, so "+stickNum+" remain");
				}
			}
		}

		if (count%2==0) {
			System.out.println("The computer wins / you lose!");
		}else {
			System.out.println("You win / The computer lose!");
		}
		
		
	}

}
