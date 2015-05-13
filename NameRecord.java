import java.util.ArrayList;

public class NameRecord {

	private String name;
	private ArrayList<Integer> ranks;
	private int decade;

	/**
	 * Create a name record from a formatted data string: name followed by ranks,
	 * all separated by spaces.
	 * 
	 * @param String s represents the name, int d represents the beginning decade of the rankings,
	 * 		  and int[] rank passes through the rankings of the name.
	 */
	public NameRecord(String s, int d) {
		ranks = new ArrayList<Integer>();
		decade = d;
		String[] split = s.split(" ");
		name = split[0];
		for (int i=1; i<split.length; i++)
			ranks.add(Integer.parseInt(split[i]));
	}

	/**
	 * Returns name of this record.
	 *
	 * @return name of this record
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the rank for the first decade.
	 *
	 * @return rank of the name for the first decade
	 */
	public int getDecade() {
		return decade;
	}

	/**
	 * Returns the rank for the given decade.
	 *
	 * @param decade for which to rank to return must be greater 
	 * than or equal to 0 and within the maximum decade
	 * @return rank of the name for the given decade
	 */
	public int getRank(int d) {
		if (d < 0 || d > (decade + (ranks.size()-1)*10))
			throw new IllegalArgumentException("Decade given is out of the data's range.");
		return ranks.get(d);
	}

	/**
	 * Returns the decade with the best rank.
	 *
	 * @return rank of the best decade.
	 */
	public int bestRank() {
		int bestDecade = 0;
		int bestRank = 1001;
		for (int i=0; i<ranks.size(); i++) {
			if (ranks.get(i) <= bestRank && ranks.get(i) != 0) {
				bestRank = ranks.get(i);
				bestDecade = i;
			}
		}
		return this.decade + bestDecade*10;
	}

	/**
	 * Returns the number of times the name has been ranked in the top 1000.
	 *
	 * @return number of times the name has been ranked in the top 1000.
	 */
	public int numTimesInTop() {
		int numTimes = 0;
		for (int i=0; i<ranks.size(); i++)
			if (ranks.get(i) > 0) numTimes++;
		return numTimes;
	}

	/**
	 * Returns true if the name has been ranked in the top 1000 every time.
	 *
	 * @return true or false based on the condition.
	 */
	public boolean alwaysTop() {
		for (int i=0; i<ranks.size(); i++)
			if (ranks.get(i) == 0) return false;
		return true;
	}

	/**
	 * Returns true if the name has been ranked in the top 1000 once.
	 *
	 * @return true or false based on the condition.
	 */
	public boolean topOnce() {
		boolean notChecked = true;
		boolean returnMe = false;
		for (int i=0; i<ranks.size(); i++) {
			if (ranks.get(i) > 0 && notChecked == true) {
				returnMe = true;
				notChecked = false;
			}
			else if (ranks.get(i) > 0 && notChecked == false) returnMe = false;
		}
		return returnMe;
	}

	/**
	 * Returns true if the name has been increasing in rank.
	 *
	 * @return true or false based on the condition.
	 */
	public boolean gettingBetter() {
		for (int i=1; i<ranks.size(); i++)
			if ((ranks.get(i) > ranks.get(i-1) && ranks.get(i-1) != 0) || 
					ranks.get(i) == ranks.get(i-1)) return false;
		return true;
	}

	/**
	 * Returns true if the name has been decreasing in rank.
	 *
	 * @return true or false based on the condition.
	 */
	public boolean gettingWorse() {
		for (int i=1; i<ranks.size(); i++)
			if ((ranks.get(i) < ranks.get(i-1) && ranks.get(i) != 0) || 
					ranks.get(i-1) == 0 || 
					ranks.get(i) == ranks.get(i-1)) return false;
		return true;
	}

	/**
	 * Returns a string displaying the name and its ranking for each year.
	 *
	 * @return the string with proper data and formatting
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(name + "\n");
		for (int i=0; i<ranks.size(); i++)
			sb.append((decade + i*10) + ": " + ranks.get(i) + "\n");
		return sb.toString();
	}

	/**
	 * Returns the number of ranks for a name record object
	 *
	 * @return the number of ranks
	 */
	public int getNumRanks() {
		return ranks.size();
	}

	/**
	 * Returns the number of times a name has been ranked at 10 or lower
	 *
	 * @return the number of times a name has been ranked at 10 or lower
	 */
	public int tenOrLower() {
		int count = 0;
		for (int i=0; i<ranks.size(); i++) {
			if (ranks.get(i) <= 10) count++;
		}
		return count;
	}
}
