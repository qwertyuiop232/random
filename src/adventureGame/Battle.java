package adventureGame;
/**
 * 
 * @author qwertyuiop1
 *
 * might try to clone the enemy
 */
public class Battle {
	Character player;
	Enemy enemy;
	boolean done; 
	int eHP;
	int eMP;

	public Battle(Character player, int enemyID) {
		this.player = player;
		enemy = gmInventory.getEnemy(enemyID);
		eHP = enemy.getBaseStats(0);
		eMP = enemy.getBaseStats(1);
		done = false;
		engage();
	}
	private void engage() {
		while(!done) {

			currentTurn(findTurn());
		}
	}

	private void currentTurn(int findTurn) {

		
		if(eHP <= 0) {
			done = true;
			player.sideStats[3] += enemy.dropGold();
			player.gainEXP(enemy.dropEXP());
		}
	}
	private int findTurn() {
	
		return 0;
		
	}
	private void attack() {
		
	}
	private void useItem() {
		
	}
	private void useAbility() {
		
	}
	private void flee() {
		if(true) {
			done = true;
		}
	}

}
