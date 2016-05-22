package SP;

import java.util.StringTokenizer;

/**
 * Abstraction of a Web Hosting Service that is offered by a service provider.
 * @author Jiaqi Zhang
 * 
 */
public class WebHostingService extends Service {
	
	/**
	 * Monthly charge.
	 */
	private double monthlyCharge;

	/**
	 * Charge for overuse.
	 */
	private double chargeForOverUse;

	/**
	 * Max monthly data transfer.
	 */
	private double maxMonthlyDataTransfer;

	/**
	 * Total transfer.
	 */
	private double totalTransfer;

	/**
	 * Max storage.
	 */
	private double maxStorage;
	
	/**
	 * Constructor.
	 * @param n name
	 * @param desc description
	 * @param monthlyCharge monthly charge
	 * @param chargeForOverUse charge for overuse
	 * @param maxMonthlyDataTransfer max monthly data transfer
	 * @param totalTransfer total transfer
	 * @param maxStorage max storage
	 */
	WebHostingService(String n, String desc, double monthlyCharge,
			double chargeForOverUse, double maxMonthlyDataTransfer,
			double totalTransfer, double maxStorage) {
		super(n, desc);
		this.monthlyCharge = monthlyCharge;
		this.chargeForOverUse = chargeForOverUse;
		this.maxMonthlyDataTransfer = maxMonthlyDataTransfer;
		this.totalTransfer = totalTransfer;
		this.maxStorage = maxStorage;
	}
	
	/**
	 * Create service
	 * @param t tokenizer
	 * @return web hosting service
	 */
	public static Service create(StringTokenizer t) {
		return new WebHostingService(t.nextToken(), // name
				t.nextToken(), // desc
				Double.parseDouble(t.nextToken()), // monthlyCharge,
				Double.parseDouble(t.nextToken()), // chargeForOverUse
				Double.parseDouble(t.nextToken()), // maxMonthlyDataTransfer
				Double.parseDouble(t.nextToken()), // totalTransfer
				Double.parseDouble(t.nextToken())); // double maxStorage
	}
	
	@Override
	public String toTextFile(String delimeter) {
		return super.toTextFile(delimeter) + delimeter +
			monthlyCharge + delimeter +
			chargeForOverUse + delimeter +
			maxMonthlyDataTransfer + delimeter +
			totalTransfer + delimeter +
			maxStorage;
	}
	
	@Override
	public String toHtml() {
		return super.toHtml() + 
			"<br><b>Monthly Charge:</b> " + monthlyCharge +
			"<br><b>Charge For Over Use:</b> " + chargeForOverUse +
			"<br><b>Max Monthly Data Transfer:</b> " + maxMonthlyDataTransfer +
			"<br><b>Total Transfer:</b> " + totalTransfer + 
			"<br><b>Max Storage:</b> " + maxStorage;
	}
	@Override
	public double getCharge() {
		double charge = monthlyCharge;
		if (totalTransfer > maxMonthlyDataTransfer) {
			charge += chargeForOverUse
					* (totalTransfer - maxMonthlyDataTransfer);
		}
		return charge;
	}
}