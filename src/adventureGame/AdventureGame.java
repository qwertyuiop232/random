package adventureGame;

import java.util.ArrayList;

public class AdventureGame {
	static ArrayList<room> tower = new ArrayList<room>();

	public static void main(String[] args) {
		consumables hp10 = new consumables("small health potion", 10, 0, 0, 1);
		items item1 = new items("",1);
		
		inventory.add(hp10);
		inventory.get(1).addItem(1);
		System.out.println(inventory.get(1).getQTY());

	}
}
