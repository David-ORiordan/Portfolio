package ie.atu.sw;

import java.util.Scanner;

public class Menu {

	private boolean keepRunning = true;
	private boolean directoryGiven;
	private boolean sizeGiven;
	private boolean outputGiven;
	private boolean nGramFormatChoice;
	private int chunkyOrOffsetChoice;
	private String inputFile = "";
	private String outputFile = "";
	private int size;
	private NGramOutputter NGO = new NGramOutputter();
	private Scanner s = new Scanner(System.in);

	/*
	 * Displays the user menu. 
	 * Menu keeps running until the user opts to quit the application. 
	 * Switch statement allows access to the various application methods available to the user.
	 * 
	 * Code derived from the Object Oriented Programming Assignment Workshop.
	 */
	public void show() throws Exception {
		System.out.println("************************************************************");
		System.out.println("*      ATU - Dept. Computer Science & Applied Physics      *");
		System.out.println("*                                                          *");
		System.out.println("*                 N-Gram Frequency Builder                 *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");
		while (keepRunning) {
			showOptions();
			int choice = Integer.parseInt(s.next());

			switch (choice) {
			case 1 -> getTextDirectory();
			case 2 -> getSize();
			case 3 -> getFormat();
			case 4 -> getOutputFile();
			case 5 -> buildNGram();
			case 6 -> viewData();
			case 7 -> resetData();
			case 8 -> quit();
			default -> throw new IllegalArgumentException("[ERROR] Invalid input: " + choice);
			}

		}
	}

	// Prints the menu options available to the user.
	// Notifies user of where they have already submitted data.
	public void showOptions() {
		if (directoryGiven) {
			System.out.println("(1) Specify Text File Directory [ENTERED]");
		} else {
			System.out.println("(1) Specify Text File Directory");
		}
		if (sizeGiven) {
			System.out.println("(2) Specify n-Gram Size [ENTERED]");
		} else {
			System.out.println("(2) Specify n-Gram Size");
		}
		if (chunkyOrOffsetChoice == 1 || chunkyOrOffsetChoice == 2) {
			System.out.println("(3) Specify an n-Gram format [ENTERED]");
		} else {
			System.out.println("(3) Specify an n-Gram Format");
		}
		if (outputGiven) {
			System.out.println("(4) Specify Output File [ENTERED]");
		} else {
			System.out.println("(4) Specify Output File");
		}
		System.out.println("(5) Build n-Grams");
		System.out.println("(6) View Data");
		System.out.println("(7) Reset Data");
		System.out.println("(8) Quit");
		System.out.print("[REQUEST] Select Option [1-8]>");
		System.out.println();
	}

	// Asks user to input the text file directory where their text files are located.
	public void getTextDirectory() throws Exception {
		System.out.println("[INFO] Specify Text File Directory.");
		System.out.println("[NOTE] Any backslash characters (\\) within a file path need to be entered twice.");
		System.out.println("[EXAMPLE] C:\\\\Users\\\\username\\\\documents\\\\textfiles, instead of C:\\Users\\username\\documents\\textfiles");
		System.out.println("[REQUEST] Please enter file directory name>");
		inputFile = s.next();
		directoryGiven = true;
		System.out.println();
	}

	// Asks user to select the desired size for the n-Grams (between 1 and 5).
	public void getSize() {
		System.out.println("[INFO] Specify n-Gram size.");
		System.out.println("[REQUEST] Please enter a size between 1 and 5>");
		size = Integer.parseInt(s.next());
		if (size < 1 || size > 5) {
			System.out.println("[ERROR] Invalid number. Please enter a number between 1 and 5.");
			System.out.println();
		} else {
			sizeGiven = true;
			System.out.println();
		}

	}

	// Asks user to select the desired n-Grams format (chunky or offset).
	public void getFormat() {
		System.out.println("[INFO] Specify n-Gram Format.");
		System.out.println("[EXAMPLE] Chunky 2-Gram of the word \"sample\" ==> {sa},{mp},{le}");
		System.out.println("\t\s Offset 2-Gram of the word \"sample\" ==> {sa},{am},{mp},{pl},{le}");
		System.out.println("\t\s [NOTE] For chunky n-Grams, trailing character will be discarded.");
		System.out.println(
				"\t\s [EXAMPLE] Chunky 2-Gram of \"example\" ==> {ex},{am},{pl}, with the final character ('e') discarded.");
		System.out.println(
				"[REQUEST] Please enter 1 for a chunky n-Gram, 2 for an offset n-Gram>");
		chunkyOrOffsetChoice = Integer.parseInt(s.next());
		if (chunkyOrOffsetChoice == 1) {
			nGramFormatChoice = true; // chunky
		} else if (chunkyOrOffsetChoice == 2) {
			nGramFormatChoice = false; // offset
		} else {
			System.out.println("[ERROR] Invalid number. Please enter a number between 1 and 2.");
		}
		System.out.println();
	}

