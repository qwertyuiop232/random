package adventureGame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdventureGame {
	static ArrayList<Rooms> tower = new ArrayList<Rooms>();
	int currentFloor;
	boolean done;
	

	public static void main(String[] args) {

		setItems();
		expChart();
	}
	private static void expChart() {
		ArrayList<int[]> expCurve = new ArrayList<int[]>();
		expCurve = load("expChart", expCurve);
		Character.expCurve = expCurve.get(0);
	}
	private static void setItems() {
		gmInventory.addConsumable(new Consumables("Small Health Potion", 30, 0, 0, 8, 1)); // name, healt, mana, stat, cost ,id
		gmInventory.addConsumable(new Consumables("Medium Health Potion", 60, 0, 0, 50,2));
		gmInventory.addConsumable(new Consumables("Large Health Potion", 100, 0, 0, 70, 3));
		gmInventory.addConsumable(new Consumables("Small Mana Potion", 0, 5, 0, 10, 4));
		gmInventory.addConsumable(new Consumables("Medium Mana Potion", 0, 20, 0, 30, 5));
		gmInventory.addConsumable(new Consumables("Large Mana Potion", 0, 50, 0, 100, 6));
		gmInventory.addConsumable(new Consumables("Lesser Panacea", 50, 20, 0, 100, 8));
		gmInventory.addConsumable(new Consumables("Greater Panacea", 100, 100, 0, 300, 9));
		gmInventory.addConsumable(new Consumables("Game Master's Health Potion", 100000, 0, 0, 2500, 10));
		gmInventory.addConsumable(new Consumables("Game Master's Mana Potion", 0, 100000, 0, 2500, 11));
		gmInventory.addConsumable(new Consumables("Game Master's Panacea", 100000, 100000, 0, 10000, 12));

		gmInventory.addConsumable(new Consumables("Special Potion", 0, 0, 1, 100, 7));

		gmInventory.addWeapon(new Weapons("Knuckles", 1, 10, 0, 0)); // name, dmg, durability, cost, id
		gmInventory.addWeapon(new Weapons("Knife", 3, 10, 10, 13));
		gmInventory.addWeapon(new Weapons("Rusty Sword", 5, 10, 30, 14));
		gmInventory.addWeapon(new Weapons("Rusty Sword", 5, 10, 30, 14));
		gmInventory.addWeapon(new Weapons("Rusty Sword", 5, 10, 30, 14));
		gmInventory.addWeapon(new Weapons("Victor's Super Sword", 1000, -1, 100000, 100));

	}
	public static void save(String fileName, ArrayList<int[]> puzzles) throws IOException {
		try {
		FileOutputStream fileStream = new FileOutputStream(fileName);
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
		objectStream.writeObject(puzzles);
		objectStream.close();   
		fileStream.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static ArrayList<int[]> load(String fileName, ArrayList<int[]> roomArray) {
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream(fileName);
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			roomArray = (ArrayList<int[]>) objectStream.readObject();
			objectStream.close();
			fileStream.close();
		} catch (IOException e) {
			System.out.println("File not found");
		} catch (ClassNotFoundException e) {
			System.out.println("File not found");
		}
		return roomArray;

	}
}
