package SP;

import java.util.StringTokenizer;

/**
 * Billable class that facilitates paying via billing to address.
 * @author Jiaqi Zhang
 * 
 */
public class BillToAddress implements Billable {

	/**
	 * Address information.
	 */
	private Address address;
	
	/**
	 * Constructor.
	 */
	BillToAddress() {}
	
	/**
	 * Constructor.
	 * @param address address
	 */
	BillToAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean verify() {
		return true;
	}

	@Override
	public void submitPayment(double amount) {
	}

	@Override
	public void configure(StringTokenizer t, Customer customer) {
		setAddress(customer.getAddress());
	}
	
	@Override
	public String toConsole() {
		return "Bill to address " + address;
	}
	
	@Override
	public String toString() {
		return "Bill To Address";
	}
	
	@Override
	public String toTextFile(String delimeter) {
		return getClass().getName();
	}
	
	@Override
	public String toHtml() {
		return "<b>Bill to address:</b> " + address;
	}
	
	/**
	 * @return Returns the address.
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * @param address The address to set.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}