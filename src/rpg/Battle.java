package rpg;

public class Battle {
	
	private int userDmg, eDmg;
	private String output;
	
	Stats stats;
	Enemy enemy;
	
		public Battle() {

			userDmg = 0;
			eDmg = 0;
		
			stats = new Stats(); //Take out and set actual values, not new ones
			enemy = new Enemy();
			enemy.setEStats();
		}

		
		public void setFight() {		
			userDmg = (int) (Math.random() * stats.getStrength() * 20 + stats.getStrength() *15);
			eDmg = (int) (Math.random() *enemy.getEStrength() * 20 + enemy.getEStrength() * 15);
			stats.setCurrentHP(eDmg);
			enemy.setEHP(userDmg);
			
			output = "Enemy dealt " + String.valueOf(eDmg) + " damage to you" +System.lineSeparator()+ "Your HP: " 
					+ String.valueOf(stats.getCurrentHP()) + System.lineSeparator() + "You dealt "+String.valueOf(userDmg) + " damage"
					+System.lineSeparator()+ "Enemy Hp: " + String.valueOf(enemy.getEHP());
		}
		public String getFight() {
			return output;
		}

}
		

	


