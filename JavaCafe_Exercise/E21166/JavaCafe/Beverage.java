package E21166.JavaCafe;

// Beverage class extends Drink
public class Beverage extends Drink{

	// field statement
	private String typeBeverage;
	private String sizeBeverage;
	
	// constructor
	public Beverage(String type, String sweetener, String syrup, String typeDairy, String additionalComponents, String specialInstructions, String typeBeverage, String sizeBeverage) {
		
		super(type, sweetener, syrup, typeDairy, additionalComponents, specialInstructions);
		this.typeBeverage = typeBeverage;
		this.sizeBeverage = sizeBeverage;
		
	}// end constructor

	// setters and getters
	public String getTypeBeverage() {
		return typeBeverage;
	}

	public void setTypeBeverage(String typeBeverage) {
		this.typeBeverage = typeBeverage;
	}

	public String getSizeBeverage() {
		return sizeBeverage;
	}

	public void setSizeBeverage(String sizeBeverage) {
		this.sizeBeverage = sizeBeverage;
	}
	
}// end class Beverage
