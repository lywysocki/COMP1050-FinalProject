package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NameEnterPageController extends Controller{
    @FXML
    private Button BTNnewPlayerName;

    @FXML
    private Label playerNamePromptLabel;

    @FXML
    private TextField playerNametf;
    
    @FXML
    void newPlayerNameClicked(ActionEvent event) {
    	humPlayersList.get(0).setName(playerNametf.getText());
    	System.out.println(humPlayersList.get(0).getName());
    }
}
