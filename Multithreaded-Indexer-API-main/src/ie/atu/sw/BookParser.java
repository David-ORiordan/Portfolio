package ie.atu.sw;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * <p>Allows user to parse a book text file, recording each unique word in the 
 * book along with the page number(s) it appears on.</p>
 * 
 * <p>The <code>BookParser</code> class extends the <code>AbstractParser</code> abstract class.</p>
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class BookParser extends AbstractParser {

	private Map<String, IndexCount> bookContents = new ConcurrentSkipListMap<>();

	private int lineCounter = 0;
	private int pageCounter = 1;

	/**
	 * <p>Returns a Map of the book text file contents.</p>
	 *  
	 * <p>Big O Running Time: O(1).
	 * Rationale: returning bookContents Map => O(1).</p>
	 * 
	 * @return A Map of words and the pages the words appear on.
	 */
	public Map<String, IndexCount> getBookContents() {
		return bookContents;
	}
	
	/**
	 * <p>Parses the book text file into a Map.
	 * For each line in the text file, calls the <code>process()</code> method
	 * and increments the <code>lineCounter</code> by +1.</p>
	 *  
	 * <p>Big O Running Time: O(n). 
	 * Rationale: calling process() on each line on text in the text file => O(n), 
	 * 			  incrementing lineCounter for each line on text in the text file => O(n). 
	 *            O(n) + O(n) = O(n).</p>
	 *            
	 * <p>Code derived from Advanced Object Oriented Programming, Week 12, LevenshteinVirtualThreads.java.</p>
	 * 
	 * @param file The specified book text file.
	 * @throws Exception. 
	 */
	@Override
	public void parse(String file) throws Exception {
		Files.lines(Path.of(file)).forEach(text -> {
			lineCounter++;
			process(text);
		});  
	}

	/**
	 * <p>Increments the <code>pageCounter</code> by +1 for every 40th line of text.
	 * Splits each line of text into its individual words.
	 * Converts each word to lowercase and removes any non-alphabetical characters.
	 * Checks if word is already contained in the Map.
	 * If word is already in the Map, updates the Map to include the page number the word appears on.
	 * If word is not in the Map, adds the new word and the page number it appears on to the Map.</p>
	 * 
	 * <p>Big O Running Time: O(n). 
	 * Rationale: incrementing pageCounter for every 40th line on text => O(1), 
	 * 			  converting each word to lowercase and remove any non-alphabetical characters => O(1), 
	 * 			  checking if the Map contains a word => O(log n),
	 * 			  getting a key from the Map => O(log n),
	 * 			  putting a new key/value pair into the Map => O(log n),
	 * 			  carrying out the above for each word in the line of text => O(n), where n is the amount of words in the line.
	 * 			  O(1) + O(1) + O(log n) + O(log n) + O(log n) + O(n) = O(n).</p>
	 * 
	 * <p>Code derived from Advanced Object Oriented Programming, Week 12, VirtualThreadFileParser.java.</p>
	 * 
	 * @param text A line of text from the book text file.
	 */
	public void process(String text) {  
		if (lineCounter % 40 == 0) pageCounter++;

		Arrays.stream(text.split("\\s+")).forEach(w -> {
			w = w.toLowerCase().replaceAll("[^a-z]", "");
			if (bookContents.containsKey(w)){
				bookContents.get(w).addIndex(pageCounter);
			} else {
				bookContents.put(w, new IndexCount(pageCounter));
			} 
		});		
	}

}
