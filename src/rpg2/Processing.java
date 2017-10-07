package rpg2;

class Processing {

	private String out;
	private int userHP, drop, heal,  money, totHP, eHP, eTotHP, vitality, strength, luck, points, exp, expNeeded, eLuck, level, eLevel, eEXP, i, eStrength, userDmg, eDmg;
	private boolean isEAlive = false;
	private Enemy enemy = new Enemy();
	private Battle battle = new Battle();


	Processing() {
			out = null;
			level = 0;
			totHP = 0;
			userHP = 0;
			vitality = 0;
			strength = 0;
			luck = 0;
			exp = 0;
			expNeeded = 0;
			points = 0;
			i = 0;
			
			eHP = 0;
			eTotHP = 0;
			eLevel = 0;
			eEXP = 0;
			eStrength = 0;
			eLuck = 10;
			
			userDmg = 0;
			eDmg = 0;
			
			money = 0;
			drop = 0;
			heal = 0;
	}
	void setProcess(String in) {
		out = "" + System.lineSeparator();
		String [] segments = in.split("/");

		
		if (in.equals("/fight")) 
			setFight();
		
		else 
			if (in.equals("/heal")) 
				setHeal();
			else 
				if (in.equals("/start"))
					setStart();
			
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
							if (in.equals("/stats")) 
								setStatsOutput();
							else {
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
	private void setStart() {
		level = 1;
		totHP = 50;
		userHP = 50;
		vitality = 1;
		strength = 1;
		luck = 1;
		exp = 0;
		expNeeded = 50;
		points = 5;
		i = 1;
		money = 25;
		
		setLevel();
		setStatsOutput();
		
	}
	private void setLevel() {
		exp = exp + eEXP;
		
		if (exp >= expNeeded) {
			level++;
			userHP = totHP;
			points = level * 5 - vitality - luck - strength + 3;
			expNeeded += 40 * Math.pow(1.8, i);
			i++;
			out += "Level UP!!!!!!!!" + System.lineSeparator();
		}
	}
	private void setAllocate(int allocate) {
		if (points > 0) {
			switch (allocate) {
			case 3: vitality++; 
				break;
			case 2: strength++;
				break;
			case 1: luck++;
				break;	
			default: break;

			}
			totHP = vitality *50;
			points = level * 5 - vitality - luck - strength + 3;
			setStatsOutput();
		}
		else 
			out = "You do not have any points";
		
	}
	private void setRestart() {
		setStart();
		isEAlive = false;
		
	}
	private void setEscape() {
		if (isEAlive) {
		isEAlive = false;
		out = "User has fled, what a coward";
		}
		else 
			out = "Nothing to run away from...";
	}
	private void setEncounter() {
		if (!isEAlive) {
		isEAlive = true;
		enemy.setEStats(level);
		setEStats();
		out = System.lineSeparator() + "A challenger appears!!" + System.lineSeparator() + "User level: " + String.valueOf(level)
		+ System.lineSeparator() + "HP: " + String.valueOf(userHP) + "/" + String.valueOf(totHP)
		+ System.lineSeparator() + "Enemy level: " + String.valueOf(eLevel)
		+ System.lineSeparator() + "Enemy HP: " + String.valueOf(eHP) + "/" + String.valueOf(eTotHP);
		// int[] enemyStats =  {eLevel, eHP, eEXP, eStrength};
		}
		else 
			out = "User is already in a fight!";
		
	}
	private void setEStats() {
		int[] enemyStats = enemy.getEStats();
		eLevel = enemyStats[0];
		eTotHP = enemyStats[1];
		eHP = eTotHP;
		eEXP = enemyStats[2];
		eStrength = enemyStats[3];
		eLuck = 10;
		//	int[] eStats =  {eLevel, eHP, eEXP, eStrength};

		
	}
	private void setHeal() {
		if (money >= 5) {

			heal =(int) (Math.random() *totHP * 0.3 + totHP * .15);

			if (heal > totHP - userHP)
			heal = totHP - userHP;
			userHP += heal;

			money -= 5;

		out = System.lineSeparator() + "User has spent 5 gold"
			+ System.lineSeparator() + "User has healed for " + String.valueOf(heal)
			+ System.lineSeparator() + "HP: " + String.valueOf(userHP)
			+ System.lineSeparator() + "Gold: " + String.valueOf(money);
		}
		else 
			out = "You do not have enough funds: " + String.valueOf(money) + "/" + String.valueOf(5);
	}
	private void setFight() {
		if (isEAlive) {
			
			setOutcome();
		
			if (battle.getCrit()[1])
				out = "Critical hit!" + System.lineSeparator();
			out += "Enemy dealt " + String.valueOf(eDmg) + " damage to you" 
				+ System.lineSeparator()+ "Your HP: " + userHP 
			  	+ System.lineSeparator();
			 if (battle.getCrit()[0])
				 out += "Critical hit! " + System.lineSeparator();
			  	out += "You dealt "+String.valueOf(userDmg) + " damage"
			  	+ System.lineSeparator()+ "Enemy Hp: " + String.valueOf(eHP);
				
			if ( eHP == 0) {
				isEAlive = false;
				setLevel();
				drop = (int) (Math.random() * 8);
				money += drop;
				out += System.lineSeparator() + "Enemy is defeated"
					   + System.lineSeparator() + "Exp earned: " + String.valueOf(eEXP)
					   + System.lineSeparator() + "Gold dropped: " + String.valueOf(drop);
				
			}
			if (userHP == 0) {
				out += System.lineSeparator() + "User has been defeated " + System.lineSeparator() + "Game Over" + System.lineSeparator();
				}
			}
		else 
			out = "No enemy to fight. /advance to find enemies";
		
	}
	private void setOutcome() {
		battle.setFight(userHP, strength, eStrength, eHP, luck, eLuck);
		int[] fightOutcome = battle.getFight();
		userHP = fightOutcome[0];
		eHP = fightOutcome[1];
		userDmg = fightOutcome[2];
		eDmg = fightOutcome[3];
		
		// int[] results = {userHP, eHP, userDmg, eDmg};
	}
	int getUserHP() {
		return userHP;
	}
	private void setStatsOutput() {
		out = System.lineSeparator() + "User level: " + String.valueOf(level) 
			+ System.lineSeparator() + "EXP: " + String.valueOf(exp) + "/" + String.valueOf(expNeeded)
			+ System.lineSeparator() + "HP: " + String.valueOf(userHP) + "/" + String.valueOf(totHP) 
			+ System.lineSeparator() + "Vitality: " + String.valueOf(vitality) 
			+ System.lineSeparator() + "Strength: " + String.valueOf(strength) 
			+ System.lineSeparator() + "Luck: " + String.valueOf(luck) 
			+ System.lineSeparator() + "Unassigned points: " + String.valueOf(points)
			+ System.lineSeparator() + "Gold: " + String.valueOf(money);		
	}
	String getOutput() {
		return out;
	}
	
	
}
