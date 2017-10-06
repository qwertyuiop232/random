package rpg;

public class Processing {
	
	Battle battle = new Battle();
	Enemy enemy = new Enemy();
	Stats stats = new Stats(); 
		
	private String out;
	public int userHP, totHP, eHP, eTotHP, vitality, strength, luck, points, exp, expNeeded, level;
	public boolean eAlive= false;
	int[] playerStats; 

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
			userHP = 0;
			eHP = 0;
			eTotHP = 0;
		//	playerStats = {level, totHP, vitality, strength, luck, exp, expNeeded, points};
			stats.setInitStats();
			playerStats = stats.getStats();
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
					if (in.equals("/run")) 
							setEscape();
						
					else 
						if (in.equals("/start")) 
							setStart();
						
						else 
							if (in.equals("/stats")) 
								getStats();
							
		
	}
		
	public void setFight() {
		
	}
		
	public void setHeal() {
		userHP = Stats.getHeal(userHP);
		out = "User has healed for " + String.valueOf(25 * level) + System.lineSeparator() + 
				"HP: " + String.valueOf(userHP);
	}
	public void getStats() {
		
		  
	}
	public void setStart() {
		
	}
	public void setEscape() {
		
	}
	public void setEncounter() {
		
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
	
	public void setOutput() {
		out = "Enemy dealt " + String.valueOf(battle.getEDmg()) + " damage to you" +System.lineSeparator()+ "Your HP: " 
				+ userHP + System.lineSeparator() + "You dealt "+String.valueOf(battle.getUserDmg()) + " damage"
				+System.lineSeparator()+ "Enemy Hp: " + String.valueOf(battle.getEHP());
	}
	
	public String getOutput() {
		return out;
	}
}
