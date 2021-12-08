package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GamePlayController {

	
	//VARIABLE INITIALIZATION
	
	private ArrayList<Player> players;
	private ArrayList<String> names;
	private Player currentPlayer;
	private boolean onesFinal=false;
	private boolean twosFinal=false;
	private boolean threesFinal=false;
	private boolean foursFinal=false;
	private boolean fivesFinal=false;
	private boolean sixesFinal=false;
	private boolean tokFinal=false;
	private boolean fokFinal=false;
	private boolean fhFinal=false;
	private boolean ssFinal=false;
	private boolean lsFinal=false;
	private boolean chanceFinal=false;
	private boolean yahtzeeFinal=false;
	

    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    @FXML
    private CheckBox check5;
    
    
    
    @FXML
    private ImageView d1;
    @FXML
    private ImageView d2;
    @FXML
    private ImageView d3;
    @FXML
    private ImageView d4;
    @FXML
    private ImageView d5;
    
    
    @FXML
    private GridPane scorecard;
    

    @FXML
    private Label ones;
    @FXML
    private Label twos;
    @FXML
    private Label threes;
    @FXML
    private Label fours;
    @FXML 
    private Label fives;
    @FXML
    private Label sixes;
    @FXML
    private Label bonus = new Label("35");
    @FXML
    private Label upperTotal1;
    @FXML
    private Label tok;
    @FXML
    private Label fok;
    @FXML
    private Label fh = new Label("25");
    @FXML
    private Label smStraight = new Label("30");
    @FXML
    private Label lgStraight = new Label("40");
    @FXML
    private Label chance;
    @FXML
    private Label yahtzee = new Label("50");
    @FXML
    private Label lowerTotal;
    @FXML
    private Label upperTotal2;
    @FXML
    private Label grandTotal;
    
    
    
    @FXML
    private Label name;
    
    Hand h = new Hand();
    
   
    
    
    
    /**
     * 
     * @param players
     */
    public void initData(ArrayList<Player> players) {
    	this.players=players;
    	currentPlayer=players.get(0);
    	name.setText(currentPlayer.getName());
    	
    }
    
    
    
    @FXML
    /**
     * Triggered by an action on the roll button
     * randomizes value of each dice and displays the image associated
     * checks the hand for all combinations and sets the associated label to the possible score
     * Limits rolls to 3 per turn
     * 
     * @param event
     */
    void Roll(ActionEvent event) {
    	ImageView[] d = {d1,d2,d3,d4,d5};
		for(int i=0; i<d.length; i++) {
			if (h.a[i].isKept()==false) {
				h.a[i].roll();
				d[i].setImage(new Image(getClass().getResource(h.a[i].getImage()).toExternalForm()));
			}
			
		}
		
		//set upper labels based on if theyre final or not
		
		if(!onesFinal) {
			ones.setText(String.format("%d", Hand.upperScoreCalc(1, h.getHandValue())));
		}
		if(!twosFinal) {
			twos.setText(String.format("%d", Hand.upperScoreCalc(2, h.getHandValue())));
		}
		if(!threesFinal) {
			threes.setText(String.format("%d", Hand.upperScoreCalc(3, h.getHandValue())));
		}
		if(!foursFinal) {
			fours.setText(String.format("%d", Hand.upperScoreCalc(4, h.getHandValue())));
		}
		if(!fivesFinal) {
			fives.setText(String.format("%d", Hand.upperScoreCalc(5, h.getHandValue())));
		}
		if(!sixesFinal) {
			sixes.setText(String.format("%d", Hand.upperScoreCalc(6, h.getHandValue())));
		}
		if(!chanceFinal) {
			chance.setText(String.format("%d", Hand.lowerScoreCalc(h.getHandValue())));
		}
		
		
		
		//set lower labels based on if they fit the category and arent final
		
		if(Hand.hasAmountOf(h.getHandValue(), 3) && !tokFinal) {
			tok.setText(String.format("%d", Hand.lowerScoreCalc(h.getHandValue())));
		}
		if(Hand.hasAmountOf(h.getHandValue(), 4) && !fokFinal) {
			fok.setText(String.format("%d", Hand.lowerScoreCalc(h.getHandValue())));
			
			
			
		//reset constant values if dont fit category
			
		}
		if(Hand.hasAmountOf(h.getHandValue(), 5) && !yahtzeeFinal) {
			yahtzee.setVisible(true);
		}
		else if (!Hand.hasAmountOf(h.getHandValue(), 5)) {
			yahtzee.setVisible(false);
		}
		
		
		if(Hand.isFullHouse(h.getHandValue()) && !fhFinal) {
			fh.setVisible(true);
		}
		else if (!Hand.isFullHouse(h.getHandValue())) {
			fh.setVisible(false);
		}
		
		
		if(Hand.isSmallStraight(h.getHandValue()) && !ssFinal) {
			smStraight.setVisible(true);
		}
		else if (!Hand.isSmallStraight(h.getHandValue())) {
			smStraight.setVisible(false);
		}
		
		
		if(Hand.isLargeStraight(h.getHandValue()) && !lsFinal) {
			lgStraight.setVisible(true);
		}
		else if (!Hand.isLargeStraight(h.getHandValue())) {
			lgStraight.setVisible(false);
		}
		
		
		
    }
    
    
    @FXML
    /**
     * Triggered by checking check box 1
     * keeps the first die from being rolled in the next round
     * @param event
     */
    void Keep1(ActionEvent event) {
    	h.a[0].toggleKeep();
    }

    @FXML
    /**
     * Triggered by checking check box 2
     * keeps the second die from being rolled in the next round
     * @param event
     */
    void Keep2(ActionEvent event) {
    	h.a[1].toggleKeep();
    }

    @FXML
    /**
     * Triggered by checking check box 3
     * keeps the third die from being rolled in the next round
     * @param event
     */
    void Keep3(ActionEvent event) {
    	h.a[2].toggleKeep();
    }

    @FXML
    /**
     * Triggered by checking check box 4
     * keeps the fourth die from being rolled in the next round
     * @param event
     */
    void Keep4(ActionEvent event) {
    	h.a[3].toggleKeep();
    }

    @FXML
    /**
     * Triggered by checking check box 5
     * keeps the fifth die from being rolled in the next round
     * @param event
     */
    void Keep5(ActionEvent event) {
    	h.a[4].toggleKeep();
    }


    @FXML
    /**
     * sets final label to whatever score the hand has in the chance category
     * @param event
     */
    void chooseChance(ActionEvent event) {
    	
    }

    @FXML
    /**
     *sets final label to whatever score the hand has in the full house category 
     * @param event
     */
    void chooseFH(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the fives category
     * @param event
     */
    void chooseFive(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the four of a kind category
     * @param event
     */
    void chooseFoK(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the tos category
     * @param event
     */
    void chooseFour(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the large straight category
     * @param event
     */
    void chooseLgStraight(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the ones category
     * @param event
     */
    void chooseOne(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the sixes category
     * @param event
     */
    void chooseSix(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the small straight category
     * @param event
     */
    void chooseSmStraight(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the threes category
     * @param event
     */
    void chooseThree(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the three of a kind category
     * @param event
     */
    void chooseToK(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the twos category
     * 
     * @param event
     */
    void chooseTwo(ActionEvent event) {

    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the yahtzee category
     * @param event
     */
    void chooseYahtzee(ActionEvent event) {

    }

    @FXML
    /**
     * clears all variable fields and sets them to a new current player
     * ex: change name, clear scorecard, add final labels from new current player to scorecard, reset die
     * 
     * @param event
     */
    void toNextPlayer(ActionEvent event) {

    }

}
