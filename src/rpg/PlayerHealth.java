package rpg;

public class PlayerHealth {

	private int totHP, currentHP;
	public PlayerHealth() {
		totHP = 50;
		currentHP = 50;
		
	}
	public void setCurrentHP(int dmgTaken) {
		currentHP -= dmgTaken;
	}
	public void setHeal() {
		currentHP += 500;
	}
	public void setTotHP(int vitality) {
		totHP = 50 * vitality;
	}
	public int getTotHP() {
		return totHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
}
