package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GameController extends Hand{

	@FXML
	GridPane Player1;
	@FXML
	GridPane Player2;
	@FXML
	GridPane Player3;
	@FXML
	GridPane Player4;
	@FXML
	Button beginButton;
	@FXML
	ImageView d1;
	@FXML
	ImageView d2;
	@FXML
	ImageView d3;
	@FXML
	ImageView d4;
	@FXML
	ImageView d5;
	@FXML
	CheckBox check1;
	@FXML
	CheckBox check2;
	@FXML
	CheckBox check3;
	@FXML
	CheckBox check4;
	@FXML
	CheckBox check5;
	
	Hand h = new Hand();
	
	
	public void Begin() {
		Player1.setVisible(true);
		beginButton.setVisible(false);
	}
	public void Roll() {
		ImageView[] d = {d1,d2,d3,d4,d5};
		
		for(int x=0;x<d.length;x++) {
			if (a[x].isKept()==false) {
				a[x].roll();
				d[x].setImage(new Image(getClass().getResource(a[x].getImage()).toExternalForm()));
			}
			
		}
	}
	public void Keep1() {
		a[0].keepOrRoll();
	}
	public void Keep2() {
		a[1].keepOrRoll();
	}
	public void Keep3() {
		a[2].keepOrRoll();
	}
	public void Keep4() {
		a[3].keepOrRoll();
	}
	public void Keep5() {
		a[4].keepOrRoll();
	}
	

    @FXML
    void oneChosen() {
    	int score=0;
    	for(int i=0; i<5; i++) {
    		if (a[i].getValue()==1) {
    			score+=1;
    		}
    	}
    	
    }
	
	
	
	
}
