package adventureGame;

import java.util.Arrays;
import java.util.HashMap;

public class Character {
	int[] baseStats;
	int[] charStats;
	int[] sideStats;
	HashMap<Integer,Integer> weaponINV; // [id] = quantity
	HashMap<Integer, Integer> consumableINV;
	int equippedID;
	boolean equipped;
	static int[] expCurve;
	
	
	public Character() {
		weaponINV = new HashMap<Integer,Integer>();
		consumableINV = new HashMap<Integer,Integer>();
		equipped = false;
		baseStats = new int[6]; 
		charStats = new int[6];
		sideStats = new int[4];
		// base stats hp, mana, dmg, defense, magic attack, magic defense, dexterity, 
		//level, statPoints, exp, , gold
		// constitution, wisdom, strength, agility, statPoints, current hp, current mana
		Arrays.fill(baseStats, 0);
		Arrays.fill(charStats, 0);
		Arrays.fill(sideStats, 0);

		charStats[0] = 2;
		charStats[1] = 1;
		charStats[2] = 1;
		charStats[3] = 1;
		sideStats[0] = 1;
		constitution();
		wisdom();
		strength();
		agility();
		setEXP();
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
	public void equip(int weaponID) {
		// current goes to inv and weapon1 is equipped
		baseStats[3] += gmInventory.getWeapon(weaponID).getDmg();
		weaponINV.replace(weaponID,  weaponINV.get(weaponID) - 1);
		baseStats[3] -= gmInventory.getWeapon(equippedID).getDmg();
		addWeapon(equippedID);

		equippedID = weaponID;
	}
	public void addWeapon(int ID) {
		if(weaponINV.containsKey(ID)) {
			weaponINV.replace(ID, weaponINV.get(ID) + 1);
		} else {
			weaponINV.put(ID, 1);
		}
	}
	public void dropWeapon(int ID, int amount) {
		weaponINV.replace(ID, weaponINV.get(ID) - amount);
	}
	public void usePotion(int hpGain, int mpGain, int statGain) {
		charStats[4] += hpGain;
		if(charStats[4] > baseStats[0]) {
			charStats[4] = baseStats[0];
		}
		charStats[5] += mpGain;
		if(charStats[5] > baseStats[1]) {
			charStats[5] = baseStats[1];
		}
		sideStats[1] += statGain;
	}
	public void setEXP() {
		expCurve = new int[99];
		for(int i = 1; i < 100; i++) {
			expCurve[i - 1] = (int) Math.pow(i, 3);
		}
	}

}
