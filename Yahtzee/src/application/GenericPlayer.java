package application;

abstract public class GenericPlayer extends Hand {
	protected String name;
	protected int playerNum;
	protected boolean doneRolling;
	protected int[] upper = {0, 0, 0, 0, 0, 0};
	protected int[] lower = {0, 0, 0, 0, 0, 0, 0};
	
	public GenericPlayer(String name) {
		super();
		
		this.name = name;
		doneRolling = false;
	}
	
	public int getTotalScore() {
		int total = 0;
		for (int i=0; i<6; i++) {
			total+=upper[i]+lower[i];
		}
		return total;
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
	
	public void setFullHouse() {
		lower[2]=25;
	}
	
	public void setSmStraight() {
		lower[3]= 30;
	}
	
	public void setLgStraight() {
		lower[4]=40;
	}
	
	public void setChance(int total) {
		lower[5]=total;
	}
	
	public void setYahtzee() {
		lower[6]=50;
	}
	

	public GenericPlayer() {
		super();
		doneRolling=false;
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
	
	
	public abstract boolean isRolling();
 
}
