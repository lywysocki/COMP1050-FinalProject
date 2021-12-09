package application;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EndController {

    @FXML
    private Label winnerName;

    @FXML
    private Label winnerScore;
    
    private ArrayList<Player> players;

    
    
    
    protected void initData(ArrayList<Player> players) {
    	this.players=players;
    	
    }
    @FXML
    void playAgain(ActionEvent event) {

    }

}
