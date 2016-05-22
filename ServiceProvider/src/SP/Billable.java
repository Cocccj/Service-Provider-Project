package SP;

import java.util.StringTokenizer;

/**
 * Interface Billable.
 * @author Jiaqi
 * 
 */
public interface Billable {

	/**
	 * Verify the billable.
	 * @return
	 */
	boolean verify();

	/**
	 * Submit payment.
	 * @param amount amount
	 */
	void submitPayment(double amount);

	/**
	 * Configure customer information.
	 * @param t tokenizer
	 * @param customer customer information
	 */
	void configure(StringTokenizer t, Customer customer);

	/**
	 * Send the information to console.
	 * @return string
	 */
	String toConsole();
	
	/**
	 * Store the information to console.
	 * @param delimeter delimeter
	 * @return string
	 */
	String toTextFile(String delimeter);
	
	/**
	 * Write the information in html format.
	 * @return string
	 */
	String toHtml();
}

