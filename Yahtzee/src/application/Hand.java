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
	
	
	//takes in getHandValue and either 3, 4, or 5 for k to see if the hand fits 3 of a kind, 4 of a kind, or Yahtzee
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
	
}
