package application;

import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LaunchController {
	
	public int amtHum;
	public int amtAI;
	public int amtTotal;
	public ArrayList<String> playerNameStrings= new ArrayList<String>();
	public ArrayList<Label> playerNameLabels= new ArrayList<Label>();
	public ArrayList<Player> humPlayersList = new ArrayList<Player>();
	
	@FXML
	private TextField humPlayers;
	
	@FXML
	private TextField AIPlayers;
	
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
	
	public void createGameScenes(ActionEvent event) throws IOException {
		
		Parent game = FXMLLoader.load(getClass().getResource("Game.fxml"));
		if(isInt(humPlayers.getText(), AIPlayers.getText())==false) {
			humPlayers.deleteText(0, humPlayers.getText().length());
			AIPlayers.deleteText(0, AIPlayers.getText().length());
			
		}
		else {
			amtHum = intStringToInt(humPlayers.getText());
			amtAI = intStringToInt(AIPlayers.getText());
			amtTotal=amtHum+amtAI;
			for(int i=0; i<amtHum; i++) {
				humPlayersList.add(new Player());
			}
			
			
			
			//Parent nameInput = FXMLLoader.load(getClass().getResource("NameEnterPage.fxml"));
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("NameEnterPage.fxml"));
			Parent nameInput = loader.load();
			
			Scene nameInputScene = new Scene(nameInput);
			
			NameEnterPageController nepController = loader.getController();
			nepController.initData(humPlayersList);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(nameInputScene);
			window.show();

		}
	}
	
	
}

