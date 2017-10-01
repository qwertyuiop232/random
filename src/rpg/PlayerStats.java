package rpg;

/**
 * @author qwertyuiop1
 *
 */

public class PlayerStats {
	
	private int vitality, strength, luck, totHP, currentHP;
	
	public PlayerStats() {
	vitality = 1;
	strength = 1;
	luck = 1;
	totHP = 50;
	currentHP = 50;
	
	}
	public void setVitality(int v) {
		vitality += v;
		
	}
	public void setStrength(int s) {
		strength += s;
	}
	public void setLuck(int l) {
		luck += l;
	}
	public void setCurrentHP(int dmgTaken) {
		currentHP -= dmgTaken;
	}
	public void setHeal() {
		if (currentHP + 10*vitality > totHP)
			currentHP = totHP;
		else
		currentHP += 10*vitality;
	}
	public void setTotHP() {
		totHP = (50 * vitality);
	}
	public void setInitHP() {
		currentHP = totHP;
	}
	public int getTotHP() {
		return totHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public int getVitality() {
		return vitality;
	}
	public int getStrength() {
		return strength;
	}
	public int getLuck() {
		return luck;
	}
}



