package E21166.JavaCafe;

//Drink superclass
public class Drink {

	// field statement 
	private String typeDrink;
	private String sweetener;
	private String syrup;
	private String typeDairy;
	private String additionalComponents;
	private String specialInstructions;
	
	// constructor
	public Drink(String typeDrink, String sweetener, String syrup, String typeDairy, String additionalComponents, String specialInstructions) {
		
		this.typeDrink = typeDrink;
		this.sweetener = sweetener;
		this.syrup = syrup;
		this.typeDairy = typeDairy;
		this.additionalComponents = additionalComponents;
		this.specialInstructions = specialInstructions;
		
	}// end constructor
	
	public Drink(String typeDrink) {
		this.typeDrink = typeDrink;
	}

	
	// setters and getters
	public String getTypeDrink() {
		return typeDrink;
	}
	
	public void setTypeDrink(String typeDrink) {
		this.typeDrink = typeDrink;
	}
	
	public String getSweetener() {
		return sweetener;
	}
	
	public void setSweetener(String sweetener) {
		this.sweetener = sweetener;
	}
	public String getSyrup() {
		return syrup;
	}
	
	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}
	public String getTypeDairy() {
		return typeDairy;
	}
	
	public void setTypeDairy(String typeDairy) {
		this.typeDairy = typeDairy;
	}
	
	public String getAdditionalComponents() {
		return additionalComponents;
	}
	
	public void setAdditionalComponents(String additionalComponents) {
		this.additionalComponents = additionalComponents;
	}
	
	public String getSpecialInstructions() {
		return specialInstructions;
	}
	
	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}
		
} // end class Drink
