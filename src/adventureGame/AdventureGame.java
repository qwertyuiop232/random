package adventureGame;

import java.util.ArrayList;

public class AdventureGame {
	static ArrayList<room> tower = new ArrayList<room>();
    static gmInventory gameINV = new gmInventory();

	public static void main(String[] args) {
		Consumables hp10 = new Consumables("Small Health Potion", 10, 0, 0, 1,0);
		
		gameINV.addConsumable(hp10);
	}
}
