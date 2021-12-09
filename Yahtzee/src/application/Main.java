package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	
// a
/**
 * Converts a string assumed to be an int into an int
 * 
 * @param s element of argument array
 * @return value double variable after conversion
 * @throws NumberFormatException thrown if the string is not a double 
 */
public static int intStringToInt(String s) throws NumberFormatException{
	Integer valueObject = Integer.parseInt(s);
	int value = valueObject.intValue();
	return value;
}


	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent startParent = FXMLLoader.load(getClass().getResource("Start.fxml"));
		Scene s = new Scene(startParent);
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
