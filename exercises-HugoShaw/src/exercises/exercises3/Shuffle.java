package exercises.exercises3;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};

		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}

		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		
//		declare shuffled array, same as the original one
//		String[] shuffled = new String[original.length];
		
//		iterate backwards over shuffled array to fill in it
		for (int i=original.length-1; i>=0; --i) {
//			pick a card from the array
			int c = (int) (Math.random()*(i+1));
//			original[i] = original[c];
//			move all the cards up from c+1 to length-1
//			for (int j=c; j<shuffled.length-1;++j) {
//				original[j]=original[j+1];
//			}
//			we can swap original[i] and original[c]
			String t = original[i];
			original[i] = original[c];
			original[c]=t;
			
		}
		
		
		for (int i = 0; i < original.length; ++i) {
			System.out.println("Shuffled at"+i+"is "+original[i]);
		}
	}
	
}