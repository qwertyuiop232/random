package adventureGame;

import java.util.ArrayList;

public class gmInventory {
	static ArrayList<Weapons> weaponINV = new ArrayList<Weapons>();
	static ArrayList<Consumables> consumableINV = new ArrayList<Consumables>();

	public static Weapons getWeapon(int ID) {
		
		for(int i = 0; i < weaponINV.size(); i++) {
			if(weaponINV.get(i).getID() == ID) {
				return weaponINV.get(i);
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
	public static Consumables getConsumables(int ID) {
		
		for(int i = 0; i < consumableINV.size(); i++) {
			if(consumableINV.get(i).getID() == ID) {
				return consumableINV.get(i);
			}
		}
		return null;
		
	}
	public void addConsumable(Consumables potion) {
		consumableINV.add(potion);
	}
	public void addWeapon(Weapons weapon) {
		weaponINV.add(weapon);
	}
}
