package SP;

import java.util.StringTokenizer;

/**
 * Abstraction of a Dial up service that is offered by a service provider.
 * @author Jiaqi Zhang
 *
 **/
public class DialUpService extends Service {
	
	/**
	 * Monthly charge.
	 */
	private double monthlyCharge;
	
	/**
	 * Constructoer.
	 * @param n name
	 * @param desc description
	 * @param mc monthly charge
	 */
	DialUpService(String n, String desc, double mc) {
		super(n, desc);
		this.monthlyCharge = mc;
	}
	
	/**
	 * Create service.
	 * @param t tokenizer
	 * @return dialup service
	 */
	public static Service create(StringTokenizer t) {
		return new DialUpService(t.nextToken(), // name
				t.nextToken(), // desc
				Double.parseDouble(t.nextToken())); // monthlyCharge
	}
	
	@Override
	public double getCharge() {
		return monthlyCharge;
	}
	
	@Override
	public String toTextFile(String delimeter) {
		return super.toTextFile(delimeter) + delimeter +
		monthlyCharge;
	}
	
	@Override
	public String toHtml() {
		return super.toHtml() +
		"<br><b>Monthly Charge:</b> " + monthlyCharge;
	}
}

