package practice4;

import support.cse131.ArgsProcessor;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class Equality {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String a = ap.nextString("a?");
		String b = ap.nextString("b?");

		System.out.println("a: \"" + a + "\"");
		System.out.println("b: \"" + b + "\"");
		System.out.println();

		System.out.println("***NOT*** RECOMMENDED.  Do ***NOT*** use == for Strings.");
		System.out.println("=========------------------=========--------------------");
		System.out.println("a==b?");
		System.out.println(a == b);
		System.out.println();

		System.out.println("Recommended.  Use a.equals(b) for Strings.");
		System.out.println("------------------------------------------");
		System.out.println("a.equals(b)?");
		System.out.println(a.equals(b));
		System.out.println();
	}
}
