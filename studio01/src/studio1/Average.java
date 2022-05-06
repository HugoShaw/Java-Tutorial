package studio1;

import support.cse131.ArgsProcessor;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int n1 = ap.nextInt("Input your first integer:");
		int n2 = ap.nextInt("Input your second integer:");
		
		double avgValue = (n1 + n2) / 2.0;
		
		System.out.println("Average of "+n1+" and "+n2+" is "+avgValue);

	}

}
