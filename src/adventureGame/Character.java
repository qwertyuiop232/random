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
	String name;
	
	public Character(String name) {
		weaponINV = new HashMap<Integer,Integer>();
		consumableINV = new HashMap<Integer,Integer>();
		equipped = false;
		baseStats = new int[6]; 
		charStats = new int[6];
		sideStats = new int[4];
		// base stats hp, mana, dmg, defense, magic attack, magic defense, dodge chance, 
		//level, statPoints, exp,  gold
		// constitution, wisdom, strength, agility, statPoints, current hp, current mana
		
		// hp, mp, agility, resilience, wisdom, luck, style, deftness, charm, magical mending, magical might, attack, defense, evasion, block chance, strength
		Arrays.fill(baseStats, 0);
		Arrays.fill(charStats, 0);
		Arrays.fill(sideStats, 0);
		this.name = name;
		charStats[0] = 2;
		charStats[1] = 1;
		charStats[2] = 1;
		charStats[3] = 1;
		sideStats[0] = 1;
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
	private void constitution() {
		baseStats[0] = 15 * charStats[0]; // hp
		baseStats[3] = 1 * charStats[0]; // defense
		baseStats[5] = 1 * charStats[0]; // m. defense
		
	}
	private void strength() {
		baseStats[2] = 3 * charStats[2]; // dmg
		baseStats[6] = 1 * charStats[2]; // dodge chance
	}
	private void agility() {
		baseStats[6] = 3 * charStats[3]; // dodge chance
		baseStats[2] = 1 * charStats[3]; // dmg
	}
	private void wisdom() {
		baseStats[1] = 10* charStats[1]; // mana
		baseStats[4] = 2 * charStats[1]; // m. defense
		baseStats[5] = 4 * charStats[1]; // m.atk
	}

	public void equip(int weaponID) {
		// current goes to inv and weapon1 is equipped
		baseStats[3] += gmInventory.getWeapon(weaponID).getDmg();
		weaponINV.replace(weaponID,  weaponINV.get(weaponID) - 1);
		baseStats[3] -= gmInventory.getWeapon(equippedID).getDmg();
		addWeapon(equippedID, 1);

		equippedID = weaponID;
	}
	public void addWeapon(int ID,int amount) {
		if(weaponINV.containsKey(ID)) {
			weaponINV.replace(ID, weaponINV.get(ID) + amount);
		} else {
			weaponINV.put(ID, amount);
		}
	}
	public void dropWeapon(int ID, int amount) {
		weaponINV.replace(ID, weaponINV.get(ID) - amount);
	}
	public void addPotion(int ID, int amount) {
		if(consumableINV.containsKey(ID)) {
			consumableINV.replace(ID, consumableINV.get(ID) + amount);
		} else {
			consumableINV.put(ID, amount);
		}
	}
	public void dropPotion(int ID, int amount) {
		consumableINV.replace(ID, consumableINV.get(ID) - amount);
	}
	public void usePotion(int ID) {
		charStats[4] += gmInventory.getConsumable(ID).healthGain();
		if(charStats[4] > baseStats[0]) {
			charStats[4] = baseStats[0];
		}
		charStats[5] += gmInventory.getConsumable(ID).manaGain();
		if(charStats[5] > baseStats[1]) {
			charStats[5] = baseStats[1];
		}
		sideStats[1] += gmInventory.getConsumable(ID).statPoint();
		
		dropPotion(ID, 1);
	}

	public void gainEXP(int expGained) {
		sideStats[2] += expGained;
		if(sideStats[2] >= expCurve[sideStats[0] - 1]) {
			levelUp();
		}
	}
	private void levelUp() {
		sideStats[0] += 1;
		charStats[4] = baseStats[0];
		charStats[5] = baseStats[1];
		sideStats[1] += 5;
		addConstitution(1);
		addWisdom(1);
		addStrength(1);
		addAgility(1);
		gainEXP(0);
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
	public void setCharStats(int statType, int value) {
		charStats[statType] = value;
	}
	public void setBaseStats(int statType, int value) {
		baseStats[statType] = value;
	}
	public void setSideStats(int statType, int value) {
		sideStats[statType] = value;
	}
	public String getName() {
		return name;
	}
}
