package ie.atu.sw;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * <p>Allows user to parse a text file containing words they wish to exclude from
 * the index.</p>
 * 
 * <p>The <code>Google1000Parser</code> class extends the <code>AbstractParser</code> abstract class.</p>
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class Google1000Parser extends AbstractParser {

	private Set<String> words = new ConcurrentSkipListSet<>();

	/**
	 * <p>Returns a Set of words from the common words file.</p>
	 *  
	 * <p>Big O Running Time: O(1). 
	 * Rationale: returning set => O(1)</p>
	 * 
	 * @return A Set of words to be excluded from the index.
	 */
	public Set<String> getWords() {
		return words;
	}

	/**
	 * <p>Splits each line of from the common words file into its individual words.
	 * Adds each word (in lowercase) to the Set containing all the words to be excluded.</p>
	 * 
	 * <p>Big O Running Time: O(n).
	 * Rationale: adding a word into the Set => O(log n).
	 * 		      carrying out the above for each word in the line of text => 
	 *  		  O(n), where n is the amount of words in the line.
	 * 			  O(log n) + O() = O(n)</p>
	 * 
	 * <p>Code derived from Advanced Object Oriented Programming, Week 12, VirtualThreadFileParser.java</p>
	 * 
	 * @param text A line of text from the common words file.
	 */
	public void process(String text) {
		Arrays.stream(text.split("\\s+")).forEach(w -> words.add(w.toLowerCase()));
	}

}
