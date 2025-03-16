package E21166.JavaCafe;

// Coffee class extends Drink
public class Coffee extends Drink{

	// field statement
	private String typeCoffee;
	private String doseCoffee;
	private String quantitySugar;
	
	// constructor
	public Coffee(String type, String sweetener, String syrup, String typeDairy, String additionalComponents, String specialInstructions, String typeCoffee, String doseCoffee, String quantitySugar) {
		
		super(type, sweetener, syrup, typeDairy, additionalComponents, specialInstructions);
		this.typeCoffee = typeCoffee;
		this.doseCoffee = doseCoffee;
		this.quantitySugar = quantitySugar;

	}// end constructor
	
	// setters and getters
	public String getTypeCoffee() {
		return typeCoffee;
	} 

	public void setTypeCoffee(String typeCoffee) {
		this.typeCoffee = typeCoffee;
	}

	public String getDoseCoffee() {
		return doseCoffee;
	}

	public void setDoseCoffee(String doseCoffee) {
		this.doseCoffee = doseCoffee;
	}

	public String getQuantitySugar() {
		return quantitySugar;
	}

	public void setQuantitySugar(String quantitySugar) {
		this.quantitySugar = quantitySugar;
	}
		
}// end class Coffee
