package studio9;

import java.util.HashMap;
import java.util.Map;

import support.cse131.ArgsProcessor;
import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		HashMap<String, Integer> nameHeight = new HashMap<>();
		nameHeight.put("Elie", 180);
		nameHeight.put("Catrina", 155);
		nameHeight.put("Alex", 8);
		nameHeight.put("Judah", 230);
		nameHeight.put("Hugo", 175);
		nameHeight.put("Edan", 300);
		String name = ap.nextString("Choose a name:");
		while (name != null) {
			if (!nameHeight.containsKey(name)) {
				System.out.println("This is not a name");
			}
			else {
			System.out.println(name + " - " + nameHeight.get(name));
			}
			name = ap.nextString("Choose a name:");
		}
		System.out.println("kiwi");

		}
	}
