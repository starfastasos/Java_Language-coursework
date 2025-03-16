package E21166.JavaCafe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class SearchOrdersSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

	// List of orders
	ArrayList<Order> list;
	// Flow Pane
	FlowPane buttonFlowPane;
	// Grid Panes
	GridPane rootGridPane, inputFieldsPane;
	// Second Scene buttons 
	Button searchBtn, backBtn;
	// Second scene labels
	Label drinkOrderedLbl, dayOrderLbl, fromDayOrderLbl, untilDayOrderLbl, situationOrderLbl;
	// Second scene ComboBox
	ComboBox<String> drinkOrderedComboBox, situationOrderComboBox;
	// Second scene TextFields 
	TextField drinkOrderedField, fromDayOrderField, untilDayOrderField;
	// TableView
	TableView<Order> searchTableView;

	TilePane  drinkOrderedTilePane, situationOrderTilePane;
	
	// field statement
	int numberOrder = 0;
	
	DateTimeFormatter dtfDayOrder = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	LocalDateTime nowDayOrder = LocalDateTime.now();
	String dayOrder;
	
	DateTimeFormatter dtfTimeOrder = DateTimeFormatter.ofPattern("HH:mm:ss"); 
	LocalDateTime nowTimeOrder = LocalDateTime.now();
	String timeOrder;

	public SearchOrdersSceneCreator(double width, double height)  {
		
		super(width, height);
		
		// create object
		Drink drinkOrdered = new Coffee("Ζεστό", "Ζαχαρίνι", "Καραμέλα", "Γάλα πλήρες", "Κανέλα", "---------------", "Εσπρέσο", "Διπλός", "Μέτριος");
		
		numberOrder++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		Order order1 = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, "Παραλαβή από το μαγαζί", "---------------", "Καταχωρημένη"); 

		numberOrder++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		Order order2 = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, "Παραλαβή από το μαγαζί", "---------------", "Ολοκληρωμένη"); 
		
		
		drinkOrdered = new Beverage("Ζεστό", "Ζαχαρίνι", "Καραμέλα", "Γάλα πλήρες", "Σαντιγύ", "---------------", "Σοκολάτα", "Μεσαίο – 16oz");
		
		numberOrder++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		Order order3 = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, "Παράδοση σε κάποια διεύθυνση", "Aristotelous 74", "Ολοκληρωμένη"); 

		numberOrder++;
		dayOrder = dtfDayOrder.format(nowDayOrder);
		timeOrder = dtfTimeOrder.format(nowTimeOrder);
		Order order4 = new Order(numberOrder, drinkOrdered, dayOrder, timeOrder, "Προς παράδοση", "Naxou 17", "Καταχωρημένη");
		
		String drinkOrderedString[] = {"Καφές", "Ρόφημα"};
		String situationOrderString[] = {"Καταχωρημένη", "Σε επεξεργασία", "Έτοιμη για παραλαβή από το κατάστημα", "Έτοιμη για παράδοση", "Προς παράδοση", "Ολοκληρωμένη"};

		// initialize fields
		list = new ArrayList<Order>();
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
  
			
		// initialize fields
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		
		drinkOrderedLbl = new Label("Τύπος Ροφήματος: ");
		dayOrderLbl = new Label("Ημερομηνία Παραγγελίας ");
		fromDayOrderLbl = new Label("Από: ");
		untilDayOrderLbl = new Label("Μέχρι: ");
		situationOrderLbl = new Label("Κατάσταση Παραγγελίας: ");
		
		drinkOrderedComboBox = new ComboBox<String>(FXCollections.observableArrayList(drinkOrderedString));
		fromDayOrderField = new TextField();
		untilDayOrderField = new TextField();
		situationOrderComboBox = new ComboBox<String>(FXCollections.observableArrayList(situationOrderString));
		
		drinkOrderedComboBox.setPromptText("---------------");
		situationOrderComboBox.setPromptText("---------------");
		
		drinkOrderedTilePane = new TilePane(drinkOrderedComboBox);
		situationOrderTilePane = new TilePane(situationOrderComboBox);

		searchBtn = new Button("Αναζήτηση");
		backBtn = new Button("Επιστροφή");
		
		inputFieldsPane = new GridPane();
		
		searchTableView = new TableView<Order>();
		searchTableView.setPrefWidth(600);
		
		// Customize flowPane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(searchBtn);
		buttonFlowPane.getChildren().add(backBtn);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		
		// Customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(drinkOrderedLbl, 0, 0);
		inputFieldsPane.add(drinkOrderedComboBox, 1, 0);
		inputFieldsPane.add(dayOrderLbl, 0, 1);
		inputFieldsPane.add(fromDayOrderLbl, 0, 2);
		inputFieldsPane.add(fromDayOrderField, 1, 2);
		inputFieldsPane.add(untilDayOrderLbl, 0, 3);
		inputFieldsPane.add(untilDayOrderField, 1, 3);
		inputFieldsPane.add(situationOrderLbl, 0, 4);
		inputFieldsPane.add(situationOrderComboBox, 1, 4);

		// Customize rootScene2
		// rootScene2.setGridLinesVisible(true);
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(searchTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backBtn, 1, 2);

		// Customize tableView
		TableColumn<Order, String> codeOrderColumn = new TableColumn<>("Κωδικός Παραγγελίας");
		codeOrderColumn.setCellValueFactory(new PropertyValueFactory<>("codeOrder"));
		searchTableView.getColumns().add(codeOrderColumn);
		
		TableColumn<Order, String> dayOrderColumn = new TableColumn<>("Ημερομηνία Παραγγελίας");
		dayOrderColumn.setCellValueFactory(new PropertyValueFactory<>("dayOrder"));
		searchTableView.getColumns().add(dayOrderColumn);
		
		TableColumn<Order, String> drinkOrderedColumn = new TableColumn<>("Είδος Ροφήματος");
		drinkOrderedColumn.setCellValueFactory(new PropertyValueFactory<>("drink"));
		searchTableView.getColumns().add(drinkOrderedColumn);
		
		TableColumn<Order, String> situationOrderColumn = new TableColumn<>("Κατάσταση Παραγγελίας");
		situationOrderColumn.setCellValueFactory(new PropertyValueFactory<>("situationOrder"));
		searchTableView.getColumns().add(situationOrderColumn);
		
		
		backBtn.setOnMouseClicked(this);
		searchBtn.setOnMouseClicked(this);
		searchTableView.setOnMouseClicked(this);
		
		tableSync();
