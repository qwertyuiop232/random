package adventureGame;

public class weapon extends items{
	private int dmg;
	private int durability;
	public weapon(String name, int dmg, int cost, int durability) {
		super (name, cost);
		this.dmg = dmg;
		this.durability = durability;
	}
	public int getDmg() {
		return dmg;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability() {
		durability--;
	}
	
}
