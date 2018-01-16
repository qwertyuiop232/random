package adventureGame;

import java.util.ArrayList;

public class gmInventory {
	static ArrayList<Weapons> weaponINV = new ArrayList<Weapons>();
	static ArrayList<Consumables> consumableINV = new ArrayList<Consumables>();
	static ArrayList<Enemy> enemyINV = new ArrayList<Enemy>();
	static ArrayList<Rooms> roomINV = new ArrayList<>();

	public static Weapons getWeapon(int ID) {
		
		for(int i = 0; i < weaponINV.size(); i++) {
			if(weaponINV.get(i).getID() == ID) {
				return weaponINV.get(i);
			}
		}
		return null;
		
	}
	public static Rooms getRoom(int ID) {
		
		for(int i = 0; i < roomINV.size(); i++) {
			if(roomINV.get(i).getID() == ID) {
				return roomINV.get(i);
			}
		}
		return null;
		
	}
	public static Enemy getEnemy(int ID) {
		
		for(int i = 0; i < weaponINV.size(); i++) {
			if(enemyINV.get(i).getID() == ID) {
				return enemyINV.get(i);
			}
		}
		return null;
		
	}
	public static Consumables getConsumable(int ID) {
		
		for(int i = 0; i < consumableINV.size(); i++) {
			if(consumableINV.get(i).getID() == ID) {
				return consumableINV.get(i);
			}
		}
		return null;
		
	}
	public static void addConsumable(Consumables potion) {
		consumableINV.add(potion);
	}
	public static void addWeapon(Weapons weapon) {
		weaponINV.add(weapon);
	}
	public static void addEnemy(Enemy enemy) {
		enemyINV.add(enemy);
	}
}
