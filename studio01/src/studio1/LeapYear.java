package studio1;

import support.cse131.ArgsProcessor;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int year = ap.nextInt("Input year:");
		
		boolean leapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
		
		System.out.println(year+" is a leap year: "+leapYear);
	}

}
