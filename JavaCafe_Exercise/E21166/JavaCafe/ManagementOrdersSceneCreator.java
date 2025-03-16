package E21166.JavaCafe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class ManagementOrdersSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

	// List of orders
	ArrayList<Order> list;
	
	ArrayList<Drink> listDrink;
	// Flow Pane
	FlowPane buttonFlowPane;
	// Grid Panes
	GridPane rootGridPane, inputFieldsPane;
	// Second Scene buttons
	Button newOrderBtn, editOrderBtn, cancelOrderBtn, backBtn;
	// Second scene labels
	Label typeDrinkLbl, sweetenerLbl, syrupLbl, typeDairyLbl, additionalComponentsLbl, specialInstructionsLbl, typeCoffeeLbl, doseCoffeeLbl, quantitySugarLbl, typeBeverageLbl, sizeBeverageLbl, drinkOrderedLbl, wayDeliveryLbl, placeDeliveryLbl, situationOrderLbl, infoDrinkLbl, infoCoffeeLbl, infoBeverageLbl, infoOrderLbl;
	// Second scene ComboBox
	ComboBox<String> typeDrinkComboBox, sweetenerComboBox, syrupComboBox, typeDairyComboBox, additionalComponentsComboBox, typeCoffeeComboBox, doseCoffeeComboBox, quantitySugarComboBox, typeBeverageComboBox, sizeBeverageComboBox, drinkOrderedComboBox, wayDeliveryComboBox, situationOrderComboBox;
	// Second scene TextFields
	TextField specialInstructionsField, placeDeliveryField;
	
	// Table View
	TableView<Order> managementTableView;	
	
