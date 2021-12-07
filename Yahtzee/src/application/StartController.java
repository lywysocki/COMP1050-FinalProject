package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class StartController {

	// Event Listener on Button.onAction
	@FXML
	public void launchScreen(ActionEvent event) throws IOException {
		Parent startParent = FXMLLoader.load(getClass().getResource("Launch.fxml"));
		
		Scene launchView = new Scene(startParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(launchView);
		window.show();
	}
}