//		clearTextFields();
		
	}

	
	public void handle(@SuppressWarnings("exports") MouseEvent event) {
		
    	if(event.getSource() == backBtn) {
    		
    		App.primaryStage.setTitle("Java Cafe");
        	App.primaryStage.setScene(App.mainScene);

    	}
    	if(event.getSource() == searchBtn) {
    		
            String drinkOrdered1 = drinkOrderedComboBox.getValue();
            String fromDayOrder = fromDayOrderField.getText();
            String untilDayOrder = untilDayOrderField.getText();
    		String situationOrder = situationOrderComboBox.getValue();

    		searchOrder(drinkOrdered1 , fromDayOrder, untilDayOrder, situationOrder);
    		
    	}
    	
	}

	
	public void searchOrder(String drinkOrdered1, String fromDayOrder, String untilDayOrder, String situationOrder)  {
		
		List<Order> items = searchTableView.getItems();
		items.clear();
		// search order
		for (Order i : list) {
			if (i instanceof Order) {
				if((drinkOrdered1 != null) && (situationOrder != null) && ((untilDayOrder.compareTo(dayOrder) >= 0) && (dayOrder.compareTo(fromDayOrder)>= 0))) {
					if(drinkOrdered1 == "Καφές") {
						if(i.getDrink() == "Καφές") {
							if(situationOrder == "Καταχωρημένη") {
								if(i.getSituationOrder() == "Καταχωρημένη") {
									items.add(i);
								}
							}
							if(situationOrder == "Σε επεξεργασία") {
								if(i.getSituationOrder() == "Σε επεξεργασία") {
									items.add(i);
								}
							}
							if(situationOrder == "Έτοιμη για παραλαβή από το κατάστημα") {
								if(i.getSituationOrder() == "Έτοιμη για παραλαβή από το κατάστημα") {
									items.add(i);
								}
							}	
							if(situationOrder == "Έτοιμη για παράδοση") {
								if(i.getSituationOrder() == "Έτοιμη για παράδοση") {
									items.add(i);
								}
							}	
							if(situationOrder == "Προς παράδοση") {
								if(i.getSituationOrder() == "Προς παράδοση") {
									items.add(i);
								}
							}	
							if(situationOrder == "Ολοκληρωμένη") {
								if(i.getSituationOrder() == "Ολοκληρωμένη") {
									items.add(i);
								}
							}
						}
					}
					if(drinkOrdered1 == "Ρόφημα") {
						if(i.getDrink() == "Ρόφημα") {
							if(situationOrder == "Καταχωρημένη") {
								if(i.getSituationOrder() == "Καταχωρημένη") {
									items.add(i);
								}
							}
							if(situationOrder == "Σε επεξεργασία") {
								if(i.getSituationOrder() == "Σε επεξεργασία") {
									items.add(i);
								}
							}
							if(situationOrder == "Έτοιμη για παραλαβή από το κατάστημα") {
								if(i.getSituationOrder() == "Έτοιμη για παραλαβή από το κατάστημα") {
									items.add(i);
								}
							}	
							if(situationOrder == "Έτοιμη για παράδοση") {
								if(i.getSituationOrder() == "Έτοιμη για παράδοση") {
									items.add(i);
								}
							}	
							if(situationOrder == "Προς παράδοση") {
								if(i.getSituationOrder() == "Προς παράδοση") {
									items.add(i);
								}
							}	
							if(situationOrder == "Ολοκληρωμένη") {
								if(i.getSituationOrder() == "Ολοκληρωμένη") {
									items.add(i);
								}
							}
						}
					}
				}
				clearTextFields();
			}
		}
				
	}
	
	
	public void tableSync() {
		List<Order> items = searchTableView.getItems();

		items.clear();
		for (Order i : list) {
			if (i instanceof Order) {
			   items.add(i);
			}
		}
	}
	
	
	public void clearTextFields() {
		
		drinkOrderedComboBox.setValue("---------------");
        fromDayOrderField.setText("");
        untilDayOrderField.setText("");
		situationOrderComboBox.setValue("---------------"); 
		
	}
	
	
	Scene createScene() {
		
		return new Scene(rootGridPane, width, height);
		
	}
		
}
