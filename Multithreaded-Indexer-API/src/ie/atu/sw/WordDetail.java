package ie.atu.sw;

/**
 * Stores the definition of a given word.
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class WordDetail {

	private String definition;

	/**
	 * Stores the definition of a given word.
	 * 
	 * @param definition The definition of a given word.
	 */
	public WordDetail(String definition) {
		this.definition = definition;
	}

	/**
	 * <p>Returns the definition String associated with a given word.</p>
	 *  
	 * <p>Big O Running Time: O(1).
	 * Rationale: returning definition String => O(1)</p>
	 * 
	 * @return A String object containing the definition of a given word.
	 */
	public String getDefinition() {
		return definition;
	}

}
