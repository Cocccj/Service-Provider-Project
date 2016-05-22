package SP;

/**
 * Address class.
 * @author Jiaqi Zhang
 * 
 */
public class Address {
	
	/**
	 * Street.
	 */
	private String street;
	
	/**
	 * City.
	 */
	private String city;
	
	/**
	 * State.
	 */
	private String state;
	
	/**
	 * Zip code.
	 */
	private String zip;
	
	/**
	 * Constructor.
	 * @param street street
	 * @param city city
	 * @param state state
	 * @param zip zip code
	 */
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return street +", " + city +", " + state + " " +zip;
	}
	
	/**
	 * Get street.
	 * @return street information
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Set street.
	 * @param s street
	 */
	public void setStreet(String s) {
		street = s;
	}
	
	/**
	 * Get city.
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Set city.
	 * @param c city
	 */
	public void setCity(String c) {
		city = c;
	}
	
	/**
	 * Ger state.
	 * @return state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Set state.
	 * @param st state
	 */
	public void setState(String st) {
		state = st;
	}
	
	/**
	 * Get zip code.
	 * @return zip code
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * Set zip code.
	 * @param z zip code
	 */
	public void setZip(String z) {
		zip = z;
	}
}
