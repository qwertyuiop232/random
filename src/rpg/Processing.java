package rpg;

public class Processing {
	
	Battle battle = new Battle();
	Enemy enemy = new Enemy();
	Stats stats = new Stats(); 
		
	private String out;
	public int userHP, totHP, eHP, eTotHP, vitality, strength, luck, points, exp;
	public boolean eAlive= false;
	

	public Processing () {
			out = null;
			userHP = 50;
			totHP = 50;
			eHP = 50;
			vitality = 1;
			strength = 1;
			luck = 1;
			points = 5;
			eTotHP = 50;
			
			stats.setStats();
			
	}

	public void setProcess() {
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
	
	
	public void setOutput() {
		out = "Enemy dealt " + String.valueOf(battle.getEDmg()) + " damage to you" +System.lineSeparator()+ "Your HP: " 
				+ userHP + System.lineSeparator() + "You dealt "+String.valueOf(battle.getUserDmg()) + " damage"
				+System.lineSeparator()+ "Enemy Hp: " + String.valueOf(battle.getEHP());
	}
	
	public String getOutput() {
		return out;
	}
}
