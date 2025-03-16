package E21166.JavaCafe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order implements PriceList{	      	      
	
	private int numberOrder;
	private Drink drinkOrdered;
	private String dayOrder;
	DateTimeFormatter dtfTimeOrder = DateTimeFormatter.ofPattern("HH:mm:ss"); 
	LocalDateTime nowTimeOrder = LocalDateTime.now();
	private String timeOrder;
	private String wayDelivery;
	private String placeDelivery; 
	private String situationOrder;
	private String drink;
	private String dose, size, Syrup, AdditionalComponents;

	// constructor
	public Order(int numberOrder, Drink drinkOrdered, String dayOrder, String timeOrder, String wayDelivery, String placeDelivery, String situationOrder) {
		
	
		
		this.numberOrder = numberOrder;
		
		if(drinkOrdered instanceof Coffee) {
			setDrink("Καφές");
			dose = ((Coffee) drinkOrdered).getDoseCoffee();
		}
		if(drinkOrdered instanceof Beverage) {
			setDrink("Ρόφημα");
			size = ((Beverage) drinkOrdered).getSizeBeverage();
		} 
		Syrup = drinkOrdered.getSyrup();
		AdditionalComponents = drinkOrdered.getAdditionalComponents();

		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		this.dayOrder = dayOrder;
		this.timeOrder = timeOrder;
		this.wayDelivery = wayDelivery;
		this.placeDelivery = placeDelivery;
		this.situationOrder = situationOrder;
		
		
	}// end constructor
	

	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	public String getDrink() {
		return drink;
	}
	
	public String getCodeOrder() {
		return "<" + dayOrder + ">-<" + numberOrder + ">-" + drink;
	}
	
	public void setCodeOrder(String codeOrder) {
	}
	
	public Drink getDrinkOrdered() {
		return drinkOrdered;
	}


	public void setDrinkOrdered(Drink drinkOrdered) {
		this.drinkOrdered = drinkOrdered;
	}


	public int getNumberOrder() { 
		return numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		this.numberOrder = numberOrder;
	}

	public String getDayOrder() {
		return dayOrder;
	}

	public void setDayOrder(String dayOrder) {
		this.dayOrder = dayOrder;
	}

	public String getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(String timeOrder) {
		this.timeOrder = timeOrder;
	}

	public String getWayDelivery() {
		return wayDelivery;
	}

	public void setWayDelivery(String wayDelivery) {
		this.wayDelivery = wayDelivery;
	}

	public String getPlaceDelivery() {
		return placeDelivery;
	}

	public void setPlaceDelivery(String placeDelivery) {
		this.placeDelivery = placeDelivery;
	}

	public String getSituationOrder() {
		return situationOrder;
	}

	public void setSituationOrder(String situationOrder) {
		this.situationOrder = situationOrder;
	}
	
	// calculation of the price of the drink
	private double totalPrice = 0;
	public double calculateTotalPrice() {

		if(drink == "Καφές") {
			if(dose == "Μονός") {
				totalPrice = coffeePrice + singleDosePrice;
			}
			if(dose == "Διπλός"){
				totalPrice = coffeePrice + doubleDosePrice;
			}
		}
		if(drink == "Ρόφημα") {
			if(size == "Μικρό – 12oz") {
				totalPrice = beveragePrice + smallSize;
			}
			if(size == "Μεσαίο – 16oz"){
				totalPrice = beveragePrice + mediumSize;
			}
			if(size == "Μεγάλο – 18oz"){
				totalPrice = beveragePrice + bigSize;
			}
		}

		if(Syrup != null) {
			totalPrice += syrupPrice;
			
		}
		if(AdditionalComponents == "Σαντιγύ") {
			totalPrice += whippedCreamAdditionalComponents;

		}
		
		totalPrice = Math.round(totalPrice * 10000000) / 10000000.0;

		return totalPrice;
		
	}

	public double getTotalPrice() {

		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}// end class Order
