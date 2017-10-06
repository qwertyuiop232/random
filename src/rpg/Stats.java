package rpg;

public class Stats {
		
	public static int vitality, strength, luck, totHP, level, exp, points, i, expNeeded, userHP;
	
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
	userHP = 0;
	
	}
	public void setInitStats() {
		level = 1;
		totHP = 50;
		vitality = 1;
		strength = 1;
		luck = 1;
		points = 5;
		userHP = 50;
		i = 1;
	}
	public void setStats(int[] stats) {
		level = stats[0];
		totHP = stats[1];
		userHP = stats[2];
		vitality = stats[3];
		strength = stats[4];
		luck = stats[5];
		exp = stats[6];
		expNeeded = stats[7];
		points = stats[8];
//		playerStats = {level, totHP, userHP vitality, strength, luck, exp, expNeeded, points};

	}
	
	public static int getHeal() {
		if (userHP <= 25) 
			userHP = totHP;
		else 
			userHP = userHP + 25;
		return userHP;
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
			while (i < level) {
				expNeeded += 50 * 2 * Math.pow(2, i);
				i++;
				if (exp >= expNeeded) {
					level++;
					points = level * 5 - vitality - luck - strength + 3;
				}
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
//		playerStats = {level, totHP, userHP vitality, strength, luck, exp, expNeeded, points};

		int[] a= {level, totHP, userHP, vitality, strength, luck, exp, expNeeded, points};
		return a;
	}
	
}
