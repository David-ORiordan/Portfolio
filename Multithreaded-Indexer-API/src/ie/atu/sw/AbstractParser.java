package ie.atu.sw;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

/**
 * Abstract class that implements the <code>Parsable</code> interface and is to be used by any
 * class that parses text.
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public abstract class AbstractParser implements Parsable {
	
	/**
	 * <p>Reads all lines from the text file as a stream.
	 * For each line of text, passes it to the <code>process()</code> method via its own
	 * virtual thread.</p>
	 * 
     * <p>Big O Running Time: O(n).
	 * Rationale: the <code>process()</code> method is called for each line of text => O(n).</p>
	 * 
	 * <p>Code derived from Advanced Object Oriented Programming, Week 12, LevenshteinVirtualThreads.java.</p>
	 * 
	 * @param file The specified text file.
	 * @throws Exception.
	 */
	public void parse(String file) throws Exception {
		Files.lines(Path.of(file)).forEach(text -> Thread.startVirtualThread(() -> process(text)));
		Thread.sleep(Duration.ofMillis(100)); // sleep() is used to ensure that all the virtual threads have finished their execution
	}

	/**
	 * A method which, when used, will process a line of text.
	 * 
	 * @param text The line of text.
	 */
	public abstract void process(String text); 
	
}
