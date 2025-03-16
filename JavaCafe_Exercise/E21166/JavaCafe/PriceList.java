package E21166.JavaCafe;

// PriceList  interface
public interface PriceList {

	// field statement
	double coffeePrice = 2.00;
	double singleDosePrice = 0;
	double doubleDosePrice = 0.30;
	
	double beveragePrice = 3.00;
	double smallSize = 0;
	double mediumSize = 0.30;
	double bigSize = 0.60;
	
	double syrupPrice = 0.30;
	double whippedCreamAdditionalComponents = 0.30;
	
	// calculateTotalPrice() method
	double calculateTotalPrice();
		
}
