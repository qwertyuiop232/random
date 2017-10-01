package rpg;

public class Battle {
	
	private int userDmg, eDmg;

	PlayerStats stats;
	Enemy enemy;
	
		public Battle() {

			userDmg = 0;
			eDmg = 0;
		
			stats = new PlayerStats(); //Take out and set actual values, not new ones
			enemy = new Enemy();
			enemy.setEStats();
		}

		
		public void setFight() {		
			userDmg = (int) (Math.random() * stats.getStrength() * 20 + stats.getStrength() *15);
			eDmg = (int) (Math.random() *enemy.getEStrength() * 20 + enemy.getEStrength() * 15);
			stats.setCurrentHP(eDmg);
			enemy.setEHP(userDmg);
							
		}

}
		

	


