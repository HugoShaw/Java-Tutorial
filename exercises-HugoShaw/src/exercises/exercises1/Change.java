package exercises.exercises1;
import support.cse131.ArgsProcessor;

public class Change {

	public static void main(String[] args) {
		//
		// Below, prompt the user to enter a number of pennies
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int pennies = ap.nextInt("Number of Pennies:");
		
		int dollar = 100;
		int quarter = 25;
		int dime = 10;
		int nickel = 5;
		
		int dollars = pennies/dollar;
		int quarters = (pennies % dollar) / quarter;
		int dimes = ((pennies % dollar) % quarter) / dime;
		int nickels =  (((pennies % dollar) % quarter) % dime)/nickel;
		
		System.out.println("For "+pennies+" pennies:");
		System.out.println(dollars+" dollars");
		System.out.println(quarters+" quarters");
		System.out.println(dimes+" dimes");
		System.out.println(nickels+" nickels");
		System.out.println((((pennies % dollar) % quarter) % dime)%nickel+" pennies");
		//
		// Then, compute and print out how many 
		//    dollars, quarters, dimes, nickels, and pennies
		// should be given in exchange for those pennies, so as to
		// minimize the number of coins (see the videos)
		//
	}

}
