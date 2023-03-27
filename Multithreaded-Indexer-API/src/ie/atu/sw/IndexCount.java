package ie.atu.sw;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track of the pages that a word from the book text file appears on and
 * the amount of times it appears in total. 
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class IndexCount {
	
	private List<Integer> pageIndex;
	private int count = 0;
	
	/**
	 * Adds the page number a word first appears on.
	 * 
	 * @param indexNumber The page number a word appears on.
	 */
	public IndexCount(int indexNumber){
		addIndex(indexNumber);
	}
	
	/**
	 * <p>Checks if there is an existing <code>pageIndex</code> List associated
	 * with the word.
	 * If not, creates a new List.
	 * Increments <code>count</code> by +1.
	 * If the page number isn't already been added to the List, adds it to the 
	 * List. This prevents the same page number appearing multiple times if the
	 * word is on the same page more than once.</p>
	 * 
	 * <p>Big O Running Time: O(n).
	 * Rationale: checking if <code>pageIndex</code> is equal to null => O(1), 
	 * 			  creating a new List (if necessary) => O(1), 
	 * 			  incrementing count => O(1), 
	 * 			  checking if doesn't <code>pageIndex</code> already contains
	 * 			  the page number => O(n), 
	 * 			  adding <code>pageIndex</code> to the List => O(1).
	 * 			  O(1) + O(1) + O(1) + O(n) + O(1) = O(n)</p>
	 * 
	 * <p>Code derived from Advanced Object Oriented Programming, Assignment Workshop.</p>
	 */
	public void addIndex(int page) {
		if (pageIndex == null) pageIndex = new ArrayList<Integer>();
		count++;
		if (!pageIndex.contains(page)) pageIndex.add(page);
	}
	
	/**
	 * <p>Returns a List of Integers representing the page numbers that a given
	 * word appeared on in the book text file.</p>
	 *  
	 * <p>Big O Running Time: O(1).
	 * Rationale: returning <code>pageIndex</code> List => O(1)</p>
	 * 
	 * @return A List of Integers indicating the pages that a word appears on in the book.
	 */
	public List<Integer> getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * <p>Returns a <code>count</code> Integer, which is the amount of times a 
	 * given word appeared in the book text file.</p>
	 *  
	 * <p>Big O Running Time: O(1).
	 * Rationale: returning an Integer => O(1)</p>
	 * 
	 * @return An Integer value indicating the amount of times a word appears in the book.
	 */
	public int getCount() {
		return count;
	}

}
