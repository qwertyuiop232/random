package adventureGame;

import java.util.Scanner;

public class AdventureGameOutline {
	static String[] roomNames;
	static String[] roomDescriptions;
	static int[][] roomDirections;
	
	public static void main(String[] args) {
		roomNames = new String[4]; // put num of rooms in brackets
		roomNames[0] = "Lower Hall"; // room name in quotes and room number in bracket
		roomNames[1] = ""; // room name
		roomNames[2] = ""; // room name
		roomNames[3] = ""; // room name

		roomDescriptions = new String[4]; // put num of rooms in brackets
		roomDescriptions[0] = "\"You are in the Lower Hall\". A bedroom is to the West and the Dining Room is to the East . You can also proceed to the North up the hallway"; // description of room in quotes and room num in brackets
		roomDescriptions[1] = ""; // description of room
		roomDescriptions[2] = ""; // description of room
		roomDescriptions[3] = ""; // description of room
		
		roomDirections = new int[4][4];
		roomDirections[0] = new int[] {-1,-1,-1,-1}; // room num in brackets  {room num to the north, room num to the east,room num to the south,room num to the west}
		roomDirections[1] = new int[] {-1,-1,-1,-1}; // room num in brackets  {room num to the north, room num to the east,room num to the south,room num to the west}
		roomDirections[2] = new int[] {-1,-1,-1,-1}; // room num in brackets  {room num to the north, room num to the east,room num to the south,room num to the west}
		roomDirections[3] = new int[] {-1,-1,-1,-1}; // room num in brackets  {room num to the north, room num to the east,room num to the south,room num to the west}
		
		navigate();
	}

	public static void navigate() {
		int currentRoom = 0;
		int nextRoom = -1;
		String userSelectedRoom;
		boolean done = false;
		Scanner scan = new Scanner(System.in);
		
		while(!done) {
			System.out.println("This is the " + roomNames[currentRoom]);
			System.out.println(roomDescriptions[currentRoom]);

			// checks if the user entered a valid direction and moves there
			nextRoom = -1;
			while(nextRoom == -1) {
				System.out.println("Where to go?");
				userSelectedRoom = scan.nextLine();
				if (userSelectedRoom.equals("north") || userSelectedRoom.equals("n")) {
					nextRoom = roomDirections[currentRoom][0];
				} else if (userSelectedRoom.equals("east") || userSelectedRoom.equals("e")) {
					nextRoom = roomDirections[currentRoom][1];
				} else if (userSelectedRoom.equals("south") || userSelectedRoom.equals("s")) {	
					nextRoom = roomDirections[currentRoom][2];
				} else if (userSelectedRoom.equals("west") || userSelectedRoom.equals("w")) {
					nextRoom = roomDirections[currentRoom][3];
				} 
				if(nextRoom == -1) {
					System.out.println("Invalid Direction");
				}
			}
			// set a condition for the game to end
			if(currentRoom == 3) {
				done = true;
			}
			
		}		
		scan.close();
	}
}
