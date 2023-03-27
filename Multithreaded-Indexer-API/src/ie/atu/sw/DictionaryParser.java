package ie.atu.sw;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * <p>Allows user to parse a dictionary file, recording each word in the 
 * dictionary along with the word's definition.</p>
 * 
 * <p>The <code>DictionaryParser</code> class extends the <code>AbstractParser</code> abstract class.</p>
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class DictionaryParser extends AbstractParser {

	private Map<String, WordDetail> dictionary = new ConcurrentSkipListMap<>();

	/**
	 * <p>Returns a Map of the dictionary file's contents.</p>
	 *  
	 * <p>Big O Running Time: O(1). 
	 * Rationale: returning dictionary Map => O(1)</p>
	 * 
	 * @return A Map of words and their definitions.
	 */
	public Map<String, WordDetail> getDictionary() {
		return dictionary;
	}

	/**
	 * <p>Splits the stream of text from the dictionary (a cvs file) into its 
	 * individual lines.
	 * Splits each line by their comma values, creating pairs of word and word 
	 * definitions (each line consists of one dictionary word and definition entry).
	 * Assigns the word to the key.
	 * Assigns the word definition to the value.
	 * Adds the word (in lowercase) and word definition key/value pairs on to the dictionary Map.</p>
	 * 
	 * <p>Big O Running Time: O(log n). 
	 * Rationale: putting a key/value pair into the Map => O(log n).
	 * 			  carrying out the above for each word in the line of text => 
	 * 			  O(1), as each line contains one word/word definition pair.
	 * 			  O(log n) + O(1) = O(log n)</p> 
	 *
	 * <p>Code derived from Advanced Object Oriented Programming, Week 12, VirtualThreadFileParser.java.</p>
	 * 
	 * @param text A line of text from the dictionary csv file.
	 */
	public void process(String text) {
		Arrays.stream(text.split("\n"))
		.forEach(w -> {
			String[] keyValuePair = w.split(",");
			String key = keyValuePair[0];
			String value = keyValuePair[1];
			dictionary.put(key.toLowerCase(), new WordDetail(value));
		});
	}

}

