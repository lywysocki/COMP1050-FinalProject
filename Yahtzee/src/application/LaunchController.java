package application;

import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LaunchController {
	@FXML
	private URL Location;
	
	@FXML
	private TextField humPlayers;
	
	@FXML
	private TextField AIPlayers;
	
	int amtHum=0;
	int amtAI=0;
	int amtTotal=0;
	ArrayList<GenericPlayer> players = new ArrayList<GenericPlayer>();
	ArrayList<Scene> humScenes = new ArrayList<Scene>();
	ArrayList<Scene> AiScenes = new ArrayList<Scene>();
	ArrayList<BorderPane> playPane = new ArrayList<BorderPane>();
	
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
		amtHum = intStringToInt(humPlayers.getText());
		amtAI = intStringToInt(AIPlayers.getText());
		Scene gameView = new Scene(game);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(gameView);
		window.show();
		
	}
	
}

