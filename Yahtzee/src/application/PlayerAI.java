package application;

public class PlayerAI extends GenericPlayer{
	protected String name;
	protected int aiNum;

	public PlayerAI(String name, int num) {
		super(name);
		this.name = String.format("AI-%d", aiNum);
	}

	@Override
	public boolean isRolling() {
		System.out.printf("%s: It is your turn to roll", name);
		return false;
	}

}