//	TableView<Drink> drinkTableView;
	
	// Tile Pane
	TilePane typeDrinkTilePane, sweetenerTilePane, syrupTilePane, typeDairyTilePane, additionalComponentsTilePane, typeCoffeeTilePane, doseCoffeeTilePane, quantitySugarTilePane, typeBeverageTilePane, sizeBeverageTilePane, drinkOrderedTilePane, wayDeliveryTilePane, situationOrderTilePane;
	
	// field statement
	int numberOrder = 0;
	double totalPrice = 0.0;
	
	DateTimeFormatter dtfDayOrder = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	LocalDateTime nowDayOrder = LocalDateTime.now();
	String dayOrder;
	
	DateTimeFormatter dtfTimeOrder = DateTimeFormatter.ofPattern("HH:mm:ss"); 
	LocalDateTime nowTimeOrder = LocalDateTime.now();
	String timeOrder;

	String  codeOrder;
	
	// Drink object for Coffee
	Drink drinkOrdered = new Coffee("Ζεστό", "Ζαχαρίνι", "Καραμέλα", "Γάλα πλήρες", "Κανέλα", "---------------", "Εσπρέσο", "Διπλός", "Μέτριος");

	
	public ManagementOrdersSceneCreator(double width, double height) {
		
		super(width, height);

		// Strings for ComboBox
		String typeDrinkString[] = {"Ζεστό", "Κρύο"};
		String sweetenerString[] = {"Λευκή Ζάχαρη", "Μαύρη Ζάχαρη", "Στέβια", "Ζαχαρίνη"};
		String syrupString[] = {"Φράουλα", "Φουντούκι", "Καραμέλα", "Σοκολάτα"};
		String typeDairyString[] = {"Γάλα πλήρες", "Γάλα light", "Γάλα χωρίς λακτόζη"};
		String additionalComponentsString[] = {"Σαντιγύ", "Κανέλα", "Σοκολάτα"};
		String typeCoffeeString[] = {"Στιγμιαίος", "Γαλλικός", "Εσπρέσο", "Καπουτσίνο"};
		String doseCoffeeString[] = {"Μονός", "Διπλός"};
		String quantitySugarString[] = {"Σκέτος", "Με ολίγη", "Μέτριος", "Γλυκός"};
		String typeBeverageString[] = {"Coffeeccino", "Σοκολάτα"};
		String sizeBeverageString[] = {"Μικρό – 12oz", "Μεσαίο – 16oz", "Μεγάλο – 18oz"};
		String drinkOrderedString[] = {"Καφές", "Ρόφημα"};
		String wayDeliveryString[] = {"Παραλαβή από το μαγαζί", "Παράδοση σε κάποια διεύθυνση"};
		String situationOrderString[] = {"Καταχωρημένη", "Σε επεξεργασία", "Έτοιμη για παραλαβή από το κατάστημα", "Έτοιμη για παράδοση", "Προς παράδοση", "Ολοκληρωμένη"};
		
		// initialize fields
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		
		// initialize fields
		infoDrinkLbl = new Label("Πληροφορίες Ποτού");
		typeDrinkLbl = new Label("Τύπος Ροφήματος: ");
		sweetenerLbl = new Label("Γλυκαντική Ουσία: ");
		syrupLbl = new Label("Σιρόπι: ");
		typeDairyLbl = new Label("Τύπος Γαλακτοκομικών: ");
		additionalComponentsLbl = new Label("Επιπλέον Συστατικά: ");
		specialInstructionsLbl = new Label("Ειδικές Οδηγίες: ");
		infoCoffeeLbl = new Label("Πληροφορίες Καφέ");
		typeCoffeeLbl = new Label("Τύπος Καφέ: ");
		doseCoffeeLbl = new Label("Δόση Καφέ: ");
		quantitySugarLbl = new Label("Ποσότητα Ζάχαρης: ");
		infoBeverageLbl = new Label("Πληροφορίες Ροφήματος");
		typeBeverageLbl = new Label("Είδος ροφήματος: ");
		sizeBeverageLbl = new Label("Μέγεθος Ροφήματος: ");
		infoOrderLbl = new Label("Πληροφορίες Παραγγελίας");
		drinkOrderedLbl = new Label("Ποτό που παραγγέλθηκε:");
		wayDeliveryLbl = new Label("Τρόπος Παράδοσης: ");
		placeDeliveryLbl = new Label("Τόπος Παράδοσης: ");
		situationOrderLbl = new Label("Κατάσταση Παραγγελίας: ");
		
		// initialize fields
		typeDrinkComboBox = new ComboBox<String>(FXCollections.observableArrayList(typeDrinkString));
		sweetenerComboBox = new ComboBox<String>(FXCollections.observableArrayList(sweetenerString));
		syrupComboBox = new ComboBox<String>(FXCollections.observableArrayList(syrupString));
		typeDairyComboBox = new ComboBox<String>(FXCollections.observableArrayList(typeDairyString));
		additionalComponentsComboBox = new ComboBox<String>(FXCollections.observableArrayList(additionalComponentsString));
		specialInstructionsField = new TextField();
		typeCoffeeComboBox = new ComboBox<String>(FXCollections.observableArrayList(typeCoffeeString));
		doseCoffeeComboBox = new ComboBox<String>(FXCollections.observableArrayList(doseCoffeeString));
		quantitySugarComboBox = new ComboBox<String>(FXCollections.observableArrayList(quantitySugarString));
		typeBeverageComboBox = new ComboBox<String>(FXCollections.observableArrayList(typeBeverageString));
		sizeBeverageComboBox = new ComboBox<String>(FXCollections.observableArrayList(sizeBeverageString));
		drinkOrderedComboBox = new ComboBox<String>(FXCollections.observableArrayList(drinkOrderedString));
		wayDeliveryComboBox = new ComboBox<String>(FXCollections.observableArrayList(wayDeliveryString));
		placeDeliveryField = new TextField();
		situationOrderComboBox = new ComboBox<String>(FXCollections.observableArrayList(situationOrderString));
		
		// initialize fields
		typeDrinkComboBox.setPromptText("---------------");
		sweetenerComboBox.setPromptText("---------------");
		syrupComboBox.setPromptText("---------------");
		typeDairyComboBox.setPromptText("---------------");
		additionalComponentsComboBox.setPromptText("---------------");
		typeCoffeeComboBox.setPromptText("---------------");
		doseCoffeeComboBox.setPromptText("---------------");
		quantitySugarComboBox.setPromptText("---------------");
		typeBeverageComboBox.setPromptText("---------------");
		sizeBeverageComboBox.setPromptText("---------------");
		drinkOrderedComboBox.setPromptText("---------------");
		wayDeliveryComboBox.setPromptText("---------------");
		situationOrderComboBox.setPromptText("---------------");
		
		typeDrinkTilePane = new TilePane(typeDrinkComboBox);
		sweetenerTilePane = new TilePane(sweetenerComboBox);
		syrupTilePane = new TilePane(syrupComboBox);
		typeDairyTilePane = new TilePane(typeDairyComboBox);
		additionalComponentsTilePane = new TilePane(additionalComponentsComboBox);
		typeCoffeeTilePane = new TilePane(typeCoffeeComboBox);
		doseCoffeeTilePane = new TilePane(doseCoffeeComboBox);
		quantitySugarTilePane = new TilePane(quantitySugarComboBox);
		typeBeverageTilePane = new TilePane(typeBeverageComboBox);
		sizeBeverageTilePane = new TilePane(sizeBeverageComboBox);
		drinkOrderedTilePane = new TilePane(drinkOrderedComboBox);
		wayDeliveryTilePane = new TilePane(wayDeliveryComboBox);
		situationOrderTilePane = new TilePane(situationOrderComboBox);
		
		newOrderBtn = new Button("Καταχώρηση");
		editOrderBtn = new Button("Τροποποίηση");
		cancelOrderBtn = new Button("Ακύρωση");
		backBtn = new Button("Επιστροφή");

		inputFieldsPane = new GridPane();
		
		managementTableView = new TableView<Order>();
		managementTableView.setPrefWidth(800);
		
//		drinkTableView = new TableView<Drink>();
//		drinkTableView.setPrefWidth(800);
		
		// Customize flowPane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newOrderBtn);
		buttonFlowPane.getChildren().add(editOrderBtn);
		buttonFlowPane.getChildren().add(cancelOrderBtn);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		
		// Customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(infoDrinkLbl, 0, 0);
		inputFieldsPane.add(typeDrinkLbl, 0, 1);
		inputFieldsPane.add(typeDrinkComboBox, 1, 1);
		inputFieldsPane.add(sweetenerLbl, 0, 2);
		inputFieldsPane.add(sweetenerComboBox, 1, 2);
		inputFieldsPane.add(syrupLbl, 0, 3);
		inputFieldsPane.add(syrupComboBox, 1, 3);
		inputFieldsPane.add(typeDairyLbl, 0, 4);
		inputFieldsPane.add(typeDairyComboBox, 1, 4);
		inputFieldsPane.add(additionalComponentsLbl, 0, 5);
		inputFieldsPane.add(additionalComponentsComboBox, 1, 5);
		inputFieldsPane.add(specialInstructionsLbl, 0, 6);
		inputFieldsPane.add(specialInstructionsField, 1, 6);
		inputFieldsPane.add(infoCoffeeLbl, 0, 7);
		inputFieldsPane.add(typeCoffeeLbl, 0, 8);
		inputFieldsPane.add(typeCoffeeComboBox, 1, 8);
		inputFieldsPane.add(doseCoffeeLbl, 0, 9);
		inputFieldsPane.add(doseCoffeeComboBox, 1, 9);
		inputFieldsPane.add(quantitySugarLbl, 0, 10);
		inputFieldsPane.add(quantitySugarComboBox, 1, 10);
		inputFieldsPane.add(infoBeverageLbl, 0, 11);
		inputFieldsPane.add(typeBeverageLbl, 0, 12);
		inputFieldsPane.add(typeBeverageComboBox, 1, 12);
		inputFieldsPane.add(sizeBeverageLbl, 0, 13);
		inputFieldsPane.add(sizeBeverageComboBox, 1, 13);
		inputFieldsPane.add(infoOrderLbl, 0, 14);
		inputFieldsPane.add(drinkOrderedLbl, 0, 15);
		inputFieldsPane.add(drinkOrderedComboBox, 1, 15);
		inputFieldsPane.add(wayDeliveryLbl, 0, 16);
		inputFieldsPane.add(wayDeliveryComboBox, 1, 16);
		inputFieldsPane.add(placeDeliveryLbl, 0, 17);
		inputFieldsPane.add(placeDeliveryField, 1, 17);
		inputFieldsPane.add(situationOrderLbl, 0, 18);
		inputFieldsPane.add(situationOrderComboBox, 1, 18);
		
		// Customize rootScene2
		// rootScene2.setGridLinesVisible(true);
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(managementTableView, 0, 0);
		
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backBtn, 1, 2);
		
		// Customize tableView
		TableColumn<Order, String> codeOrderColumn = new TableColumn<>("Κωδικός Παραγγελίας");
		codeOrderColumn.setCellValueFactory(new PropertyValueFactory<>("codeOrder"));
		managementTableView.getColumns().add(codeOrderColumn);

		TableColumn<Order, String> dayOrderColumn = new TableColumn<>("Ημερομηνία Παραγγελίας");
		dayOrderColumn.setCellValueFactory(new PropertyValueFactory<>("dayOrder"));
		managementTableView.getColumns().add(dayOrderColumn);
		
		TableColumn<Order, String> timeOrderColumn = new TableColumn<>("Ώρα Παραγγελίας");
		timeOrderColumn.setCellValueFactory(new PropertyValueFactory<>("timeOrder"));
		managementTableView.getColumns().add(timeOrderColumn);
		
		TableColumn<Order, String> wayDeliveryColumn = new TableColumn<>("Τρόπος Παράδοσης");
		wayDeliveryColumn.setCellValueFactory(new PropertyValueFactory<>("wayDelivery"));
		managementTableView.getColumns().add(wayDeliveryColumn);
		
		TableColumn<Order, String> placeDeliveryColumn = new TableColumn<>("Τόπος Παράδοσης");
		placeDeliveryColumn.setCellValueFactory(new PropertyValueFactory<>("placeDelivery"));
		managementTableView.getColumns().add(placeDeliveryColumn);
		
		TableColumn<Order, String> situationOrderColumn = new TableColumn<>("Κατάσταση Παραγγελίας");
		situationOrderColumn.setCellValueFactory(new PropertyValueFactory<>("situationOrder"));
		managementTableView.getColumns().add(situationOrderColumn);
		
		TableColumn<Order, String> calculateTotalPriceColumn = new TableColumn<>("Συνολική Τιμή");
		calculateTotalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
		managementTableView.getColumns().add(calculateTotalPriceColumn);
		
		
