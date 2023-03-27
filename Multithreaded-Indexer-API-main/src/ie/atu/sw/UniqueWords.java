package ie.atu.sw;

/**
 * Keeps track of the pages that a word from the book text file appears on and
 * the amount of times it appears in total. 
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class UniqueWords {
	
	private BookParser bParser = new BookParser();
	
	/**
	 * <p>Parses the book text file.
	 * Prints the size of the book text file (in other words, the amount of 
	 * unique words contains in the book).</p>
	 * 
	 * <p>Big O Running Time: O(n). 
	 * Rationale: parsing the text file => O(n), 
	 * 			  retrieving the size and printing the amount of unique words in the text file => O(1). 
	 *            O(n) + O(1) = O(n)</p>
	 *            
	 * @param file The specified book text file.
	 * @throws Exception. 
	 */
	public void uniqueWords(String file) throws Exception {
		bParser = new BookParser(); // clears any previously parsed books
		bParser.parse(file);
		System.out.println("Unique Words: " + bParser.getBookContents().size() + "\n");
	}
	
}
