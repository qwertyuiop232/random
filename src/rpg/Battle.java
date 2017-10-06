package rpg;

public class Battle {
	
	private static int userDmg, eDmg, userHP, eHP;

	public Battle() {

		userDmg = 0;
		eDmg = 0;
		userHP = 0;
		eHP = 0;

		}
		public void setDmg(int a, int b) {
			userDmg = (int) (Math.random() * a * 20 + a *15);
			eDmg = (int) (Math.random() * b* 20 + b *15);
		}
		public void setHP(int c, int d) {
			userHP = c - eDmg;
			eHP = d - userDmg;
		}
		public int getEDmg() {
			return eDmg;
		}
		public int getEHP() {
			return eHP;
		}
		public int getUserDmg() {
			return userDmg;
		}
		public int getUserHP() {
			return userHP;
		}
}

/*		
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
		

	
*/

