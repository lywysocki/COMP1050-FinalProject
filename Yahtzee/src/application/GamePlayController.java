package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GamePlayController {

	
	//VARIABLE INITIALIZATION
	
	private ArrayList<Player> players;
	private ArrayList<String> names;
	private int currentPlayer=0;
	
//counters for turns (max 13), players (max players.size()), and rolls (max 3)
	private int turnCounter=0;
	private int playerCounter=0;
	private int rollCounter=0;
	
//boolean values for labels final/editable
	//0=yahtzee, 1=ones, 2=twos, 3=threes, 4=fours, 5=fives, 6=sixes, 7=tok, 8=fok, 9=fh, 10=ss, 11=ls, 12=chance
	private boolean[] finalLabels = {false, false, false, false, false, false, false, false, false, false, false, false, false};

	

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
    private CheckBox onesCheck;
    @FXML
    private CheckBox twosCheck;
    @FXML
    private CheckBox threesCheck;
    @FXML
    private CheckBox foursCheck;
    @FXML
    private CheckBox fivesCheck;
    @FXML
    private CheckBox sixesCheck;
    @FXML
    private CheckBox tokCheck;
    @FXML
    private CheckBox fokCheck;
    @FXML
    private CheckBox fhCheck;
    @FXML
    private CheckBox smStraightCheck;
    @FXML
    private CheckBox lgStraightCheck;
    @FXML
    private CheckBox chanceCheck;
    @FXML
    private CheckBox yahtzeeCheck;

    @FXML
    private Label ones=new Label("0");
    @FXML
    private Label twos=new Label("0");
    @FXML
    private Label threes=new Label("0");
    @FXML
    private Label fours=new Label("0");
    @FXML 
    private Label fives=new Label("0");
    @FXML
    private Label sixes=new Label("0");
    @FXML
    private Label bonus = new Label("0");
    @FXML
    private Label upperTotal1=new Label("0");
    @FXML
    private Label tok=new Label("0");
    @FXML
    private Label fok=new Label("0");
    @FXML
    private Label fh = new Label("0");
    @FXML
    private Label smStraight = new Label("0");
    @FXML
    private Label lgStraight = new Label("0");
    @FXML
    private Label chance=new Label("0");
    @FXML
    private Label yahtzee = new Label("0");
    @FXML
    private Label lowerTotal=new Label("0");
    @FXML
    private Label upperTotal2=new Label("0");
    @FXML
    private Label grandTotal=new Label("0");
    
    
    
    @FXML
    private Label name;
    
    Hand h = new Hand();
    
   
    
    
    
    /**
     * 
     * @param players
     */
    public void initData(ArrayList<Player> players) {
    	this.players=players;
    	name.setText(players.get(currentPlayer).getName());
    	
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
    	
    	if(rollCounter<3) {
	    	ImageView[] d = {d1,d2,d3,d4,d5};
			for(int i=0; i<d.length; i++) {
				if (h.a[i].isKept()==false) {
					h.a[i].roll();
					d[i].setImage(new Image(getClass().getResource(h.a[i].getImage()).toExternalForm()));
				}
				
			}
			
			//set upper labels based on if they're final or not
			
			if(!players.get(currentPlayer).onesFinal) {
				ones.setText(String.format("%d", Hand.upperScoreCalc(1, h.getHandValue())));
			}
			if(!players.get(currentPlayer).twosFinal) {
				twos.setText(String.format("%d", Hand.upperScoreCalc(2, h.getHandValue())));
			}
			if(!players.get(currentPlayer).threesFinal) {
				threes.setText(String.format("%d", Hand.upperScoreCalc(3, h.getHandValue())));
			}
			if(!players.get(currentPlayer).foursFinal) {
				fours.setText(String.format("%d", Hand.upperScoreCalc(4, h.getHandValue())));
			}
			if(!players.get(currentPlayer).fivesFinal) {
				fives.setText(String.format("%d", Hand.upperScoreCalc(5, h.getHandValue())));
			}
			if(!players.get(currentPlayer).sixesFinal) {
				sixes.setText(String.format("%d", Hand.upperScoreCalc(6, h.getHandValue())));
			}
			if(!players.get(currentPlayer).chanceFinal) {
				chance.setText(String.format("%d", Hand.lowerScoreCalc(h.getHandValue())));
			}
			
			
			
			//set lower labels based on if they fit the category and arent final
			
			if(Hand.hasAmountOf(h.getHandValue(), 3) && !players.get(currentPlayer).tokFinal) {
				tok.setText(String.format("%d", Hand.lowerScoreCalc(h.getHandValue())));
			}
			if(Hand.hasAmountOf(h.getHandValue(), 4) && !players.get(currentPlayer).fokFinal) {
				fok.setText(String.format("%d", Hand.lowerScoreCalc(h.getHandValue())));
				
				
				
			//reset constant values if don't fit category
			
		//Yahtzee possible points
			}
			if(Hand.hasAmountOf(h.getHandValue(), 5) && !players.get(currentPlayer).yahtzeeFinal) {
				yahtzee.setText("50");
			}
			else if (!Hand.hasAmountOf(h.getHandValue(), 5)) {
				yahtzee.setText("0");
			}
			
			
		//Full House possible points
			if(Hand.isFullHouse(h.getHandValue()) && !players.get(currentPlayer).fhFinal) {
				fh.setText("25");
			}
			else if (!Hand.isFullHouse(h.getHandValue())) {
				fh.setText("0");
			}
			
			
		//Small Straight possible points
			if(Hand.isSmallStraight(h.getHandValue()) && !players.get(currentPlayer).ssFinal) {
				smStraight.setText("30");
			}
			else if (!Hand.isSmallStraight(h.getHandValue())) {
				smStraight.setText("0");
			}
			
			
		//Large Straight possible points
			if(Hand.isLargeStraight(h.getHandValue()) && !players.get(currentPlayer).lsFinal) {
				lgStraight.setText("40");
			}
			else if (!Hand.isLargeStraight(h.getHandValue())) {
				lgStraight.setText("0");
			}
			
			rollCounter+=1;
			
    	} else {
    		Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("You only get three rolls per turn.");
			errorAlert.setContentText("Please choose a category to add a score to.");
			errorAlert.showAndWait();
    	}
		
    }//end roll method
    
    
    
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
    	players.get(currentPlayer).setChance(Main.intStringToInt(chance.getText()));
    	players.get(currentPlayer).chanceFinal=true;
    }

    @FXML
    /**
     *sets final label to whatever score the hand has in the full house category 
     * @param event
     */
    void chooseFH(ActionEvent event) {
    	players.get(currentPlayer).setFullHouse();
    	players.get(currentPlayer).fhFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the fives category
     * @param event
     */
    void chooseFive(ActionEvent event) {
    	players.get(currentPlayer).setFives(Main.intStringToInt(fives.getText()));
    	players.get(currentPlayer).fivesFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the four of a kind category
     * @param event
     */
    void chooseFoK(ActionEvent event) {
    	players.get(currentPlayer).setFourOfAKind(Main.intStringToInt(fok.getText()));
    	players.get(currentPlayer).fokFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the tos category
     * @param event
     */
    void chooseFour(ActionEvent event) {
    	players.get(currentPlayer).setFours(Main.intStringToInt(fours.getText()));
    	players.get(currentPlayer).foursFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the large straight category
     * @param event
     */
    void chooseLgStraight(ActionEvent event) {
    	players.get(currentPlayer).setLgStraight();
    	players.get(currentPlayer).lsFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the ones category
     * @param event
     */
    void chooseOne(ActionEvent event) {
    	players.get(currentPlayer).setOnes(Main.intStringToInt(ones.getText()));
    	players.get(currentPlayer).onesFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the sixes category
     * @param event
     */
    void chooseSix(ActionEvent event) {
    	players.get(currentPlayer).setSixes(Main.intStringToInt(sixes.getText()));
    	players.get(currentPlayer).sixesFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the small straight category
     * @param event
     */
    void chooseSmStraight(ActionEvent event) {
    	players.get(currentPlayer).setSmStraight();
    	players.get(currentPlayer).ssFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the threes category
     * @param event
     */
    void chooseThree(ActionEvent event) {
    	players.get(currentPlayer).setThrees(Main.intStringToInt(threes.getText()));
    	players.get(currentPlayer).threesFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the three of a kind category
     * @param event
     */
    void chooseToK(ActionEvent event) {
    	players.get(currentPlayer).setThreeOfAKind(Main.intStringToInt(tok.getText()));
    	players.get(currentPlayer).tokFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the twos category
     * 
     * @param event
     */
    void chooseTwo(ActionEvent event) {
    	players.get(currentPlayer).setTwos(Main.intStringToInt(twos.getText()));
    	players.get(currentPlayer).twosFinal=true;
    }

    @FXML
    /**
     * sets final label to whatever score the hand has in the yahtzee category
     * @param event
     */
    void chooseYahtzee(ActionEvent event) {
    	players.get(currentPlayer).setYahtzee();
    	players.get(currentPlayer).yahtzeeFinal=true;
    }

    @FXML
    /**
     * clears all variable fields and sets them to a new current player
     * ex: change name, clear scorecard, add final labels from new current player to scorecard, reset die
     * 
     * @param event
     */
    void toNextPlayer(ActionEvent event) {
    	
    	currentPlayer+=1;
    	
    	if(currentPlayer==players.size()) {
    		currentPlayer=0;
    	} 
    	
    	name.setText(players.get(currentPlayer).getName());
    	
    	
    	ones.setText(String.format("%d", players.get(currentPlayer).upper[0]));
    	twos.setText(String.format("%d", players.get(currentPlayer).upper[1]));
    	threes.setText(String.format("%d", players.get(currentPlayer).upper[2]));
    	fours.setText(String.format("%d", players.get(currentPlayer).upper[3]));
    	fives.setText(String.format("%d", players.get(currentPlayer).upper[4]));
    	sixes.setText(String.format("%d", players.get(currentPlayer).upper[5]));
    	tok.setText(String.format("%d", players.get(currentPlayer).lower[0]));
    	fok.setText(String.format("%d", players.get(currentPlayer).lower[1]));
    	fh.setText(String.format("%d", players.get(currentPlayer).lower[2]));
    	smStraight.setText(String.format("%d", players.get(currentPlayer).lower[3]));
    	lgStraight.setText(String.format("%d", players.get(currentPlayer).lower[4]));
    	chance.setText(String.format("%d", players.get(currentPlayer).lower[5]));
    	yahtzee.setText(String.format("%d", players.get(currentPlayer).lower[6]));
    	
    	
    
    }
}