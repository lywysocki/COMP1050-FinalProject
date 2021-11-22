package application;

public class Player extends GenericPlayer{

	public Player(String name) {
		super(name);
	}

	@Override
	public boolean isRolling() {
		System.out.printf("%s: It is your turn to roll", name);
		return true;
	}

}
