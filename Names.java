import java.util.ArrayList;
import java.util.Scanner;

/**
 * A collection of NameRecords. 
 * Stores NameRecord objects and provides methods to select
 * NameRecords based on various criteria.
 */

public class Names {

	private ArrayList<NameRecord> names;
	private int baseDecade;
	private int numRanks;

	/**
	 * Create a name object from the given scanner hooked up to a txt file.
	 * all separated by spaces.
	 * 
	 * @param String s represents the name, int d represents the 
	 *        beginning decade of the rankings,
	 * 		  and int[] rank passes through the rankings of the name.
	 */
	public Names(Scanner sc) {
		names = new ArrayList<NameRecord>();
		baseDecade = Integer.parseInt(sc.nextLine());
		numRanks = Integer.parseInt(sc.nextLine());
		String line;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			NameRecord nr = new NameRecord(line, baseDecade);
			if (nr.getNumRanks() == numRanks) names.add(nr);
		}
	}

	/**
	 * Returns a name record with a matching name to the given String
	 * 
	 * @param s != null, partialName.length() > 0
	 * @return a name record with matching name
	 */
	public NameRecord sameName(String s) {
		if (s == null || s.isEmpty())
			throw new IllegalArgumentException("The given string is either null or empty.");
		for (int i=0; i<names.size(); i++) {
			NameRecord nr = names.get(i);
			if (nr.getName().toLowerCase().equals(s.toLowerCase())) return nr;
		}
		return null;
	}

	/**
	 * Returns an ArrayList of NameRecord objects that contain a 
	 * given substring, ignoring case.  The names must be in sorted order based 
	 * on name.
	 * @param partialName != null, partialName.length() > 0
	 * @return an ArrayList of NameRecords whose names contains
	 * partialName. If there are no NameRecords that meet this
	 * criteria returns an empty list. 
	 */
	public ArrayList<NameRecord> getMatches(String partialName) {
		ArrayList<NameRecord> matches = new ArrayList<NameRecord>();
		if (partialName == null || partialName.isEmpty())
			throw new IllegalArgumentException("The given string is either null or empty.");
		for (int i=0; i<names.size(); i++) {
			NameRecord nr = names.get(i);
			if (nr.getName().toLowerCase().contains(partialName.toLowerCase())) matches.add(nr);
		}
		return matches;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been ranked in the
	 * top 1000 or better for every decade. The Strings  must be in sorted 
	 * order based on name. 
	 * @return A list of the names that have been ranked in the top
	 * 1000 or better in every decade. The list is in sorted ascending
	 * order. If there are no NameRecords that meet this
	 * criteria returns an empty list.
	 */
	public ArrayList<String> rankedEveryDecade() {
		ArrayList<String> ranked = new ArrayList<String>();
		for (int i=0; i<names.size(); i++) {
			NameRecord nr = names.get(i);
			if (nr.alwaysTop()) ranked.add(nr.getName());
		}
		return ranked;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been ranked in the 
	 * top 1000 or better in exactly one decade. The Strings must be in sorted 
	 * order based on name. 
	 * @return A list of the names that have been ranked in the top
	 * 1000 or better in exactly one decade. The list is in sorted ascending
	 * order. If there are no NameRecords that meet this
	 * criteria returns an empty list.
	 */
	public ArrayList<String> rankedOnlyOneDecade() {
		ArrayList<String> ranked = new ArrayList<String>();
		for (int i=0; i<names.size(); i++) {
			NameRecord nr = names.get(i);
			if (nr.topOnce()) ranked.add(nr.getName());
		}
		return ranked;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been getting more
	 * popular every decade. The Strings  must be in sorted order based on name.
	 * @return A list of the names that have been getting more popular in
	 * every decade. The list is in sorted ascending
	 * order. If there are no NameRecords that meet this
	 * criteria returns an empty list. 
	 */
	public ArrayList<String> alwaysMorePopular() {
		ArrayList<String> ranked = new ArrayList<String>();
		for (int i=0; i<names.size(); i++) {
			NameRecord nr = names.get(i);
			if (nr.gettingBetter()) ranked.add(nr.getName());
		}
		return ranked;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been getting less
	 * popular every decade. The Strings  must be in sorted order based on name.
	 * @return A list of the names that have been getting less popular in
	 * every decade. The list is in sorted ascending
	 * order. If there are no NameRecords that meet this
	 * criteria returns an empty list. 
	 */
	public ArrayList<String> alwaysLessPopular() {
		ArrayList<String> ranked = new ArrayList<String>();
		for (int i=0; i<names.size(); i++) {
			NameRecord nr = names.get(i);
			if (nr.gettingWorse()) ranked.add(nr.getName());
		}
		return ranked;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been in the top ten
	 * The String will be formatted "NAME - DECADE"
	 * If a name is repeated, it will have a separate entry
	 * @return A list of the names that have been in the top ten.
	 * The list is in sorted ascending order. If there are no 
	 * NameRecords that meet this criteria returns an empty list. 
	 */
	public ArrayList<NameRecord> onceInTopTen() {
		ArrayList<NameRecord> ranked = new ArrayList<NameRecord>();
		for (int i=0; i<names.size(); i++) {
			NameRecord nr = names.get(i);
			for (int j=0; j<nr.getNumRanks(); j++) {
				int temp = nr.getRank(j);
				if (temp <= 10 && temp != 0 && !ranked.contains(nr)) ranked.add(nr);
			}
		}
		return ranked;
	}

}
