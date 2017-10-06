package rpg;

public class Stats {
		
	public int vitality, strength, luck, totHP, level, exp, points, i, expNeeded;
	
	public Stats() {
	vitality = 0;
	strength = 0;
	luck = 0;
	totHP = 0;
	level = 0;
	exp = 0;
	points = 0;
	i= 0;
	expNeeded =0;
	
	}
	public void setStats() {
		vitality = 1;
		strength = 1;
		luck = 1;
		totHP = 50;
		level = 1;
		points = 5;
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
	public void setTotHP() {
		totHP = (50 * vitality);
	}
	public void setEXP(int expGained) {
		exp += expGained;
		if (exp>=expNeeded) {
				level++;
				setPoints();
			}
			if (i <= level) {
				expNeeded += 50 * 2 * Math.pow(2, i);
				i++;
			}
	}

	public void setPoints() {
		points = level * 5 - vitality - luck - strength + 3;
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
