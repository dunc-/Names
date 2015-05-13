import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	public static final int TOP_TEN = 7;
	public static final int QUIT = 8;

	// CS314 students, explain your menu option 7 here:
	// My menu option 7 gets any name that has ever been ranked in the top 10
	// as well as how often it was ranked in the given time period.

	// CS314 students, Explain your interesting search / trend here:
	// One interesting name trend I found was that people are naming
	// their children with more stylish names. For example, River
	// was not ranked until 1990, but is ranked #615 for 2000. Sage
	// is also a good example. Sage was not ranked until 1990, but was
	// ranked #494 in 2000. Names like these are given for style
	// purposes and definitely bump the norm. Parents are trying to make
	// a big statement on how unique their child is by naming it 
	// something unique.

	// CS314 students, add test code for NameRecord class here:
	public static void nameRecordTest() {

		String jakeRawData = "Jake 262 312 323 479 484 630 751 453 225 117 97";
		int baseDecade = 1900;
		NameRecord jakeRecord =  new NameRecord(jakeRawData, baseDecade);

		String amyRawData = "Amy 0 0 0 0 0 0 0 12 0 0 0";
		NameRecord amyRecord = new NameRecord(amyRawData, baseDecade);

		String betterRawData = "Better 0 1000 950 900 850 800 750 700 650 600 550";
		NameRecord betterRecord = new NameRecord(betterRawData, baseDecade);

		String worseRawData = "Worse 550 600 650 700 750 800 850 900 950 1000 0";
		NameRecord worseRecord = new NameRecord(worseRawData, baseDecade);

		String betterZerosRawData = "Zero1 0 0 1000 950 900 850 800 750 700 650 600";
		NameRecord betterZerosRecord = new NameRecord(betterZerosRawData, baseDecade);

		String worseZerosRawData = "Zero2 550 600 650 700 750 800 850 900 950 0 0";
		NameRecord worseZerosRecord = new NameRecord(worseZerosRawData, baseDecade);

		// Test #1 - toString
		String expected = "Jake\n1900: 262\n1910: 312\n1920: 323\n1930: 479\n1940: 484\n1950: "
				+ "630\n1960: 751\n1970: 453\n1980: 225\n1990: 117\n2000: 97\n";
		String actual = jakeRecord.toString();
		if(expected.equals(actual))
			System.out.println("passed Jake toString test.");
		else
			System.out.println("FAILED Jake toString test.");

		// Test #2 - bestRank
		int expected1 = 2000;
		int actual1 = jakeRecord.bestRank();
		if(expected1 == actual1)
			System.out.println("passed Jake bestRank test.");
		else
			System.out.println("FAILED Jake bestRank test.");

		// Test #3 - getName
		expected = "Jake";
		actual = jakeRecord.getName();
		if(expected.equals(actual))
			System.out.println("passed Jake getName test.");
		else
			System.out.println("FAILED Jake getName test.");

		// Test #4 - getDecade
		expected1 = 1900;
		actual1 = jakeRecord.getDecade();
		if(expected1 == actual1)
			System.out.println("passed Jake getDecade test.");
		else
			System.out.println("FAILED Jake getDecade test.");

		// Test #5 - getRank
		expected1 = 630;
		actual1 = jakeRecord.getRank(5);
		if(expected1 == actual1)
			System.out.println("passed Jake getRank test.");
		else
			System.out.println("FAILED Jake getRank test.");

		// Test #6 - numTimesInTop
		expected1 = 11;
		actual1 = jakeRecord.numTimesInTop();
		if(expected1 == actual1)
			System.out.println("passed Jake numTimesInTop test.");
		else
			System.out.println("FAILED Jake numTimesInTop test.");

		// Test #7 - alwaysTop
		boolean expected2 = true;
		boolean actual2 = jakeRecord.alwaysTop();
		if(expected2 == actual2)
			System.out.println("passed Jake alwaysTop test.");
		else
			System.out.println("FAILED Jake alwaysTop test.");

		// Test #8 - topOnce
		expected2 = true;
		actual2 = amyRecord.topOnce();
		if(expected2 == actual2)
			System.out.println("passed Amy topOnce test.");
		else
			System.out.println("FAILED Amy topOnce test.");

		// Test #9 - topOnce
		expected2 = false;
		actual2 = jakeRecord.topOnce();
		if(expected2 == actual2)
			System.out.println("passed Jake topOnce test.");
		else
			System.out.println("FAILED Jake topOnce test.");

		// Test #10 - alwaysTop
		expected2 = false;
		actual2 = amyRecord.alwaysTop();
		if(expected2 == actual2)
			System.out.println("passed Amy alwaysTop test.");
		else
			System.out.println("FAILED Amy alwaysTop test.");

		// Test #11 - gettingBetter
		expected2 = true;
		actual2 = betterRecord.gettingBetter();
		if(expected2 == actual2)
			System.out.println("passed Better gettingBetter test.");
		else
			System.out.println("FAILED Better gettingBetter test.");

		// Test #12 - gettingBetter
		expected2 = false;
		actual2 = worseRecord.gettingBetter();
		if(expected2 == actual2)
			System.out.println("passed Worse gettingBetter test.");
		else
			System.out.println("FAILED Worse gettingBetter test.");

		// Test #13 - gettingBetter
		expected2 = false;
		actual2 = betterZerosRecord.gettingBetter();
		if(expected2 == actual2)
			System.out.println("passed Zeros1 gettingBetter test.");
		else
			System.out.println("FAILED Zeros1 gettingBetter test.");

		// Test #14 - gettingWorse
		expected2 = true;
		actual2 = worseRecord.gettingWorse();
		if(expected2 == actual2)
			System.out.println("passed Worse gettingWorse test.");
		else
			System.out.println("FAILED Worse gettingWorse test.");

		// Test #15 - gettingWorse
		expected2 = false;
		actual2 = betterRecord.gettingWorse();
		if(expected2 == actual2)
			System.out.println("passed Better gettingWorse test.");
		else
			System.out.println("FAILED Better gettingWorse test.");

		// Test #16 - gettingWorse
		expected2 = false;
		actual2 = worseZerosRecord.gettingWorse();
		if(expected2 == actual2)
			System.out.println("passed Zeros2 gettingWorse test.");
		else
			System.out.println("FAILED Zeros2 gettingWorse test.");

		// Test #17 - bestRank
		expected1 = 1970;
		actual1 = amyRecord.bestRank();
		if(expected1 == actual1)
			System.out.println("passed Amy bestRank test.");
		else
			System.out.println("FAILED Amy bestRank test.");
	}

	// main method. Driver for the whole program
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			System.out.println("Unable to set look at feel to local settings. " +
					"Continuing with default Java look and feel.");
		}
		try { 

			// uncomment the next two lines if you want to let user obtain file via GUI
			//System.out.println("Opening GUI to choose file with names data...");
			//Scanner fileScanner = new Scanner(getFile());
			// uncomment next line to hard code name file
			Scanner fileScanner = new Scanner(new File("names.txt"));
			Names n = new Names(fileScanner);
			fileScanner.close();
			int choice;
			Scanner keyboard = new Scanner(System.in);
			do {
				showMenu();
				choice = getChoice(keyboard);
				if(choice == SEARCH)
					search(n, keyboard);
				else if(choice == ONE_NAME)
					oneName(n, keyboard);
				else if(choice == APPEAR_ONCE)
					appearOnce(n);
				else if(choice == APPEAR_ALWAYS)
					appearAlways(n);
				else if(choice == MORE_POPULAR)
					morePopular(n);
				else if(choice == LESS_POPULAR)
					lessPopular(n);
				else if(choice == TOP_TEN)
					topTen(n);
				else
					System.out.println("\n\nGoodbye.");

			} while( choice != QUIT);      
		}        
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Exiting the program." + e);       
		}      
	}

	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {
		if (n == null)
			throw new IllegalArgumentException("The names object is null.");
		ArrayList<String> ranked = n.rankedEveryDecade();
		System.out.println(ranked.size() + " names appear in every decade. The names are: "); 
		for (int i=0; i<ranked.size(); i++)
			System.out.println(ranked.get(i));
	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {
		if (n == null)
			throw new IllegalArgumentException("The names object is null.");
		ArrayList<String> ranked = n.rankedOnlyOneDecade();
		System.out.println(ranked.size() + " names appear in exactly one decade. The names are: ");
		for (int i=0; i<ranked.size(); i++)
			System.out.println(ranked.get(i));
	}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {
		if (n == null || keyboard == null)
			throw new IllegalArgumentException("Either the names object or the Scanner is null.");
		System.out.print("Enter a name: ");
		String s = keyboard.nextLine();
		System.out.println();
		NameRecord nr = n.sameName(s);
		if (nr == null) System.out.println(s + " does not appear in any decade.");
		else System.out.println(nr.toString());
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data		
	private static void search(Names n, Scanner keyboard) {
		if (n == null || keyboard == null)
			throw new IllegalArgumentException("Either the names object or the Scanner is null.");
		System.out.print("Enter a partial name: ");
		String s = keyboard.nextLine();
		System.out.println();
		ArrayList<NameRecord> nr = n.getMatches(s);
		if (nr.isEmpty()) System.out.println("There are " + nr.size() + " matches for " + s + ".");
		else {
			System.out.println("There are " + nr.size() + " matches for " + s + ".\n");
			System.out.println("The matches with their highest ranking decade are:");
			for (int i=0; i<nr.size(); i++)
				System.out.println(nr.get(i).getName() + " " + nr.get(i).bestRank());
		}
	}

	// method that shows names that have become more popular over every decade
	// pre: n != null
	// post: print out names that have become more popular over every decade
	private static void morePopular(Names n) {
		if (n == null)
			throw new IllegalArgumentException("The names object is null.");
		ArrayList<String> s = n.alwaysMorePopular();
		if (s == null) System.out.println("0 names are more popular in every decade.");
		else {
			System.out.println(s.size() + " names are more popular in every decade.");
			for (int i=0; i<s.size(); i++)
				System.out.println(s.get(i));
		}
	}

	// method that shows names that have become more popular over every decade
	// pre: n != null
	// post: print out names that have become more popular over every decade
	private static void lessPopular(Names n) {
		if (n == null)
			throw new IllegalArgumentException("The names object is null.");
		ArrayList<String> s = n.alwaysLessPopular();
		if (s == null) System.out.println("0 names are less popular in every decade.");
		else {
			System.out.println(s.size() + " names are less popular in every decade.");
			for (int i=0; i<s.size(); i++)
				System.out.println(s.get(i));
		}
	}

	// method that shows names that have been in the top ten at least once
	// pre: n != null
	// post: print out names that have become more popular over every decade
	private static void topTen(Names n) {
		if (n == null)
			throw new IllegalArgumentException("The names object is null.");
		ArrayList<NameRecord> nr = n.onceInTopTen();
		System.out.println();
		if (nr == null) System.out.println("0 names have been in the top ten.");
		else {
			System.out.println(nr.size() + " names have been in the top ten.\n");
			for (int i=0; i<nr.size(); i++) {
				System.out.println(nr.get(i).getName() + " has been in the top ten " + 
						nr.get(i).tenOrLower() + " times");
			}
		}
	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}

	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
	private static int getInt(Scanner s, String prompt) {
		System.out.print(prompt);
		while( !s.hasNextInt() ){
			s.next();
			System.out.println("That was not an int.");
			System.out.print(prompt);
		}
		return s.nextInt();
	}

	// show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear "
				+ "in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear "
				+ "in all decades.");
		System.out.println("Enter " + MORE_POPULAR + " to display all names that are more "
				+ "popular in every decade.");
		System.out.println("Enter " + LESS_POPULAR + " to display all names that are less "
				+ "popular in every decade.");
		System.out.println("Enter " + TOP_TEN + " to display all names that were in the top "
				+ "ten along with the frequency of these appreances.");
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/** Method to choose a file using a traditional window.
	 * @return the file chosen by the user. Returns null if no file picked.
	 */ 
	public static File getFile() {
		// create a GUI window to pick the text to evaluate
		JFileChooser chooser = new JFileChooser(".");
		chooser.setDialogTitle("Select File With Baby Names Data.");
		int retval = chooser.showOpenDialog(null);
		File f =null;
		chooser.grabFocus();
		if (retval == JFileChooser.APPROVE_OPTION)
			f = chooser.getSelectedFile();
		return f;
	}

}
