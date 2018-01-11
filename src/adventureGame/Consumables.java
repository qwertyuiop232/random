package adventureGame;

public class Consumables extends items{
	private int healthGain;
	private int manaGain;
	private int statPoint;
	public Consumables(String name, int healthGain, int manaGain, int statPoint, int cost, int ID) {
		super(ID, name, cost);
		this.healthGain = healthGain;
		this.manaGain = manaGain;
		this.statPoint = statPoint;
	}
	public int healthGain() {
		return healthGain;
	}
	public int manaGain() {
		return manaGain;
	}
	public int statPoint() {
		return statPoint;
	}
}
