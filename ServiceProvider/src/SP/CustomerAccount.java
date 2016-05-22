package SP;

import java.util.Date;
/**
 * Customer account class
 * @author Jiaqi Zhang
 * 
 */
public class CustomerAccount {

	/**
	 * Customer Service.
	 */
	private Service service;

	/**
	 * Open date.
	 */
	private Date dateOpened = new Date();

	/**
	 * Billable object.
	 */
	private Billable billable;
	
	/**
	 * Constructor.
	 * @param b billable
	 */
	public CustomerAccount(Billable b) {
		this.billable = b;
	}

	/**
	 * Constructor.
	 * @param b billable
	 * @param s service
	 */
	public CustomerAccount(Billable b, Service s) {
		this.billable = b;
		this.service = s;
	}

	/**
	 * @return Returns the service.
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service the service to set.
	 */
	public synchronized void setService(Service service) {
		this.service = service;
	}

	/**
	 * @return Returns the billable.
	 */
	public Billable getBillable() {
		return billable;
	}

	/**
	 * @return Returns the dateOpened.
	 */
	public Date getDateOpened() {
		return dateOpened;
	}

	/**
	 * @return Returns the totalCharge.
	 */
	public double getTotalCharge() {
		return service.getCharge();
	}

	/**
	 * Submit the payment via the billable object
	 */
	public synchronized void submitPayment() {
		billable.submitPayment(getTotalCharge());
	}

	@Override
	public String toString() {
		return "Account information: Paying with: " + billable + 
			"Service: " + service + "Total charge: " + getTotalCharge() + "\n";
	}
}

