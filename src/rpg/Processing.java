package rpg;
/**
 * idk help
 * @author qwertyuiop1
 *
 */

public class Processing {

	Battle battle = new Battle();
	Enemy enemy = new Enemy();
	Stats stats = new Stats(); 
		
	private String out;
	public int userHP, totHP, eHP, eTotHP, vitality, strength, luck, points, exp, expNeeded, level, eLevel, eEXP, eStrength;
	public boolean eAlive= false;
	int[] playerStats; 
	int[] enemyStats;
	// int[] enemy =  {eLevel, eHP, eEXP, eStrength};
	public Processing () {
			out = null;
			level = 0;
			totHP = 0;
			vitality = 0;
			strength = 0;
			luck = 0;
			exp = 0;
			expNeeded = 0;
			points = 0;
			userHP = 50;
			
			eHP = 0;
			eTotHP = 0;
			eLevel = 0;
			eEXP = 0;
			eStrength = 0;
			
			// playerStats = {level, totHP, userHP vitality, strength, luck, exp, expNeeded, points};
			stats.setInitStats();
			stats.setEXP(0);
			playerStats = stats.getStats();
			setStats();
	}

	public void setProcess(String in) {
		
		if (in.equals("/fight")) 
			setFight();
		
		else 
			if (in.equals("/heal")) 
				setHeal();
			
			else 
				if (in.equals("/advance")) 
						setEncounter();
				
				else 
					if (in.equals("/flee")) 
							setEscape();
						
					else 
						if (in.equals("/restart")) 
							setRestart();
						
						else 
							if (in.equals("/stats") || in.equals("/start")) {
								setStats();
								setStatsOutput();
							}
							else {
								String [] segments = in.split("/");
								if (segments[2].equals("strength"))
									setAllocate(2);
								else 
									if (segments[2].equals("vitality"))
										setAllocate(3);
									else
										if (segments[2].equals("luck"))
											setAllocate(1);
								
							}
							
		
	}
		
	public void setFight() {
		if  (eAlive == false) {
			out = "No enemy to fight. /advance to find enemies";
		}
		else {
			
		battle.setDmg(strength, enemy.getEStrength());
		battle.setHP(userHP, eHP);
		userHP = battle.getUserHP();
		eHP = battle.getEHP();
		if (battle.getEHP()<=0)
			eAlive = false;
		stats.setStats(getStats());
		
		
		userHP = battle.getUserHP();
		stats.setStats(getStats());
		out = "Enemy dealt " + String.valueOf(battle.getEDmg()) + " damage to you" +System.lineSeparator()+ "Your HP: " 
				+ userHP + System.lineSeparator() + "You dealt "+String.valueOf(battle.getUserDmg()) + " damage"
				+System.lineSeparator()+ "Enemy Hp: " + String.valueOf(battle.getEHP());
	
		}
	}
		
	public void setHeal() {
		stats.setStats(getStats()); //check
		stats.setHeal();
		setStats(); //check
		out = "User has healed for " + String.valueOf(25 * level) + System.lineSeparator() + 
				"HP: " + String.valueOf(userHP);
	}
	public void setRestart() {
		stats.setInitStats();
		setStats();
		stats.setStats(getStats()); 
		setStatsOutput();
				//	playerStats = {level, totHP, vitality, strength, luck, exp, expNeeded, points};

	}
	public void setAllocate(int allocate) {
		if (points > 0) {
			switch (allocate) {
			case 3: stats.setVitality(); 
				break;
			case 2: stats.setStrength();
				break;
			case 1: stats.setLuck();
				break;	
			default: break;
			}	
		}
			else 
				out = "You do not have any points";
		setStats();
		stats.setStats(getStats());
		setStatsOutput();
		
	}
	public void setEscape() {
		eAlive = false;
		out = "User has fled, what a coward";
	}
	public void setEncounter() {
		if (eAlive == true) 
			out = "User is already in a fight!";
		else {
			eAlive = true;
			enemy.setEStats(level);
			setEStats();
			out = "A challenger appears!!" + System.lineSeparator() + "User level: " + String.valueOf(level)
			+ System.lineSeparator() + "HP: " + String.valueOf(userHP) + "/" + String.valueOf(totHP)
			+ System.lineSeparator() + "Enemy level: " + String.valueOf(eLevel)
			+ System.lineSeparator() + "Enemy HP: " + String.valueOf(eHP) + "/" + String.valueOf(eTotHP);
			// int[] enemyStats =  {eLevel, eHP, eEXP, eStrength};
		}
	}
	public void setStats() {
		playerStats = stats.getStats();
		level = playerStats[0];
		totHP = playerStats[1];
		userHP = playerStats[2];
		vitality = playerStats[3];
		strength = playerStats[4];
		luck = playerStats[5];
		exp = playerStats[6];
		expNeeded = playerStats[7];
		points = playerStats[8];
//		playerStats = {level, totHP, userHP vitality, strength, luck, exp, expNeeded, points};
		  
	}
	public void setEStats() {
		enemyStats = enemy.getEStats();
		eLevel = enemyStats[0];
		eTotHP = enemyStats[1];
		eHP = eTotHP;
		eEXP = enemyStats[2];
		eStrength = enemyStats[3];
		// int[] enemyStats =  {eLevel, eHP, eEXP, eStrength};

	}
	public int[] getStats() {
//		playerStats = {level, totHP, userHP vitality, strength, luck, exp, expNeeded, points};

		int[] userStats= {level, totHP, userHP, vitality, strength, luck, exp, expNeeded, points};
		return userStats;
	}
	
	public void setStatsOutput() {
		setStats();
		out = "User level: " + String.valueOf(level) 
		+ System.lineSeparator() + "EXP: " + String.valueOf(exp) + "/" + String.valueOf(expNeeded)
		+ System.lineSeparator() + "HP: " + String.valueOf(userHP) + "/" + String.valueOf(totHP) 
		+ System.lineSeparator() + "Vitality: " + String.valueOf(vitality) 
		+ System.lineSeparator() + "Strength: " + String.valueOf(strength) 
		+ System.lineSeparator()+ "Luck: " + String.valueOf(luck) 
		+ System.lineSeparator() + "Unassigned points: " + String.valueOf(points);
	}
		
		
		
		
		
/*		
		while (eAlive == false) {
			eAlive = true;
			enemy.setEStats(stats.getLevel());
		}
		
		battle.setDmg(strength, enemy.getEStrength());
		battle.setHP(userHP, eHP);
		userHP = battle.getUserHP();
		eHP = battle.getEHP();
		if (battle.getEHP()<=0)
			eAlive = false;
		
		userHP = battle.getUserHP();
	}
*/
	
	
	public String getOutput() {
		return out;
	}
}
