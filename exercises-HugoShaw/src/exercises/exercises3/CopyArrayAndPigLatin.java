package exercises.exercises3;

public class CopyArrayAndPigLatin {

	public static void main(String[] args) {
		String[] names = { "Alice", "Bob", "Carole", "David", "Elaine" };
		
		// first copy the above array into an array named copy
		//  Pretend the names array is large
		//  So we cannot just do the following (too much to type):
		//     String[] copy = { names[0], names[1], names[2] };
		//
//		make the copy array empty initially (filled with null)
		String[] copy = new String[names.length];
		
		// 
		// Follow the instructions on the web page to check
		// that your copy is correct.  Then cause the copy to store the
		// copied strings in "Pig Latin".  Do this by iteration without
		// assuming the length or contents of the names array.
		//
//		now iterate to fill the array with the contents of names
		for (int i=0; i<names.length; ++i) {
			copy[i] = names[i];
		}
		
//		look at the array
		for (int i=0; i<names.length;++i) {
			System.out.println("Original array names"+names[i]);
			System.out.println("Copy array names"+copy[i]);
		}
	}

}
