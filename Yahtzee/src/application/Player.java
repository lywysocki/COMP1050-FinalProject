package application;

public class Player extends Hand {
	protected String name;
	protected int playerNum;
	protected boolean doneRolling;
	protected int[] upper = {0, 0, 0, 0, 0, 0};
	protected int[] lower = {0, 0, 0, 0, 0, 0, 0};
	protected int turnCounter =0;
	
	boolean onesFinal;
	boolean twosFinal;
	boolean threesFinal;
	boolean foursFinal;
	boolean fivesFinal;
	boolean sixesFinal;
	boolean tokFinal;
	boolean fokFinal;
	boolean fhFinal;
	boolean ssFinal;
	boolean lsFinal;
	boolean chanceFinal;
	boolean yahtzeeFinal;
	
	public Player(String name) {
		super();
		
		this.name = name;
		doneRolling = false;
		onesFinal=false;
		twosFinal=false;
		threesFinal=false;
		foursFinal=false;
		fivesFinal=false;
		sixesFinal=false;
		tokFinal=false;
		fokFinal=false;
		fhFinal=false;
		ssFinal=false;
		lsFinal=false;
		chanceFinal=false;
		yahtzeeFinal=false;
		
	}
	
		public Player() {
		super();
		doneRolling=false;
	}
		
	public int getTotalUpper() {
		int total=0;
		for(int i=0;i<upper.length;i++) {
			total+=upper[i];
		}
		return total;
	}
	public int getTotalLower() {
		int total=0;
		for(int i=0;i<lower.length;i++) {
			total+=lower[i];
		}
		return total;
	}
	public int getTotalScore() {
		return getTotalUpper() + getTotalLower();
	}
	
	public void setOnes(int amt) {
		upper[0]=amt;
	}
	
	public void setTwos(int amt) {
		upper[1]=amt;
	}
	
	public void setThrees(int amt) {
		upper[2]=amt;
	}
	
	public void setFours(int amt) {
		upper[3]=amt;
	}
	
	public void setFives(int amt) {
		upper[4]=amt;
	}
	
	public void setSixes(int amt) {
		upper[5]=amt;
	}
	
	public void setThreeOfAKind(int total) {
		lower[0]=total;
	}
	
	public void setFourOfAKind(int total) {
		lower[1]=total;
	}
	
	public void setFullHouse(boolean has) {
		if (has) lower[2]=25;
	}
	
	public void setSmStraight(boolean has) {
		if (has) lower[3]= 30;
	}
	
	public void setLgStraight(boolean has) {
		if (has) lower[4]=40;
	}
	
	public void setChance(int total) {
		lower[5]=total;
	}
	
	public void setYahtzee(boolean has) {
		if(has) lower[6]=50;
		
	}
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	/**
	 * getter for doneRolling boolean
	 * 
	 * @return doneRolling
	 */
	public boolean doneRolling() {
		return doneRolling;
	}
	
	/**
	 * Marks the end of your rolling session
	 * setter for doneRolling
	 */
	public void endTurn() {
		doneRolling = true;
		System.out.printf("Your turn is done, %s%n", name);
	}
}

