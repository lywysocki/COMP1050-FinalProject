package application;

import java.util.Random;

public class Dice {
	
	private Random r = new Random();
	private int diceValue = 0;
	private boolean kept = false;
	
	public Dice() { // initial roll of die
		roll();
	}
	
	public int getValue() { // gets face value of die and returns as int
		return diceValue;
	}
	
	public void roll() { // rolls die 1 thru 6
		diceValue = (int)(r.nextInt(6)+1);
	}
	
	public void keepOrRoll() { // switches between being kept or not kept
		if (kept == false) kept = true;
		else kept = false;
	}
	
	
	public boolean isKept() { // returns whether die is kept or not
		return kept;
	}
}
