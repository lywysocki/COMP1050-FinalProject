package application;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EndController {

    @FXML
    private Label winnerName;

    @FXML
    private Label winnerScore;
    

    private static Player winner(ArrayList<Player> players) {
    	Player winner=players.get(0);
    	for (int i=0; i<players.size(); i++) {
    		if(winner.getTotalScore()<players.get(i).getTotalScore()) winner=players.get(i);
    	}
    	return winner;
    }
    
    
    protected void initData(ArrayList<Player> players) {
    	winnerName.setText(winner(players).getName());
    	winnerScore.setText(String.format("%d", winner(players).getTotalScore()));
    	
    }
    
    
    @FXML
    void playAgain(ActionEvent event) throws IOException {
    	Parent launchParent = FXMLLoader.load(getClass().getResource("Launch.fxml"));
		Scene s = new Scene(launchParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(s);
		window.show();
    }

}
