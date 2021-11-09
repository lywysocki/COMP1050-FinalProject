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
	
	public String toString() {
		return String.format("D1: %s, D2: %s, D3: %s, D4: %s, D5: %s %n", a[0].getValue(), a[1].getValue(), a[2].getValue(), a[3].getValue(), a[4].getValue());
	}
	
	
}
