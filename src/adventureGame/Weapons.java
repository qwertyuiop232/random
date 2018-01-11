package adventureGame;

public class Weapons extends items{
	private int dmg;
	private double durability;
	public Weapons(String name, int dmg, int cost, int durability, int ID) {
		super (ID, name, cost);
		this.dmg = dmg;
		this.durability = (double) durability;
	}
	public int getDmg() {
		return dmg;
	}
	public double getDurability() {
		return durability;
	}
	public void setDurability(double used) {
		durability = used;
	}
	
}
