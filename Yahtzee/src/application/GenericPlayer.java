package application;

abstract public class GenericPlayer extends Hand {
	protected String name;
	protected int playerNum;
	protected boolean doneRolling;
	
	public GenericPlayer(String name) {
		super();
		this.name = name;
		doneRolling = false;
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
