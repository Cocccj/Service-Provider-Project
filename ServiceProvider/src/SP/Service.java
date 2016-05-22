package SP;

import java.util.StringTokenizer;

/**
 * Abstract class for services.
 * @author Jiaqi Zhang
 * 
 */
abstract public class Service {
	
	/**
	 * Service name.
	 */
	private String name;

	/**
	 * Service description.
	 */
	private String description;
	
	/**
	 * Constructor.
	 * @param n name
	 * @param d description
	 */
	Service(String n, String d) {
		name = n;
		description = d;
	}
	
	/**
	 * Create service.
	 * @param t tokenizer
	 * @return service
	 */
	public static Service create(StringTokenizer t) {
		return null;
	}
	
	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Start service.
	 */
	public void start() {
		System.out.println(name + " started");
	}

	/**
	 * Stop service.
	 */
	public void stop() {
		System.out.println(name + " stopped");
	}

	/**
	 * Suspend service.
	 */
	public void suspend() {
		System.out.println(name + " suspended");
	}

	/**
	 * Resume service.
	 */
	public void resume() {
		System.out.println(name + " resumed");
	}

	/**
	 * Get charge.
	 * @return charge
	 */
	public abstract double getCharge();

	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Send the information to console.
	 * @return string
	 */
	public String toConsole() {
		return "Name: " + name + " Description: " + description + "\n";
	}
	
	/**
	 * Store the information to console.
	 * @param delimeter delimeter
	 * @return string
	 */
	public String toTextFile(String delimeter) {
		return getClass().getName() + delimeter + name + delimeter + description;
	}
	
	/**
	 * Write the information in html format.
	 * @return string
	 */
	public String toHtml() {
		return "<b>Name:</b> " + name + "<br><b>Description:</b> " + description +
		"<br><b>Total Charge:</b> " + getCharge();
	}
}
