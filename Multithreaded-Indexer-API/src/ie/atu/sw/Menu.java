package ie.atu.sw;

import java.util.Scanner;

/**
 * Displays the application menu and allows the user to interact with the
 * application.
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class Menu {

	private Scanner s = new Scanner(System.in);
	private FileOutputter fileOutputter = new FileOutputter();
	private UniqueWords uniqueWords = new UniqueWords();
	private AllWords allWords = new AllWords();

	private boolean keepRunning = true;
	private boolean inputFileGiven = false;
	private boolean dictionaryConfigured = false;
	private boolean commonWordsConfigured = false;
	private boolean outputFileGiven = false;

	private String inputFile = "";
	private String outputFile = "";
	private String dictFile = "";
	private String commonWordsFile = "";

	/**
	 * <p>Prints the title banner to the terminal.
	 * Scanner allows user to choose an option from the menu.
	 * Menu stays running until the user calls the quit() method.</p>
	 * 
	 * <p>Big O Running Time: O(1).
	 * Rationale: printing title banner => O(1)</p>
	 * 
	 * @throws Exception. 
	 */
	public void showMenu() throws Exception {
		System.out.println("************************************************************");
		System.out.println("*       ATU - Dept. Computer Science & Applied Physics     *");
		System.out.println("*                                                          *");
		System.out.println("*              Virtual Threaded Text Indexer               *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");

		while (keepRunning) {
			showOptions();
			int choice = Integer.parseInt(s.next());

			switch (choice) {
			case 1 -> specifyTextFile();
			case 2 -> configureDictionary();
			case 3 -> specifyCommonWords();
			case 4 -> specifyOutputFile();
			case 5 -> uniqueWords();
			case 6 -> allWords();
			case 7 -> execute();
			case 8 -> quit();
			default -> throw new IllegalArgumentException("[ERROR] Invalid input: " + choice);
			}
		}
	}

	/*
	 * Prints the menu options to the terminal.
	 * Menu updates to reflect the user's input actions.
	 * 
	 * Big O Running Time: O(1).
	 * Rationale: printing menu options => O(1)
	 */
	private void showOptions() {
		if (inputFileGiven) {
			System.out.println("(1) Specify Text File [ENTERED]");
		} else {
			System.out.println("(1) Specify Text File");
		}
		if (dictionaryConfigured) {
			System.out.println("(2) Configure Dictionary [ENTERED]");
		} else {
			System.out.println("(2) Configure Dictionary");
		}
		if (commonWordsConfigured) {
			System.out.println("(3) Specify Common Words [ENTERED]");
		} else {
			System.out.println("(3) Specify Common Words");
		}
		if (outputFileGiven) {
			System.out.println("(4) Specify Output File [ENTERED]");
		} else {
			System.out.println("(4) Specify Output File");
		}
		System.out.println("(5) Calculate Number of Unique Words in Text File");
		System.out.println("(6) Print All Words in Text File");
		System.out.println("(7) Execute");
		System.out.println("(8) Quit");
	}

	/*
	 * Allows user to input the book text file they wish to index.
	 * Menu updates to show that the user has chosen a book text file.
	 * 
	 * Big O Running Time: O(1).
	 * Rationale: printing menu options => O(1),
	 * 			  scanning user's input and adjusting the backslashes in the
	 * 			  inputed file path => O(1).
	 * 			  O(1) + O(1) = O(1)
	 */
	private void specifyTextFile() throws Exception {
		System.out.println("[INFO] Specify Text File");
		System.out.println("[REQUEST] Please enter text file path>");
		inputFile = s.next();
		inputFile = inputFile.replaceAll("\\\\", "\\\\\\\\");

		inputFileGiven = true;
		System.out.println();
	}

	/*
	 * Allows user to configure the dictionary file.
	 * For the purposes of this exercise, it is assumed that the user is using
	 * the dictionary.csv file.
	 * Menu updates to show that the user has configured the dictionary.
	 * 
	 * Big O Running Time: O(1).
	 * Rationale: configure dictionary file => O(1)
	 */
	private void configureDictionary() throws Exception {
		dictFile = "./dictionary.csv";
		dictionaryConfigured = true;
		System.out.println();
	}

	/*
	 * Allows user to choose a text file containing words they wish to exclude
	 * from the index.
	 * Asks user if they wish to use the text file containing Google's 1000 
	 * most common words.
	 * User may instead opt to specify an alternative text file containing any
	 * words they wish to exclude.
	 * Menu updates to show that the user has chosen a text file containing 
	 * words to exclude from the index.
	 *  
	 * Big O Running Time: O(1).
	 * Rationale: printing menu options => O(1),
	 * 			  scanning user's input and adjusting the backslashes in the inputed file path => O(1).
	 * 			  O(1) + O(1) = O(1)
	 */
	private void specifyCommonWords() throws Exception {
		System.out.println("[INFO] Specify Common Words to exclude");
		System.out.println("[REQUEST] Would you like to exclude the default common words (Google's 1000 most common words)? [y/n]>");
		String answer = s.next();

		if (answer.equals("y")) {
			commonWordsFile = "./google-1000.txt";
			commonWordsConfigured = true;
		} else if (answer.equals("n")) {
			System.out.println("[INFO] Specify Text File of words to exclude");
			System.out.println("[REQUEST] Please enter file path>");
			commonWordsFile = s.next();
			commonWordsFile = commonWordsFile.replaceAll("\\\\", "\\\\\\\\");
			commonWordsConfigured = true;
		} else {
			System.out.println("[ERROR] Invalid answer. Please enter y or n");
			commonWordsConfigured = false;
		}
		System.out.println();
	}

	/*
	 * Allows user to input a file path which will be used to create the output
	 * file.
	 * Menu updates to show that the user has specified an output file path for
	 * the index.
	 * 
	 * Big O Running Time: O(1).
	 * Rationale: printing menu options => O(1),
	 * 			  scanning user's input and adjusting the backslashes in the inputed file path => O(1).
	 * 			  O(1) + O(1) = O(1)
	 */
	private void specifyOutputFile() {
		System.out.println("[INFO] Specify Output File.");
		System.out.println("[REQUEST] Please enter the desired output file path>");
		outputFile = s.next();
		outputFile = outputFile.replaceAll("\\\\", "\\\\\\\\");
		outputFileGiven = true;
		System.out.println();
	}
	
	/*
	 * Prints the amount of unique words in the specified book text file.
	 * Prints an error statement if the user has not yet specified a book text 
	 * file.
	 * 
	 * Big O Running Time: O(n).
	 * Rationale: running the uniqueWords() method => O(n)
	 */
	private void uniqueWords() throws Exception {
		if (inputFileGiven) {
			uniqueWords.uniqueWords(inputFile);
		} else {
			System.out.println("[ERROR] Please ensure you have specified a Text File \n");
		}
	}
	
	/**
	 * Prints the unique words in the book text file in alphabetical or reverse
	 * alphabetical order.
	 * Prints an error statement if the user has not yet specified a book text
	 * file to index.
	 * 
	 * Big O Running Time: O(n).
	 * Rationale: running the allWords() method => O(n)
	 */
	private void allWords() throws Exception {
		if (inputFileGiven) {
			allWords.allWords(inputFile);
		} else {
			System.out.println("[ERROR] Please ensure you have specified a Text File \n");
		}
	}

	/*
	 * Checks if the user have input all the necessary elements (book text 
	 * file, output file, dictionary, common words file).
	 * Passes these elements to the outputFile() method.
	 * Prints an error statement if any of the above elements are yet to be
	 * specified/configured, along with a statement highlighting which of the
	 * elements are missing.
	 * Calculates and prints the time taken to complete the entire indexing 
	 * operation.
	 * 
	 * Big O Running Time: O(n log n).
	 * Rationale: running the outputFile() method => O(n log n),
	 * 			  calculating the time taken to run the outputFile() method => O(1).
	 * 			  O(n log n) + O(1) = O(n log n)
	 */
	private void execute() throws Exception {			
		if (inputFileGiven && dictionaryConfigured && commonWordsConfigured && outputFileGiven) {
			long startTime = System.nanoTime(); 
			fileOutputter.outputFile(inputFile, outputFile, dictFile, commonWordsFile);
			long endTime = System.nanoTime(); 
			long timeElapsed = endTime - startTime;
			long elapsedMillis = timeElapsed / 1_000_000;
			System.out.println("\n[INFO] Output File has been created.");
			System.out.println("[INFO] Time taken: " + elapsedMillis + "ms \n");
		} else {
			System.out.println(
					"[ERROR] Please ensure you have specified a Text File, an Output File, a Common Words File, and configured the Dictionary.");
			// nested if statements print the missing data where applicable
			if (inputFileGiven == false) {
				System.out.println("[INFO] Missing data: Text File");
			}
			if (dictionaryConfigured == false) {
				System.out.println("[INFO] Missing data: Dictionary File");
			}				
			if (commonWordsConfigured == false) {
				System.out.println("[INFO] Missing data: Common Words File");
			}
			if (outputFileGiven == false) {
				System.out.println("[INFO] Missing data: Output File");
			}
			System.out.println();
		}
	}

	/*
	 * Allows user to quit the application gracefully.
	 * 
	 * Big O Running Time: O(1).
	 * Rationale: printing menu statement => O(1),
	 * 			  adjusting keepRunning boolean => O(1).
	 * 			  O(1) + O(1) = O(1)
	 */
	private void quit() {
		System.out.println("[INFO] Shutting down...");
		keepRunning = false;
	}

}
