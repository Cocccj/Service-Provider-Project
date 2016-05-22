package SP;

import java.util.StringTokenizer;

/**
 * Billable class that facilitates paying via a checking account.
 * @author Jiaqi Zhang
 * 
 */
public class PayWithCheckingAccount implements Billable {
	
	/**
	 * Bank name.
	 */
	private String bankName;

	/**
	 * Routing number.
	 */
	private String routingNumber;
	
	/**
	 * Constructor.
	 */
	PayWithCheckingAccount() {}
	
	/**
	 * Constructor.
	 * @param name name
	 * @param number number
	 */
	public PayWithCheckingAccount(String name, String number) {
		bankName = name;
		routingNumber = number;
	}

	@Override
	public boolean verify() {
		return true;
	}
	@Override
	public void submitPayment(double amount) {
	}
	@Override
	public void configure(StringTokenizer t, Customer c) {
		setBankName(t.nextToken());
		setRoutingNumber(t.nextToken());
	}
	@Override
	public String toString() {
		return "Checking Account";
	}
	@Override
	public String toConsole() {
		return "Submit to checking account with bank name: " + bankName
				+ " Routing number: " + routingNumber + "\n";
	}
	@Override
	public String toHtml() {
		return "<b>Checking Account Bank:</b> " + bankName
				+ "<br><b>Routing Number:</b> " + routingNumber;
	}
	@Override
	public String toTextFile(String delimeter) {
		return getClass().getName() + delimeter + bankName + delimeter + routingNumber;
	}
	/**
	 * @return Returns the bankName.
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName The bankName to set.
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return Returns the routingNumber.
	 */
	public String getRoutingNumber() {
		return routingNumber;
	}
	/**
	 * @param routingNumber The routingNumber to set.
	 */
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

}
