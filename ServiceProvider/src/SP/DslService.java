package SP;

import java.util.StringTokenizer;

/**
 * Abstraction of a Dsl service that is offered by a service provider.
 * @author Jiaqi Zhang
 *
 */
public class DslService extends Service {
	
	/**
	 * Rate.
	 */
	private double rate;

	/**
	 * Monthly charge.
	 */
	private double monthlyCharge;
	
	/**
	 * Constructor.
	 * @param n name
	 * @param desc description
	 * @param rate rate
	 * @param mc monthly charge
	 */
	DslService(String n, String desc, double rate, double mc) {
		super(n, desc);
		this.rate = rate;
		this.monthlyCharge = mc;
	}
	
	/**
	 * Create service.
	 * @param t tokenizer
	 * @return dsl service
	 */
	public static Service create(StringTokenizer t) {
		return new DslService(t.nextToken(), // name
				t.nextToken(), // desc
				Double.parseDouble(t.nextToken()), // rate
				Double.parseDouble(t.nextToken())); // monthlyCharge
	}
	
	@Override
	public double getCharge() {
		return monthlyCharge;
	}
	
	@Override
	public String toTextFile(String delimeter) {
		return super.toTextFile(delimeter) + delimeter +
		rate + delimeter +
		monthlyCharge;
	}
	
	@Override
	public String toHtml() {
		return super.toHtml() +
		"<br><b>Rate:</b> " + rate +
		"<br><b>Monthly Charge:</b> " + monthlyCharge;
	}
}