	// Asks user to input the name and path of the output file which will be created by the application.
	public void getOutputFile() {
		System.out.println("[INFO] Specify Output File.");
		System.out.println("[NOTE] Any backslash characters (\\) within a file path need to be entered twice.");
		System.out.println("[EXAMPLE] C:\\\\Users\\\\username\\\\documents\\\\destinationFolder\\\\nGramFile.csv, instead of C:\\Users\\username\\documents\\destinationFolder\\nGramFile.csv");
		System.out.println("[REQUEST] Please enter a complete output file name and path>");
		outputFile = s.next();
		outputGiven = true;
		System.out.println();
	}

	/*
	 * Assesses whether or not the user has input all the required data. 
	 * If the user has input all the required data, the output file is created to the specifications given by the user.
	 * The start and end time (in nanoseconds) for running this method are calculated, then converted to milliseconds.
	 * A message is printed following the completion of the task, along with the time taken.
	 * If the user has not input all the required data, a message will be displayed highlighting the data that is missing.
	 */
	public void buildNGram() throws Exception {
		if (directoryGiven == true && sizeGiven == true && outputGiven == true
				&& (chunkyOrOffsetChoice == 1 || chunkyOrOffsetChoice == 2)) {
			long startTime = System.nanoTime(); 
			Parser p = new Parser(size);
			Object[][] table = p.parseDir(inputFile, nGramFormatChoice);
			NGO.save(table, outputFile, size);
			long endTime = System.nanoTime(); 
			long timeElapsed = endTime - startTime;
			long elapsedMillis = timeElapsed / 1000000;
			System.out.println();
			System.out.println("[INFO] The n-Gram has been created.");
			System.out.println("[INFO] Time taken: " + elapsedMillis + "ms");
			System.out.println();
		} else {
			System.out.println(
					"[ERROR] Please ensure you have specified a Text File Directory, output file, n-Gram size, and n-Gram format.");
			// nested if statements print the missing data where applicable
			if (directoryGiven != true) {
				System.out.println("[INFO] Missing data: Text File Directory");
			}
			if (sizeGiven != true) {
				System.out.println("[INFO] Missing data: n-Gram size");
			}				
			if (chunkyOrOffsetChoice != 1 && chunkyOrOffsetChoice != 2) {
				System.out.println("[INFO] Missing data: n-Gram format");
			}
			if (outputGiven != true) {
				System.out.println("[INFO] Missing data: Output file");
			}
			System.out.println();
		}
	}

	// Allows user to view the data they have entered into the application.
	public void viewData() {
		if (inputFile == "") {
			System.out.println("Text File Directory: Not specified");
		} else {
			System.out.println("Text File Directory: " + inputFile);
		}
		if (size == 0) {
			System.out.println("n-Gram Size: Not specified");
		} else {
			System.out.println("n-Gram Size: " + size);
		}
		if (chunkyOrOffsetChoice == 1) {
			System.out.println("n-Gram Format: Chunky");
		} else if (chunkyOrOffsetChoice == 2) {
			System.out.println("n-Gram Format: Offset");
		} else {
			System.out.println("n-Gram Format: Not specified");
		}
		if (outputFile == "") {
			System.out.println("Output File: Not specified");
		} else {
			System.out.println("Output File: " + outputFile);
		}
		System.out.println();

	}

	// Allows user to reset any or all data that has been entered into the application.
	public void resetData() {
		System.out.println("[INFO] Reset data.");
		System.out.println("(1) Reset Text File Directory");
		System.out.println("(2) Reset n-Gram Size");
		System.out.println("(3) Reset n-Gram format");
		System.out.println("(4) Reset Output File");
		System.out.println("(5) Reset all data");
		System.out.println("(6) Exit");
		System.out.println("[REQUEST] Select Option [1-6]>");
		int resetChoice = Integer.parseInt(s.next());
		if (resetChoice == 1) {
			directoryGiven = false;
			inputFile = "";
			System.out.println("[INFO] Data has been reset.");
			System.out.println();
		} else if (resetChoice == 2) {
			sizeGiven = false;
			size = 0;
			System.out.println("[INFO] Data has been reset.");
			System.out.println();
		} else if (resetChoice == 3) {
			chunkyOrOffsetChoice = 0;
			System.out.println("[INFO] Data has been reset.");
			System.out.println();
		} else if (resetChoice == 4) {
			outputGiven = false;
			outputFile = "";
			System.out.println("[INFO] Data has been reset.");
			System.out.println();
		} else if (resetChoice == 5) {
			directoryGiven = false;
			sizeGiven = false;
			outputGiven = false;
			inputFile = "";
			outputFile = "";
			chunkyOrOffsetChoice = 0;
			size = 0;
			System.out.println("[INFO] All data has been reset.");
			System.out.println();
		} else if (resetChoice == 6) {
			System.out.println("[INFO] Data has not been reset.");
			System.out.println();
		} else {
			System.out.println("[ERROR] Invalid number. Please enter a number between 1 and 2.");
		}
	}

	// Allows user to quit the application.
	public void quit() {
		System.out.println("[INFO] Shutting down.");
		keepRunning = false;
	}

}