/*		TableColumn<Drink, String> drinkOrderedColumn = new TableColumn<>("Τύπος Ροφήματος");
		drinkOrderedColumn.setCellValueFactory(new PropertyValueFactory<>("drink"));
		drinkTableView.getColumns().add(drinkOrderedColumn);
		
		TableColumn<Drink, String> typeDrinkColumn = new TableColumn<>("Είδος Ροφήματος");
		typeDrinkColumn.setCellValueFactory(new PropertyValueFactory<>("a"));
		drinkTableView.getColumns().add(typeDrinkColumn);
		
		TableColumn<Drink, String> sweetenerColumn = new TableColumn<>("Γλυκαντική Ουσία");
		sweetenerColumn.setCellValueFactory(new PropertyValueFactory<>("sweetener"));
		drinkTableView.getColumns().add(sweetenerColumn);
		
		TableColumn<Drink, String> syrupColumn = new TableColumn<>("Σιρόπι");
		syrupColumn.setCellValueFactory(new PropertyValueFactory<>("syrup"));
		drinkTableView.getColumns().add(syrupColumn);
		
		TableColumn<Drink, String> typeDairyColumn = new TableColumn<>("Τύπος Γαλακτοκομικών");
		typeDairyColumn.setCellValueFactory(new PropertyValueFactory<>("typeDairy"));
		drinkTableView.getColumns().add(typeDairyColumn);
		
		TableColumn<Drink, String> additionalComponentsColumn = new TableColumn<>("Επιπλέον Συστατικά");
		additionalComponentsColumn.setCellValueFactory(new PropertyValueFactory<>("additionalComponents"));
		drinkTableView.getColumns().add(additionalComponentsColumn);
		
		TableColumn<Drink, String> specialInstructionsColumn = new TableColumn<>("Ειδικές Οδηγίες");
		specialInstructionsColumn.setCellValueFactory(new PropertyValueFactory<>("specialInstructions"));
		drinkTableView.getColumns().add(specialInstructionsColumn);
		
		TableColumn<Drink, String> typeCoffeeColumn = new TableColumn<>("Τύπος Καφέ");
		typeCoffeeColumn.setCellValueFactory(new PropertyValueFactory<>("typeCoffee"));
		drinkTableView.getColumns().add(typeCoffeeColumn);
		
		TableColumn<Drink, String> doseCoffeeColumn = new TableColumn<>("Δόση Καφέ");
		doseCoffeeColumn.setCellValueFactory(new PropertyValueFactory<>("doseCoffee"));
		drinkTableView.getColumns().add(doseCoffeeColumn);
		
		TableColumn<Drink, String> quantitySugarColumn = new TableColumn<>("Ποσότητα Ζάχαρης");
		quantitySugarColumn.setCellValueFactory(new PropertyValueFactory<>("quantitySugar"));
		drinkTableView.getColumns().add(quantitySugarColumn);
		
		TableColumn<Drink, String> typeBeverageColumn = new TableColumn<>("Είδος Ροφήματος");
		typeBeverageColumn.setCellValueFactory(new PropertyValueFactory<>("typeBeverage"));
		drinkTableView.getColumns().add(typeBeverageColumn);
		
		TableColumn<Drink, String> sizeBeverageColumn = new TableColumn<>("Μέγεθος Ροφήματος");
		sizeBeverageColumn.setCellValueFactory(new PropertyValueFactory<>("sizeBeverage"));
		drinkTableView.getColumns().add(sizeBeverageColumn);
*/
		
		
		// Mouse Clicked
		backBtn.setOnMouseClicked(this);
		newOrderBtn.setOnMouseClicked(this);
		editOrderBtn.setOnMouseClicked(this);
		cancelOrderBtn.setOnMouseClicked(this);
		managementTableView.setOnMouseClicked(this);

		// create object
		numberOrder++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		Order order1 = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, "Παραλαβή από το μαγαζί", "---------------", "Καταχωρημένη"); 
		totalPrice = order1.calculateTotalPrice();
		
		numberOrder++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		Order order2 = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, "Παραλαβή από το μαγαζί", "---------------", "Ολοκληρωμένη"); 
		totalPrice = order2.calculateTotalPrice();
		
		
		// Drink object for Beverage
		Drink drinkOrdered = new Beverage("Ζεστό", "Ζαχαρίνι", "Καραμέλα", "Γάλα πλήρες", "Σαντιγύ", "---------------", "Σοκολάτα", "Μεσαίο – 16oz");
		
		numberOrder++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		Order order3 = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, "Παράδοση σε κάποια διεύθυνση", "Aristotelous 74", "Ολοκληρωμένη"); 
		totalPrice = order3.calculateTotalPrice();
		
		numberOrder++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		Order order4 = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, "Προς παράδοση", "Naxou 17", "Καταχωρημένη");
		totalPrice = order4.calculateTotalPrice();
		
	
		list = new ArrayList<Order>();
		// add Order objects on the list 
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);

		
		tableSync();
			
	} 

	
	boolean flag;
	public void handle(@SuppressWarnings("exports") MouseEvent event) {

    	if(event.getSource() == backBtn) {
  
    		App.primaryStage.setTitle("Java Cafe");
        	App.primaryStage.setScene(App.mainScene);

    	}
    	if(event.getSource() == cancelOrderBtn) {
    		
    		// method for order cancellation
    		cancelOrder(codeOrder);
    		
    		tableSync();
    		clearTextFields();
    	}
    	if(event.getSource() == editOrderBtn) {
    		
    		// takes the values from ComboBox and fields 
            String typeDrink = (String) typeDrinkComboBox.getValue();
            String sweetener = (String) sweetenerComboBox.getValue(); 
            String syrup = (String) syrupComboBox.getValue();
            String typeDairy = (String) typeDairyComboBox.getValue() ;
            String additionalComponents = (String) additionalComponentsComboBox.getValue();
            String specialInstructions = specialInstructionsField.getText(); 
            String typeCoffee = (String) typeCoffeeComboBox.getValue();
            String doseCoffee = (String) doseCoffeeComboBox.getValue();  
            String quantitySugar = (String) quantitySugarComboBox.getValue();
    		String typeBeverage = (String) typeBeverageComboBox.getValue();
    		String sizeBeverage = (String) sizeBeverageComboBox.getValue(); 
    		String wayDelivery = (String) wayDeliveryComboBox.getValue();
    		String placeDelivery = placeDeliveryField.getText();
    		String situationOrder = (String) situationOrderComboBox.getValue();

    		// method to modify an order
    		editOrder(codeOrder, typeDrink, sweetener, syrup, typeDairy, additionalComponents, specialInstructions, typeCoffee, doseCoffee, quantitySugar, typeBeverage, sizeBeverage, dayOrder, wayDelivery, placeDelivery, situationOrder);
    	
    		tableSync();
    		clearTextFields();
    		
    	}
    	if(event.getSource() == newOrderBtn) {
    		
    		// takes the values from ComboBox and fields 
    		String typeDrink = typeDrinkComboBox.getValue();
            String sweetener = sweetenerComboBox.getValue(); 
            String syrup = syrupComboBox.getValue(); 
            String typeDairy = typeDairyComboBox.getValue();  
            String additionalComponents = additionalComponentsComboBox.getValue(); 
            String specialInstructions = specialInstructionsField.getText(); 
            String typeCoffee = typeCoffeeComboBox.getValue();
            String doseCoffee = doseCoffeeComboBox.getValue();  
            String quantitySugar = quantitySugarComboBox.getValue(); 
    		String typeBeverage = typeBeverageComboBox.getValue();
    		String sizeBeverage = sizeBeverageComboBox.getValue(); 
    		String drink = drinkOrderedComboBox.getValue();
    		String wayDelivery = wayDeliveryComboBox.getValue();
    		String placeDelivery = placeDeliveryField.getText();
    		String situationOrder = situationOrderComboBox.getValue();
    		
    		// create order from ComboBox and fields
    		if(drink == "Καφές") {
    			drinkOrdered = new Coffee(typeDrink, sweetener, syrup, typeDairy, additionalComponents, specialInstructions, typeCoffee, doseCoffee, quantitySugar);
    		}
    		if(drink == "Ρόφημα") {
    			drinkOrdered = new Beverage(typeDrink, sweetener, syrup, typeDairy, additionalComponents, specialInstructions, typeBeverage, sizeBeverage);
    		}
    		
    		// order creation method
    		newOrder(typeDrink, sweetener, syrup, typeDairy, additionalComponents, specialInstructions, typeCoffee, doseCoffee, quantitySugar, typeBeverage, sizeBeverage, drinkOrdered, dayOrder, wayDelivery, placeDelivery, situationOrder);
            
    		tableSync();
    		clearTextFields();
    		
    	}
    	if(event.getSource() == managementTableView) {
    		
    		Order selectedOrder = managementTableView.getSelectionModel().getSelectedItem();
    		
    		// show ComboBox and fields
    		if(selectedOrder != null) {
    			codeOrder = selectedOrder.getCodeOrder();
    			sweetenerComboBox.setPromptText("---------------");
    			syrupComboBox.setPromptText("---------------");
    			typeDairyComboBox.setPromptText("---------------");
    			additionalComponentsComboBox.setPromptText("---------------");
    			typeCoffeeComboBox.setPromptText("---------------");
    			doseCoffeeComboBox.setPromptText("---------------");
    			quantitySugarComboBox.setPromptText("---------------");
    			typeBeverageComboBox.setPromptText("---------------");
    			sizeBeverageComboBox.setPromptText("---------------");
    			drinkOrderedComboBox.setPromptText("---------------");
    			wayDeliveryComboBox.setPromptText(selectedOrder.getWayDelivery());
    			placeDeliveryField.setText(selectedOrder.getPlaceDelivery());
    			situationOrderComboBox.setPromptText(selectedOrder.getSituationOrder());
    			flag = true; // check if the order is registered
    			
    		}
    		  		
    	}
    		
	}

	// create order from data provided by the user
	public void newOrder(String typeDrink, String sweetener, String syrup, String typeDairy, String additionalComponents, String specialInstructions, String typeCoffee, String doseCoffee, String quantitySugar, String typeBeverage, String sizeBeverage, Drink drinkOrdered, String dayOrder, String wayDelivery, String placeDelivery, String situationOrder) {
		
		numberOrder ++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		
		Order order = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, wayDelivery, placeDelivery, situationOrder);
		list.add(order);
		totalPrice = order.calculateTotalPrice();
		
	}

	// modify order from data provided by the user
	public void editOrder(String codeOrder, String typeDrink, String sweetener, String syrup, String typeDairy, String additionalComponents, String specialInstructions, String typeCoffee, String doseCoffee, String quantitySugar, String typeBeverage, String sizeBeverage, String dayOrder, String wayDelivery, String placeDelivery, String situationOrder) {

		for(Order order : list) {
			
			if(order.getCodeOrder().equals(codeOrder)) {
				if(order.getSituationOrder().equals("Καταχωρημένη")) {
					order.setDrinkOrdered(drinkOrdered);
					order.setWayDelivery(wayDelivery);
					order.setPlaceDelivery(placeDelivery);
					order.setSituationOrder(situationOrder);
					
					tableSync();
				}
            	else {
	                // set alert type
	                alert.setAlertType(AlertType.INFORMATION);
	                alert.setContentText("Τhe order must be registered.");
	                // show the dialog
	                alert.show();
            	}
			}

		}

	}
	
	
	Alert alert = new Alert(AlertType.NONE);
	// cancel order
	public void cancelOrder(String codeOrder) {
		
		for(Order order : list) {
			if(flag) {
				if(order.getCodeOrder().equals(codeOrder)) {
                	if(order.getSituationOrder().equals("Καταχωρημένη")) {
                		// cancels the selected order
        				list.remove(order);
        				break;
                	}
                	else {
		                // set alert type
		                alert.setAlertType(AlertType.INFORMATION);
		                alert.setContentText("Τhe order must be registered.");
		                // show the dialog
		                alert.show();
                	}
                }              
			} 
	        else {
	            // set alert type
	            alert.setAlertType(AlertType.WARNING);
	            alert.setContentText("No order has been selected for deletion!");
	            // show the dialog
	            alert.show();
	        }
		}
		
	}

	
	public void tableSync() {
		
		List<Order> items = managementTableView.getItems();

		items.clear();
		// show the list items
		for (Order i : list) {
			if (i instanceof Order) {
			   items.add(i);
			}
		}
		
/*		List<Drink> itemsDrink = drinkTableView.getItems();
		
		itemsDrink.clear();
		for (Drink i : listDrink) {
			if (i instanceof Drink) {
				itemsDrink.add(i);
			}
		}
*/	
		
	}
	
	
	public void clearTextFields() {
		
		// clear text fields
		typeDrinkComboBox.setPromptText("");
        sweetenerComboBox.setPromptText(""); 
        syrupComboBox.setPromptText(""); 
        typeDairyComboBox.setPromptText("");  
        additionalComponentsComboBox.setPromptText(""); 
        specialInstructionsField.setText(""); 
        typeCoffeeComboBox.setPromptText("");
        doseCoffeeComboBox.setPromptText("");  
        quantitySugarComboBox.setPromptText(""); 
		typeBeverageComboBox.setPromptText("");
		sizeBeverageComboBox.setPromptText(""); 
		wayDeliveryComboBox.setPromptText("");  
		placeDeliveryField.setText("");  
		situationOrderComboBox.setPromptText(""); 
		
	}
	
	
	Scene createScene() {
		
		return new Scene(rootGridPane, width, height);
		
	}
	
}
