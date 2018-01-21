package adventureGame;

import java.util.HashMap;

public class Enemy extends Players{ 
	private int possibleDropID;
	private int gold;
	private int exp;
	HashMap<Integer, Integer> abilities;
	private int enemyID;
	private String description;
	
	public Enemy(String name, String description, int gold, int[] statRatio, int possibleDropID, int enemyID, HashMap<Integer, Integer> abilities, int exp) {
		// constitution, strength, magic, agility
		super(name);
			addConstitution(statRatio[0]);
			addStrength(statRatio[1]);
			addWisdom(statRatio[2]);
			addAgility(statRatio[3]);
			this.abilities = abilities;
			this.enemyID = enemyID;
			this.exp = exp;
			this.name = name;
			this.description = description;
	}
	public int dropItem(int luck) {
		if(luck > 20) {
			if(Math.random() > 0.8) {
				return possibleDropID;
			}
		} else if(Math.random() > 0.95) {
			return possibleDropID;
		}	
		return 0;

	}
	public int dropGold() {
		return gold;
	}
	public int dropEXP() {
		return exp;
	}
	public int getID() {
		return enemyID;
	}
	public String getDescription() {
		return description;
	}

}

