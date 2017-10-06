package rpg;

public class Stats {
		
	private static int vitality, strength, luck, totHP, level, exp, points, i, expNeeded;
	
	public Stats() {
	vitality = 0;
	strength = 0;
	luck = 0;
	totHP = 0;
	level = 0;
	exp = 0;
	points = 0;
	i= 0;
	expNeeded = 0;
	
	}
	public void setInitStats() {
		level = 1;
		totHP = 50;
		vitality = 1;
		strength = 1;
		luck = 1;
		points = 5;
	}
	public void setStats(int[] stats) {
		level = stats[0];
		totHP = stats[1];
		vitality = stats[2];
		strength = stats[3];
		luck = stats[4];
		expNeeded = stats[5];
		points = stats[6];
		
	}
	
	public static int getHeal(int currentHP) {
		if (currentHP >= totHP + 25*level) 
			currentHP = totHP;
		else 
			currentHP += 25*level;
		return currentHP;
	}
	
	public void setVitality(int v) {
		if (points >=1) {
		vitality += v;
		points = level * 5 - vitality - luck - strength + 3;
		}
	}
	public void setStrength(int s) {
		if (points >=1) {
		strength += s;
		points = level * 5 - vitality - luck - strength + 3;
		}
	}
	public void setLuck(int l) {
		if (points >=1) {
		luck += l;
		points = level * 5 - vitality - luck - strength + 3;
		}
	}
	public void setTotHP() {
		totHP = (50 * vitality);
	}
	public void setEXP(int expGained) {
		exp += expGained;
		if (exp>=expNeeded) {
				level++;
				points = level * 5 - vitality - luck - strength + 3;
			}
			if (i <= level) {
				expNeeded += 50 * 2 * Math.pow(2, i);
				i++;
			}
	}
	public int getTotHP() {
		return totHP;
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
	public int getLevel() {
		return level;
	}
	public int getEXP() {
		return exp; 
	}
	public int getPoints() {
		return points;
	}

	public int[] getStats() {
		
		int[] a= {level, totHP, vitality, strength, luck, exp, expNeeded, points};
		return a;
	}
	
}
