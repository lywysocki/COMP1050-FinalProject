package application;

public class Player extends GenericPlayer{
	
	
	public Player() {
		super();
	}
	
	public Player(String name) {
		super(name);
	}
	
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public boolean isRolling() {
		System.out.printf("%s: It is your turn to roll", name);
		return true;
	}

	public String getName() {
		return super.name;
	}
	
	

}
