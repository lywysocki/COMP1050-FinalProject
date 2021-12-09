package application;

import java.util.Random;

public class Dice {
	
	String[] s = {"d1.jpg","d2.jpg","d3.jpg","d4.jpg","d5.jpg","d6.jpg"};
	private int diceValue = 0;
	private boolean kept = false;
	
	public Dice() { // initial roll of die
		roll();
	}
	public String getImage() {
		return s[getValue()-1];
	}
	
	public int getValue() { // gets face value of die and returns as int
		return diceValue;
	}
	
	public void roll() { // rolls die 1 thru 6
		Random rand = new Random();
		diceValue = rand.nextInt(6)+1;
	}
	
	public void setKeep(boolean k) { // switches between being kept or not kept
		kept=k;
	}
	
	public void setValue(int i) {
		diceValue = i;
	}
	
	public boolean isKept() { // returns whether die is kept or not
		return kept;
	}
}

