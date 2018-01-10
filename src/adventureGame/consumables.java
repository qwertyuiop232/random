package adventureGame;

public class consumables extends items{
	private int healthGain;
	private int manaGain;
	private int statPoint;
	public consumables(String name, int healthGain, int manaGain, int statPoint, int cost) {
		super(name, cost);
		this.healthGain = healthGain;
		this.manaGain = manaGain;
		this.statPoint = statPoint;
	}
	public void use() {
		
	}
}
