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
    void playAgain(ActionEvent event) {

    }

}
