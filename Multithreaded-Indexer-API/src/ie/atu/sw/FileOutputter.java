package ie.atu.sw;

import java.io.File;
import java.io.PrintWriter;

/**
 * Produces the output file, adding each word from the book that has a 
 * dictionary definition and isn't included in the group of excluded words
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class FileOutputter {

	private BookParser bParser = new BookParser();
	private DictionaryParser dParser = new DictionaryParser();
	private Google1000Parser gParser = new Google1000Parser();
	
	/**
	 * <p>Takes in the names of book text file, output file, dictionary file, 
	 * and common word file.
	 * Parses the book text file, output file, and dictionary file.
	 * Sets up a PrintWriter to create and add to the output file.
	 * Loops through each unique word in the book text file.
	 * Filters out any word that is contained in the common words file.
	 * Checks if the word is in the dictionary file.
	 * Adds the word, the word's definition, the pages the word appears on, and
	 * the amount of times the word appears to the output file.
	 * Closes the PrintWriter stream.</p>
	 * 
	 * <p>Big O Running Time: O(n log n).
	 * Rationale: parsing the input text file => O(n), 
	 * 			  parsing the dictionary file => O(n), 
	 * 			  parsing the common words file => O(n), 
	 * 			  looping through each word in the input text file map => O(n), 
	 * 			  checking if each looped word is in the set of common words => O(log n),
	 * 			  checking if each looped word is in the key set of dictionary words => O(log n),
	 * 			  for each looped word, getting the word's definition => O(log n),
	 *			  for each looped word, getting the word's page index => O(log n),
	 *			  for each looped word, getting the word's number of appearances => O(log n),
	 * 			  O(n) + O(n) + O(n) + (O(n) * (O(log n) + O(log n)  + O(log n) + O(log n)  + O(log n)) = O(n log n)</p>
	 * 
	 * @param inputFile The specified book text file.
	 * @param outputFile The output file text file.
	 * @param dictionary The dictionary file.
	 * @param commonWords The specified text file of words to be excluded from the index.
	 * @throws Exception. 
	 */

	public void outputFile(String inputFile, String outputFile, String dictionary, String commonWords) throws Exception {
		bParser = new BookParser(); // clears any previously parsed books
		bParser.parse(inputFile);
		dParser.parse(dictionary);
		gParser.parse(commonWords);
		PrintWriter pw = new PrintWriter(new File(outputFile));

		for (String word : bParser.getBookContents().keySet()) {
			if (!gParser.getWords().contains(word)) {
				if (dParser.getDictionary().containsKey(word)) {
					pw.write("Word: " + word + "\n" 
							+ "Definition: " + dParser.getDictionary().get(word).getDefinition() + "\n"
							+ "Pages: " + bParser.getBookContents().get(word).getPageIndex() + "\n"
							+ "Total number of occurences: " + bParser.getBookContents().get(word).getCount() + "\n\n");
				}
			}
		}
		pw.close();
	}

}
