package ie.atu.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NGramOutputter {
	
	// Counts and returns the total sum of the n-Gram frequencies in the table object.
	public long totalFrequencyCounter(Object[][] table) {
		long totalFrequencyCounter = 0;
		for (int row = 0; row < table.length; row++) {
			if (table[row][0] != null) { 
			totalFrequencyCounter += (long) table[row][1];
			}
		}
		return totalFrequencyCounter;
	}
	
	/*
	 *  Prints the table object to the output file specified by the user.
	 *  On each line, the output file displays an n-Gram, the frequency of the n-Gram in the text files, and the frequency percentage.
	 * 
	 *  Code derived from the Object Oriented Programming Assignment Workshop.
	 */
 	public void save(Object[][] table, String file, int size) throws FileNotFoundException {
		long totalFrequencyCounter = totalFrequencyCounter(table);
		
		PrintWriter pw = new PrintWriter(new File(file));
	
		pw.write(size + "-Gram, Frequency, Frequency Percentage (%)" + "\n");
		for (int row = 0; row < table.length; row++) {
			if (table[row][0] != null) {
				long nGramCounter = (long) table[row][1];
				double percentage = ((double) nGramCounter / totalFrequencyCounter) * 100;
				pw.write(table[row][0] + ", " + table[row][1] + ", " +  percentage + "\n");
			}
		}
		pw.close();
	}

}