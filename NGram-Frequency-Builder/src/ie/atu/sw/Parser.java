package ie.atu.sw;

import java.io.BufferedReader;   
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Parser {

	private Object[][] table;
	private int size;

	/*
	 *  Creates a table object, with the size being dictated by the user's specified n-Gram size.
	 * 
	 *  Code derived from the Object Oriented Programming Assignment Workshop.
	 */
	public Parser(int size) {
		this.setSize(size); // sets the n-Gram size for later use within the parse() method.

		int n = (int) Math.pow(26, size);
		table = new Object[n][2];
	}

	// gets the n-Gram size for later use within the parse() method.
	public int getSize() {
		return size;
	}

	// sets the n-Gram size for later use within the parse() method.
	public void setSize(int size) {
		this.size = size;
	}

	/*
	 *  Takes in the text file directory specified by the user.
	 *  Accesses each text file within the directory and calls them individually to the parse() method.
	 *  Returns a completed table with the n-Grams and their frequencies stored in it.
	 *  The format boolean is used by the parse() method to specify the type of n-Gram format to use (chunky or offset).
	 *  
	 *  Code derived from the Object Oriented Programming Assignment Workshop.
	 */
	public Object[][] parseDir(String dir, boolean format) throws Exception {
		File f = new File(dir);
		String[] files = f.list(); 
		String separator = File.separator; // separator has the value \.
		for (String file : files) { 
			parse(f.getAbsolutePath() + separator + file, format); 
		}
		return table;
	}

	/*
	 *  Takes in the individual text files parsed from the user's text file directory.
	 *  Using a buffered reader, each text file is accessed line-by-line.
	 *  Each line is converted into words.
	 *  Each word is trimmed of whitespace, converted to lowercase, and stripped of unwanted characters.
	 *  Each word is processed for n-Grams.
	 *  The format boolean is used to specify the type of n-Gram format to use (chunky or offset).
	 *  
	 *  Code derived from the Object Oriented Programming Assignment Workshop.
	 */
	public void parse(String file, boolean format) throws Exception {
		// buffered reader allows us to read a line at a time rather than a byte at a time
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("\\s+"); // gets each word in the line.
				for (String word : words) { 
					word = word.trim().toLowerCase().replaceAll("[^a-z]", ""); // trims whitespace, converts to lowercase, and strips unwanted characters.
																		
					int nGramSize = getSize();
					if (format) { // chunky
					getNGramsChunky(word, nGramSize);
					} else { // offset
						getNGramsOffset(word, nGramSize);
					}
				}
			}
			br.close();
		}

	}
	
	/*
	 *  Generates n-Grams in chunky format.
	 *  
	 *  Code derived from the Object Oriented Programming Week 10 video - Solution to Exercise 2 - Processing n-Grams.
	 */
	public void getNGramsChunky(String word, int n) {
		int nGramLength = (int) (word.length() / n);
		String[] temp = new String[nGramLength];
		int j = 0;
		for (int i = 0; i < nGramLength; i++) {
			temp[i] = word.substring(j, j + n);
			j += n;
			addNGram(temp[i]);
		}
	}
	
	/*
	 *  Generates n-Grams in offset format.
	 *  
	 *  Code derived from the Object Oriented Programming Week 10 video - Solution to Exercise 2 - Processing n-Grams.
	 */
	public void getNGramsOffset(String s, int n) {
		String[] temp = new String[s.length()];
		for (int i = 0; i < s.length() - n + 1; i++) {
			temp[i] = s.substring(i, i + n);
			if (temp[i] != null) {
			addNGram(temp[i]);
			}
		}
	}

	
	/*
	 *  Adds the generated n-Grams to the table object.
	 *  The hash code of each n-Gram is used to give each n-Gram it's own unique place within the table.
	 *  
	 *  Code derived from the Object Oriented Programming Assignment Workshop.
	 */
	public void addNGram(String ngram) {
		int index = ngram.hashCode() % table.length;
		
		long counter = 1;
		if (table[index][1] != null) { // If it's not null, it means it's an existing n-Gram there and the counter for that n-Gram is updated.
									   // If not, this is a new n-Gram and it is added to the table with a count of 1. 
			counter += (Long) table[index][1];
		}
		table[index][0] = ngram;
		table[index][1] = counter;
	}

}
