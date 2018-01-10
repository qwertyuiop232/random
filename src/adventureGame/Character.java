package adventureGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Character {
	int[] baseStats;
	int[] charStats;
	int[] sideStats;
	ArrayList<items> weaponsINV = new ArrayList<items>();
	ArrayList<items> consumablesINV = new ArrayList<items>();
	public Character() {
		baseStats = new int[6]; 
		charStats = new int[5];
		sideStats = new int[4];
		// base stats hp, mana, dmg, defense, magic attack, magic defense, dexterity, 
		//level, exp, levelexp, gold
		// constitution, wisdom, strength, agility, statPoints
		Arrays.fill(baseStats, 0);
		Arrays.fill(charStats, 0);
		Arrays.fill(sideStats, 0);

		charStats[0] = 2;
		charStats[1] = 1;
		charStats[2] = 1;
		charStats[3] = 1;
		constitution();
		wisdom();
		strength();
		agility();
	}
	public void addConstitution(int value) {
		charStats[0] += value;
		constitution();
	}
	public void addWisdom(int value) {
		charStats[1] += value;
		wisdom();
	}
	public void addStrength(int value) {
		charStats[2] += value;
		strength();
	}
	public void addAgility(int value) {
		charStats[3] += value;
		agility();
	}
	public void constitution() {
		baseStats[0] = 15 * charStats[0]; // hp
		baseStats[3] = 1 * charStats[0]; // defense
		baseStats[5] = 1 * charStats[0]; // m. defense
	}
	public void strength() {
		baseStats[2] = 3 * charStats[2]; // dmg
		baseStats[6] = 1 * charStats[2]; // dext
	}
	public void agility() {
		baseStats[6] = 3 * charStats[3]; // dext
		baseStats[2] = 1 * charStats[3]; // dmg
	}
	public void wisdom() {
		baseStats[1] = 10* charStats[1]; // mana
		baseStats[4] = 2 * charStats[1]; // m. defense
		baseStats[5] = 4 * charStats[1]; // m.atk
	}
	
	public int getCharStats(int statType)  {
		return charStats[statType];
	}
	public int getSideStats(int statType) {
		return sideStats[statType];
	}
	public int getBaseStats(int statType) {
		return baseStats[statType];
	}

}
