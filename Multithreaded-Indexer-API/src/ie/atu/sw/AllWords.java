package ie.atu.sw;

import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Allows user to print out every unique word from a text file, with a choice
 * of alphabetical or reverse alphabetical order being offered. 
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class AllWords {

	private BookParser bParser = new BookParser();
	private Scanner s = new Scanner(System.in);

	/**
	 * <p>Parses the book text file into a Map.
	 * Creates a Set out of the text file's keys (that is, the set of unique 
	 * words in the text).
	 * Offers the user a choice between alphabetical and reverse alphabetical 
	 * order.
	 * Scanners input determines the users choice. 
	 * Prints out the words from the text in the chosen order, with 5 words per
	 * line.</p>
	 * 
	 * <p>Big O Running Time: O(n) 
	 * Rationale: parsing text file => O(n), 
	 * 			  retrieving and iterating over set => O(n). 
	 * 			  O(n) + O(n) = O(n)</p>
	 * 
	 * @param inputFile The specified book text file.
	 * @throws Exception. 
	 */
	public void allWords(String inputFile) throws Exception {
		int count = 0;
		bParser = new BookParser(); // clears any previously parsed books

		bParser.parse(inputFile);
		Set<String> words = bParser.getBookContents().keySet();

		System.out.println("[INFO] Alphabetical or Reverse Alphabetical Order");
		System.out.println("[REQUEST] Enter [1] for Alphabetical, [2] for Reverse Alphabetical>");
		int choice = Integer.parseInt(s.next());
		System.out.println();

		if (choice == 1) {
			for (String word : words) { // iterate over set of words
				System.out.print(word + "\s");
				count++;
				if (count % 5 == 0) System.out.print("\n"); // new line after every fifth word
			}
			System.out.println("\n");
		} else if (choice == 2) {
			List<String> list = new ArrayList<String>(words); 
			for (int i = list.size() - 1; i >= 0; i--) { // iterate over set of words in reverse order
				System.out.print(list.get(i) + "\s"); 
				count++;
				if (count % 5 == 0) System.out.print("\n"); // new line after every fifth word
			}
			System.out.println("\n");
		} else {
			System.out.println("[ERROR] Invalid number. Please enter 1 or 2 \n");
		}
	}

}
