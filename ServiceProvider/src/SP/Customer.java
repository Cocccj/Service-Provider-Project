package SP;

import java.util.ArrayList;
import java.util.Date;

/**
 * Customer class.
 * @author Jiaqi Zhang
 * 
 */
public class Customer {

	/**
	 * Customer account list.
	 */
	private ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount>();
	
	/**
	 * Open date.
	 */
	private Date dateOpened = new Date();
	
	/**
	 * Customer address.
	 */
	private Address address;
	
	/**
	 * Customer id.
	 */
	private String id;
	
	/**
	 * Customer name.
	 */
	private String name;
	
	/**
	 * Constructor.
	 * @param id customer id
	 * @param name customer name
	 * @param address customer address
	 */
	public Customer(String id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Add customer account.
	 * @param account account
	 */
	public void addAccount(CustomerAccount account) {
		accounts.add(account);
	}

	/**
	 * Get date.
	 * @return date
	 */
	public Date getDate() {
		return (Date) dateOpened.clone();
	}
	
	/**
	 * Get address.
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Set address.
	 * @param a address
	 */
	public synchronized void setAddress(Address a) {
		address = a;
	}
	
	/**
	 * Get id.
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Get name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get account list.
	 * @return list of accounts
	 */
	public ArrayList<CustomerAccount> getAccounts() {
		return accounts;
	}

	@Override
	public String toString() {
		String str = "***************** Customer Information *****************\nId: " + id + " Name: " + name 
				+ "\nAddress: " + address + "\n";
		for (CustomerAccount account : accounts) {
			str += account;
		}
		str += "\n";
		return str;
	}
}
