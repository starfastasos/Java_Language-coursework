package E21166.JavaCafe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// App class extends Application
public class App extends Application {

	// Stage
	static Stage primaryStage;
	// Scenes
	static Scene mainScene, managementOrdersScene, searchOrdersScene;

	@Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
		
		App.primaryStage = primaryStage;
		
		// set Scenes
    	SceneCreator mainSceneCreator = new MainSceneCreator(900, 600);
    	mainScene = mainSceneCreator.createScene();
    	SceneCreator managementSceneCreator = new ManagementOrdersSceneCreator(1150, 700);
    	managementOrdersScene = managementSceneCreator.createScene();
    	SceneCreator searchOrdersSceneCreator = new SearchOrdersSceneCreator(1050, 500);
    	searchOrdersScene = searchOrdersSceneCreator.createScene();
    	
    	primaryStage.setScene(mainScene);
    	primaryStage.setTitle("Java Cafe");
    	primaryStage.show();
    	
    }

    public static void main(String[] args) {
        launch();
    }
    
}// end class App
