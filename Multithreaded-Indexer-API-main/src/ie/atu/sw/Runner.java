package ie.atu.sw;

/**
 * Starts the application. 
 * 
 * @author David O'Riordan
 * @version 1.0
 */
public class Runner {

	/**
	 * <p>Starts the application.</p>
	 * 
	 * <p>Big O Running Time: O(1).
	 * Rationale: creating a new instance of the Menu class and calls the <code>showMenu()</code> method => O(1).</p>
	 * 
	 * @throws Exception. 
	 */
	public static void main(String[] args) throws Exception {
		Menu m = new Menu();
		m.showMenu();
	}

}
