package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
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
	
// Class Variables
	
	int amtHum=0;
	int amtAI=0;
	int amtTotal=0;
	ArrayList<GenericPlayer> players = new ArrayList<GenericPlayer>();
	
	

// Helpful Methods
	
	/**
	 * Tests if a string can be converted into an int
	 * @param s
	 * @return boolean, true if string is an int
	 */
	public static boolean isInt(String hum, String ai) {
		try {
			intStringToInt(hum);
			intStringToInt(ai);
		}
		catch(NumberFormatException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Input not valid");
			errorAlert.setContentText("Please enter only numbers");
			errorAlert.showAndWait();
			return false;
		} 
		return true;
	}
	
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
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Yahtzee");
		
//Main Gameplay Scene
		
		BorderPane x = new BorderPane();
		Scene s3 = new Scene(x, 500, 500);
		for (int i=0; i<amtHum; i++) {
			
		}
		
		
		
	
//Number of players input Scene
		
	//formatting new pane
		GridPane numberInput = new GridPane();
		//numberInput.setnumberInputLinesVisible(true);
		numberInput.setAlignment(Pos.CENTER);
		numberInput.setHgap(10);
		numberInput.setVgap(10);
		numberInput.setPadding(new Insets(25, 25, 25, 25));
		
	//adding content to pane
		Text scenetitle = new Text("Who's Playing?");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		numberInput.add(scenetitle, 0, 0, 2, 1);
		Label numHum = new Label("Number of human players:");
		numberInput.add(numHum, 0, 1);
		TextField humIn = new TextField();
		numberInput.add(humIn, 1, 1);
		Label numAI = new Label("Number of AI players:");
		numberInput.add(numAI, 0, 2);
		TextField aiIn= new TextField();
		numberInput.add(aiIn, 1, 2);
		Button ent = new Button("Enter");
		numberInput.add(ent, 0, 3);
		
	//setting amount of players based on text input and pressing button
		ent.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(isInt(humIn.getText(), aiIn.getText())) {
					amtHum = intStringToInt(humIn.getText());
					amtAI = intStringToInt(aiIn.getText());
					amtTotal=amtHum+amtAI;
					primaryStage.setScene(s3);
				}
			}
			
		});
		
		Scene s2 = new Scene(numberInput, 500, 300);	
		
		
//Intro Scene
	
		BorderPane intro = new BorderPane();
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		Text welcome = new Text("Yahtzee!");
		welcome.setFont(Font.font ("Verdana", 40));
		top.getChildren().add(welcome);
		intro.setTop(top);
		GridPane rules = new GridPane();
		rules.setAlignment(Pos.TOP_CENTER);
		Button start = new Button("Start");
		start.setOnAction(e -> primaryStage.setScene(s2));
		rules.add(start, 0, 0);
		intro.setCenter(rules);
		Scene s1 = new Scene(intro, 500, 500);
		
		
		
		
		
		primaryStage.setScene(s1);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
