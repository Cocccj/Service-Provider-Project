package SP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Service Provider Class.
 * @author Jiaqi Zhang
 * 
 */
public class ServiceProvider {

	/**
	 * Customer map.
	 */
	private Map<String, Customer> customers = new LinkedHashMap<String, Customer>();

	/**
	 * Provider Name.
	 */
	private String name;
	
	
	/**
	 * Constructor.
	 * @param name service name
	 */
	public ServiceProvider(String name) {
		this.name = name;
	}
	
	/**
	 * Get name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Print customer report.
	 */
	public void printCustomerReport() {
		Iterator<Map.Entry<String, Customer>> iter = customers.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Customer> entry = iter.next();
			System.out.println(entry.getValue());
		}
	}
	
	/**
	 * Get customers.
	 * @return customer map
	 */
	public Map<String, Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * Update the customer information.
	 * @param Id id
	 * @param name name 
	 * @param address address
	 */
	public void updateCustomer(String Id, String name, Address address) {
		Customer c = customers.get(name);
		c.setAddress(address);
	}
	
	/**
	 * Load customer information.
	 * @param file information file
	 * @throws IOException I/O exception
	 */
	public void loadCustomers(File file) throws IOException {
		BufferedReader instream = null; 
		try {
			instream = new BufferedReader(new FileReader(
					file));
			String line;

			// read the input stream line by line.
			while ((line = instream.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, "|");

				String id = tokenizer.nextToken();
				String name = tokenizer.nextToken();
				String street = tokenizer.nextToken();
				String city = tokenizer.nextToken();
				String state = tokenizer.nextToken();
				String zip = tokenizer.nextToken();
				Customer customer = new Customer(id,
											     name, 
											     new Address(street,
											    		     city, state, zip));
				while (tokenizer.hasMoreTokens()) {
	
					String billablestr = tokenizer.nextToken();
					if (!billablestr.contains(".")) {
						billablestr = getClass().getPackage().getName() + "." + billablestr;
					}
					Billable billable = (Billable) Class.forName(billablestr).newInstance();
					billable.configure(tokenizer, customer);
					
					String servicestr = tokenizer.nextToken();
					if (!servicestr.contains(".")) {
						servicestr = getClass().getPackage().getName() + "." + servicestr;
					}
					Class cl = Class.forName(servicestr);
					Class cparams[] = {StringTokenizer.class};
					Method cmethod = cl.getMethod("create", cparams);
					Object oparams[] = {tokenizer};
					Service service = (Service)cmethod.invoke(null, oparams);
					customer.addAccount(new CustomerAccount(billable, service));
				}
				customers.put(customer.getName(), customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (instream != null) {
				instream.close();
			}
		}
	}
	
	/**
	 * Save customer information to the file.
	 * @param file customer file
	 * @throws IOException I/O exception
	 */
	public synchronized void saveCustomers(File file) throws IOException {
		BufferedWriter outstream = null;
		try {
			outstream = new BufferedWriter(new FileWriter(file));
			Iterator<Map.Entry<String, Customer>> iter = customers.entrySet().iterator();
			String data = "";
			while (iter.hasNext()) {
				Map.Entry<String, Customer> entry = iter.next();
				Customer c = entry.getValue();
				data += c.getId() + "|" + c.getName() + "|" + c.getAddress().getStreet() + "|"
						+ c.getAddress().getCity() + "|" + c.getAddress().getState() + "|" + c.getAddress().getZip();
				for (CustomerAccount ca : c.getAccounts()) {
					data += "|" + ca.getBillable().toTextFile("|") + "|" + ca.getService().toTextFile("|");
				}
				data += "\n";
			}
			outstream.write(data); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			outstream.close();
		}
	}
}

