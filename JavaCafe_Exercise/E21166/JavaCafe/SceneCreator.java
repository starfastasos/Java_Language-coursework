package E21166.JavaCafe;

import javafx.scene.Scene;

// abstract class SceneCreator
public abstract class SceneCreator {
	
	double width;;
	double height;

	// constructor
	public SceneCreator(double width, double height) {

		this.width = width;
		this.height = height;
		
	}// end constructor
	
	// abstract method createScene() 
	abstract Scene createScene();

}
