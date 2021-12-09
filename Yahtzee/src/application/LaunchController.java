package application;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	
	
	/**
	 * Tests if a string can be converted into an int
	 * @param s
	 * @return boolean, true if string is an int
	 */
	public static boolean isInt(String hum) {
		try {
			Main.intStringToInt(hum);

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
	
	
	public void createGameScenes(ActionEvent event) throws IOException {
	
		if(isInt(humPlayers.getText())==false) {
			humPlayers.deleteText(0, humPlayers.getText().length());
			
		}
		else {
			amtHum = Main.intStringToInt(humPlayers.getText());
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

