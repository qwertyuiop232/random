package rpg;

public class Processing {
	
	Battle battle = new Battle();
	Enemy enemy = new Enemy();
	Stats stats = new Stats(); 
	
	private String out;
	public int userHP, totHP, eHP, vitality, strength, luck, points, exp;
	public boolean eAlive= false;
	
	public Processing () {
			out = null;
			userHP = 0;
			totHP = 0;
			eHP = 0;
			vitality = 1;
			strength =1;
			luck = 1;
			points = 0;
			
	}
	public void setProcess() {
		while (eAlive == false) {
			eAlive = true;
			enemy.setEStats();
		}
		battle.setDmg(strength, enemy.getEStrength());
		battle.setHP(userHP, eHP);
		userHP = battle.getUserHP();
		eHP = battle.getEHP();
		if (eHP<=0)
			eAlive = false;
		
		
	}
	public void setOutput() {
		out = "Enemy dealt " + String.valueOf(battle.getEDmg()) + " damage to you" +System.lineSeparator()+ "Your HP: " 
				+ String.valueOf(stats.getCurrentHP()) + System.lineSeparator() + "You dealt "+String.valueOf(battle.getUserDmg()) + " damage"
				+System.lineSeparator()+ "Enemy Hp: " + String.valueOf(battle.getEHP());
	}
	public String getOutput() {
		return out;
	}
}
