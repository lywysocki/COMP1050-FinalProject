package application;

public class Hand extends Dice{
	Dice[] a = new Dice[5];
	public Hand() { // creates hand for dice
		a[0]=new Dice();
		a[1]=new Dice();
		a[2]=new Dice();
		a[3]=new Dice();
		a[4]=new Dice(); 
	}
	
	public void rollHand() { // rolls entire hand
		for (int x=0; x<5; x++) {
			if (a[x].isKept() == false) a[x].roll(); // scans thru all dice to check if they r kept and rolls if not
		}
	}
	
	public int[] getHandValue() { // returns dice array as int array where elements are values of dice
		int[] value = new int[5];
		for (int x=0;x<5;x++) {
			value[x] = a[x].getValue();
		}
		return value;
	}
	
	@Override
	public String toString() {
		return String.format("D1: %s, D2: %s, D3: %s, D4: %s, D5: %s %n", a[0].getValue(), a[1].getValue(), a[2].getValue(), a[3].getValue(), a[4].getValue());
	}
	
	
	
	/**
	 * 
	 * @param k value of the category
	 * @param values hand of dice
	 * @return total score of the dice that match the category's number
	 */
	public static int upperScoreCalc(int k, int[] values) {
		int score=0;
		System.out.printf("Hand: %d, %d, %d, %d, %d%n", values[0], values[1], values[2], values[3], values[4]);
		for(int i=0; i<values.length; i++) {
			if(values[i]==k) {
				score+=k;
				System.out.printf("K: %d, Score: %d%n", k, score);
			}
		}
		return score;
	}

	
	
	/**
	 * 
	 * @param values hand of dice
	 * @return total score of all dice added 
	 */
	public static int lowerScoreCalc(int[] values) {
		int score=0;
		for(int i=0; i<values.length; i++) {
			score+=values[i];
		}
		return score;
	}
	
	
	
	
	/**
	 * takes in getHandValue and either 3, 4, or 5 for k
	 * to see if the hand fits 3 of a kind, 4 of a kind, or Yahtzee
	 * @param values dice hand
	 * @param k how many duplicates looking for
	 * @return if there are k amount of repeated values
	 */
	public static boolean hasAmountOf(int[] values, int k) {
		boolean isOfAKind=false;
		int i=0;
		int count=1;
		if (k<1 || values.length==0) {
			return isOfAKind;
		}
		else if (k>values.length) {
			return isOfAKind;
		}
		else if(k==1) {
			isOfAKind=true;
			return isOfAKind;
		}
		else {			
			while (i+1<values.length) {
				count = (values[i+1]==values[i]) ? count+1:1;
				if (count==k || count>k) {
					isOfAKind=true;
					return isOfAKind;
					}
				i++;
			}	
		}
		return isOfAKind;
	
	}
	
	
	
	/**
	 * 
	 * @param v dice values
	 * @return true if hand is a full house
	 */
	public static boolean isFullHouse(int[] v) {
		int value1 = v[0];
		int value2 = v[1];
		for (int i=0; i<v.length; i++) {
			if (value1 != v[i] || value2 != v[i] ) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param v dice values
	 * @param k number looking for in array
	 * @return true if value is in the array
	 */
	public static boolean hasValue(int[] v, int k) {
		for (int i=0; i<v.length; i++) {
			if (v[i]==k) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param v dice values
	 * @return true if hand is straight of size 4 or 5
	 */
	public static boolean isSmallStraight(int[] v) {
		
		if (hasValue(v, 3)==false) {
			return false;
		}
		else if (hasValue(v, 4)==false) {
			return false;
		}
		else if (hasValue(v, 1) && hasValue(v, 2)){
			return true;
		}
		else if (hasValue(v, 2) && hasValue(v, 5)) {
			return true;
		}
		else if (hasValue(v, 5) && hasValue(v, 6)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param v dice values
	 * @return true if hand is straight of size 4 or 5
	 */
	public static boolean isLargeStraight(int[] v) {
		
		if (hasValue(v, 3)==false) {
			return false;
		}
		else if (hasValue(v, 4)==false) {
			return false;
		}
		else if (hasValue(v, 1) && hasValue(v, 2) && hasValue(v, 5)){
			return true;
		}
		else if (hasValue(v, 2) && hasValue(v, 5) && hasValue(v, 6)) {
			return true;
		}
		else {
			return false;
		}
	}

}
