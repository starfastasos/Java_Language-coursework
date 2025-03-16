package E21166.JavaCafe;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

// MainSceneCreator class extends SceneCreator( and implements EventHandler<MouseEvent> )
public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

	// Flow Pane (root node)
	FlowPane rootFlowPane;
	// Main scene buttons
	Button managementOrdersBtn, searchOrdersBtn;

	// constructor
	public MainSceneCreator(double width, double height) {
		
		super(width, height);
		
		rootFlowPane = new FlowPane();
    	managementOrdersBtn = new Button("Διαχείριση Παραγγελιών");
    	searchOrdersBtn = new Button("Αναζήτηση Παραγγελιών");
    	
    	// attach handle event to managementOrdersBtn
    	managementOrdersBtn.setOnMouseClicked(this);
    	// attach handle event to searchOrdersBtn
    	searchOrdersBtn.setOnMouseClicked(this);
    	
    	// set up Flow pane 
    	rootFlowPane.setHgap(10);
    	rootFlowPane.setAlignment(Pos.CENTER);
    	// add 	managementOrders, searchOrders buttons to rootFlowPane	
    	rootFlowPane.getChildren().add(managementOrdersBtn);
    	rootFlowPane.getChildren().add(searchOrdersBtn);
    	
	}// end constructor
	
	Scene createScene() {
		
		return new Scene(rootFlowPane, width, height);
		
	}
	
    public void handle(@SuppressWarnings("exports") MouseEvent event) {
    	
    	if(event.getSource() == managementOrdersBtn) {
    		
    		// set Scenes
    		App.primaryStage.setScene(App.managementOrdersScene);
    		App.primaryStage.setTitle("Διαχείριση Παραγγελιών");

    	}
    	if(event.getSource() == searchOrdersBtn) {
    		
    		// set Scenes
    		App.primaryStage.setScene(App.searchOrdersScene);
    		App.primaryStage.setTitle("Αναζήτηση Παραγγελιών");

    	}
    	
    }
	
}
