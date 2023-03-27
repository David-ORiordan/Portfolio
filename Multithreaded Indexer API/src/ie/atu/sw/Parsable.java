package ie.atu.sw;

/**
 * Interface to be used by any class that parses text.
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public interface Parsable {

	/**
	 * A method which, when implemented, will parse a text file.
	 * 
	 * @param file The specified text file.
	 * @throws Exception. 
	 */
	public void parse(String file) throws Exception;

	/**
	 * A method which, when implemented, will process a line of text.
	 * 
	 * @param text The line of text.
	 */
	public void process(String text);

}
