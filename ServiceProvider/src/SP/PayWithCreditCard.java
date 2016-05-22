package SP;

import java.util.StringTokenizer;

/**
 * Billable class that facilitates paying via a credit card.
 * @author Jiaqi Zhang
 * 
 */
public class PayWithCreditCard implements Billable {
	
	/**
	 * Credit card.
	 */
	private CreditCard creditCard;
	
	/**
	 * Constructor.
	 */
	PayWithCreditCard() {}
	
	/**
	 * Constructor.
	 * @param cc credit card
	 */
	PayWithCreditCard(CreditCard cc) {
		creditCard = cc;
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
		String id = t.nextToken();
		int expMonth = Integer.parseInt(t.nextToken());
		int expYear = Integer.parseInt(t.nextToken());
		setCreditCard(new CreditCard(id, expMonth, expYear,
				customer.getAddress()));	
	}
	@Override
	public String toString() {
		return "Credit Card";
	}
	@Override
	public String toConsole() {
		return "Credit card: " + creditCard;
	}
	@Override
	public String toTextFile(String delimeter) {
		return getClass().getName() + delimeter + creditCard.getId() + delimeter +
			creditCard.getExpMonth() + delimeter + creditCard.getExpYear();
	}
	@Override
	public String toHtml() {
		return "<b>Credit card:</b><br>" + creditCard.toHtml();
	}
	/**
	 * @return Returns the creditCard.
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}
	/**
	 * @param creditCard The creditCard to set.
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}

/**
* Credit card class.
* @author Jiaqi Zhang
*
*/
class CreditCard {

	/**
	 * Card id.
	 */
	private String id;

	/**
	 * Expiration month.
	 */
	private int expMonth;

	/**
	 * Expiration year.
	 */
	private int expYear;

	/**
	 * Address.
	 */
	private Address address;
	
	/**
	 * Constructor.
	 * @param id card id
	 * @param month expire month
	 * @param year expire year
	 * @param address address
	 */
	public CreditCard(String id, int month, int year, Address address) {
		this.id = id;
		expMonth = month;
		expYear = year;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Id: " + id + " Exp: " + expMonth + "/" + expYear + "\nAddress: "
				+ address;
	}
	
	/**
	 * Write the information in html format.
	 * @return string
	 */
	public String toHtml() {
		return "<b>Id:</b> " + id + "<br><b>Exp:</b> " + expMonth + "/" + expYear + 
			"<br><b>Address:</b> " + address;
	}

	/**
	 * @return Returns the address.
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return Returns the expMonth.
	 */
	public int getExpMonth() {
		return expMonth;
	}

	/**
	 * @return Returns the expYear.
	 */
	public int getExpYear() {
		return expYear;
	}

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	
}

