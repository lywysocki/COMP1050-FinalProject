package application;
	
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class Main extends Application {

	
// peepeepoopoo
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
