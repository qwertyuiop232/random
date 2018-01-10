package random;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * The program is an adventure game with an objective of solving puzzles in the house to find the keys to escape
 * 
 * @author V.Ko
 */
public class HelloWorld {
	static String[] roomNames;
	static String[] roomDescriptions;
	static int[][] roomDirections;
	static Boolean[] solved;
	static String[][] puzzleDescription;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("                                      THE ADVENTURE GAME");
		startGame();
	}
	
	private static void startGame() {
		
		printOutput("This is an escape room puzzle game. Solve all the puzzles in order to obtain the key to the front   door", 2);
		do {
			String game = getResponse("Do you wish to play?(yes/no)");
			if(game.equals("yes")) {
				break;
			} else if(game.equals("")) {
				return;
			}
		} while(true);
		setRooms("easy");
		navigate();
		System.out.println("Thanks for playing!!!");
	}
	
	/**
	 * A method that states current location, gets direction from user, and advances to the next room
	 * It controls the overall flow of the game
	 */
	public static void navigate() {
		int currentRoom = 0;
		boolean done = false;
		String input;
		
		puzzle(currentRoom);
		printOutput(roomDescriptions[currentRoom], 2);
		while(!done) {
			input = getResponse("(Inspect/Move/Quit) What will you do? ");
			if(input.equals("inspect")) {
				puzzle(currentRoom);
			} else if(input.equals("move")) {
				roomOptions(currentRoom);
				currentRoom = nextRoom(currentRoom);
				printOutput(roomDescriptions[currentRoom], 2);
			}else if(input.equals("quit")) {
				solved[12] = true;
				System.out.println("You hear a disappointed tsk before the speaker cuts off. Inside, you feel a bit remorseful and humiliated... as the house blows up");
			} 
			if(solved[12]) {
				done = true;
			}
		}
	}
	/**
	 * A method that takes in the int of the current room and calls upon the method to start the puzzle
	 * 
	 * @param currentRoom int of the value of the current room
	 */
	public static void puzzle(int currentRoom) {

		if(solved[currentRoom]) {
			printOutput(puzzleDescription[currentRoom][0], 2);
			String input = getResponse(puzzleDescription[currentRoom][1], puzzleDescription[currentRoom][2], puzzleDescription[currentRoom][3]);

			if(input.equals(puzzleDescription[currentRoom][2])) {
				solved[currentRoom] = false;
				solved[currentRoom + 1] = true;
			} else {
				printOutput(roomDescriptions[currentRoom], 2);
			}
			if(solved[8]) {
				roomDirections[1][3] = 9; 
			}
		} else {
			printOutput(puzzleDescription[currentRoom][4], 2);
		}

	}
	/**
	 * A method that checks for the next room and compares it with the direction that the user wishes to go
	 * and returns the room that the user will go, if applicable
	 * 
	 * @param currentRoom the int of the room number
	 * @return the int value of the next room
	 */
	public static int nextRoom(int currentRoom) {
		String input;
		int moved = -1;
		// System.out.println(roomDescriptions[currentRoom]);
		while(true) {
			moved = -1;
  
			input = getResponse("Where do you go? ");
			if (input.equals("north")) {
				moved = roomDirections[currentRoom][0];
			} else if (input.equals("east")) {
				moved = roomDirections[currentRoom][1];
			} else if (input.equals("south")) {	
				moved = roomDirections[currentRoom][2];
			} else if (input.equals("west")) {
				moved = roomDirections[currentRoom][3];
			} else if (input.equals("upstairs")) {
				moved = roomDirections[currentRoom][4];
			} else if (input.equals("downstairs")) {
				moved = roomDirections[currentRoom][5];
			} else if (input.equals("stay")) {
				return currentRoom;
			}
			if(moved != -1){
				return moved;
			} else {
				System.out.println("Invalid direction");
			}

		}

	}
	public static String getResponse(String prompt, String solution, String correct) {
		String input;

		do {
			input = getResponse(prompt);
			if(input.equals("quit") || input.equals("no")) {
				return "";
			}
			if(!input.equals(solution)) {
				System.out.println("Thats not the answer i'm looking for\nPlease try again! or (quit)");
			}

		} while(!input.equals(solution));
		printOutput(correct, 2);
		return input;
	}
	public static String getResponse(String prompt) {
		// printOutput("", -1);
		System.out.println(prompt); 
		System.out.print("\n>>>   ");
		return scan.nextLine().toLowerCase();
	}

	public static void roomOptions(int currentRoom) {
		String[] cardinalPoints = new String[] {"north", "east", "south", "west", "upstairs", "downstairs"};
		printOutput("", 1);
		for(int i = 0; i < 6; i++) {
			if(roomDirections[currentRoom][i] != -1) {
				printOutput("Enter (" + cardinalPoints[i] + ") to go to the " + roomNames[roomDirections[currentRoom][i]], 0);
			}
		}
		printOutput("Or you can (stay)", 0);
		printOutput("", -1);
		
	}
	public static void printOutput(String out, int displayType) {
		if(displayType == -1) {
			System.out.println("\n======================================================================================================");
		} else if(displayType == 0) {
			for(int i = 0; i < out.length() - 100; i += 100) {
				System.out.printf("\n|%-100s|" , out.substring(i, i + 100));
			}
			// prints out remaining text
			System.out.printf("\n|%-100s|" , out.substring(out.length() / 100 * 100, out.length() / 100 * 100 + out.length() % 100));
		}else if(displayType == 1) {
			System.out.print("\n======================================================================================================");
		}else if(displayType == 2) {
			printOutput(out, 1);
			printOutput(out, 0);
			printOutput(out, -1);
		}
	}
	/**
	 * A method that initializes the game and sets the room descriptions, names, directions, puzzles 
	 * and puzzle descriptions
	 * @param fileName the string of the file name 
	 * 
	 */
	public static void setRooms(String fileName) {
		roomNames = new String[12];
		roomNames[0] = "master bedroom";
		roomNames[1] = "work room";
		roomNames[2] = "library";
		roomNames[3] = "hallway";
		roomNames[4] = "guest bedroom";
		roomNames[5] = "kitchen";
		roomNames[6] = "balcony";
		roomNames[7] = "dining room";
		roomNames[8] = "treasure room";
		roomNames[9] = "hidden room";
		roomNames[10] = "main hallway";
		roomNames[11] = "front door";


		roomDescriptions = new String[12];
		
		roomDescriptions[0] = "Surrounding you is a regular old bedroom. There is a massive bed in front of you. This appears to bewhere you slept last night.";
		roomDescriptions[1] = "This is an unfamiliar work room. On the desk, papers are scattered about. You can smell a scent of  coffee";
		roomDescriptions[2] = "A musty old library. Seems like this owner never used it. The spines of the book are perfectly      straight";
		roomDescriptions[3] = "This seems like a regular old hall, except for the coffin-shaped light fixtures.";
		roomDescriptions[4] = "This is another bedroom. Weird paintings are hung up. All the pieces depict groteque images of      family members. Of course, you don't know enough art to understand it";
		roomDescriptions[5] = "Here is the kitchen. Quite a mess you see here. Pots and pans in the sink. Rotting fruits. The      stench almost seems solidified.";
		roomDescriptions[6] = "As you walk on the balcony, you notice a beautiful scenery; green trees, blue skies, even an        ocean...You start to wonder how you can find civilization again, but decide that you need to get outof this house first";
		roomDescriptions[7] = "A wonderful dining room. There is breakfast already set out. You see a large stack of pancakes with syrup on top. Your stomach growls at the sight of it, but you are hesitant as it may be tampered    with. ";
		roomDescriptions[8] = "Many treasure chests are strewn about this basement. You can see the glint of gold in it. Suddenly, the speaker comes to life and says… What’s the use of puzzles without a prize. Feel free to take anyof them… of course my most prized possession is an active bomb! An irritating laughter is heard in  the background";
		roomDescriptions[9] = "In the hidden room, you see an open window with a zipline attached. A microphone is set up in front of a large desk. There is a huge monitor displaying hidden cameras of all the rooms in the house.   There is a coffee mug that is still warm...";
		roomDescriptions[10] = "This is the main hallway. It is very beautifully designed. It emanates an archaic feeling. Oddly, a marble statue of a clown stares at you and you can't help but stare back";
		roomDescriptions[11] = "This is the front door; Your key to salvation, however,a giant padlock is placed on the handle.";
		
		// {north, east, south, west, up, down}
		roomDirections = new int[12][6];
		roomDirections[0] = new int[] {-1, 3, -1, 1, -1, -1};
		roomDirections[1] = new int[] {-1, 0, -1, -1, -1, -1};
		roomDirections[2] = new int[] {-1, 5, -1, -1, -1,-1};
		roomDirections[3] = new int[] {4, -1, -1, 0, -1, 10};
		roomDirections[4] = new int[] {-1, 6, 3, -1, -1, -1};
		roomDirections[5] = new int[] {-1, 7, 10, 2, -1,-1};
		roomDirections[6] = new int[] {-1, -1, -1, 4, -1, -1};
		roomDirections[7] = new int[] {-1, -1, -1, 5, -1, -1};
		roomDirections[8] = new int[] {-1, -1, -1, -1, 10, -1};
		roomDirections[9] = new int[] {-1, 1, -1, -1, -1,- 1};
		roomDirections[10] = new int[] {5, -1, 11, -1, 3, 8};
		roomDirections[11] = new int[] {10, -1,-1, -1, -1,-1};

		// initializing the puzzle states of the room
		solved = new Boolean[13];
		Arrays.fill(solved, false);
		solved[0] = true;
 
		puzzleDescription = new String[12][5]; 
		// first array is puzzle num, second array deals with {description, puzzle, solution ,follow up response, false inspection}
		
		puzzleDescription[0] = new String[] {"You wake up in an unfamiliar bedroom. Suddenly, the loudspeakers turn on. A creepy voice says \"LETS PLAY A GAME. The rules are simple. Just solve my questions hidden in each room. The prize is the keyto leave this house. ARE YOU READY? WELL TOO BAD. The game has already started\"", "For your first question, what is 1+1", "2", "The speaker opens again and the voice cackles \"WELL DONE! You passed preschool. However, getting outof the house is harder than that... HAHAHAHAH", "You look around the room but nothing catches your eye"};
		puzzleDescription[1] = new String[] {"You inspect the scattered sheets of the workroom and discover an envelope with a wax seal.", "Inside, is a cipher with a = x, and a sheet of paper that says \"sxccoh\" What does it mean?", "puzzle", "What a puzzling house indeed. The house contains a hint of absurdity and mysteriousness within it.  Maybe you can see if you can look up some information on it in the library", "You rummage through the papers but find nothing in particular; only old newspaper articles of a     failed clown"};
		puzzleDescription[2] = new String[] {"As you look through the books you see that they're all tragedy novels. Even the happiest book is    about a man who had a family that could afford coffins for his funeral. The speakers suddenly turn  on and it says, heres a hard question for you","The maker doesn’t want it, the buyer doesn’t use it and the user doesn’t know it. What is it? ", "coffin", "A whisper is heard, I've prepared yours too.. hehe. Come and find it", "You browse through some of the books but you sense that the tragedy novels are not important"};
		puzzleDescription[3] = new String[] {"As you inspect the coffin-shaped light fixtures you find a picture of a young girl with an older boyOn the back, it says...","There was a girl half my age when I was 12, now I am 64, how old is she?", "58", "The speakers turn  on and the voice says \"That was my cousin. You'll see a picture of him in my     guest bedroom\"", "The hall seems normal enough. Nothing to find."};
		puzzleDescription[4] = new String[] {"You find the painting of the picture, however, there is an eye-catching red \"X\" over the girl. It   smells faintly of tomato sauce. You take down the painting only to find a very crude painting of theMona Lisa. There is a blank tag where the painter should be.", "Who is the original painter?", "leonardo da vinci", "The voice says, \"I painted this copy myself. Aren't I sooooo good?\" You can't help but shake your   head in disgust", "As you walk around the room, you can't help but feel that the paintings are staring at you."};
		puzzleDescription[5] = new String[] {"There is a crumpled up piece of paper in the waste bin. You grudgingly reach for it. When you open  it up, you see a bunch of letters strung up together","The anagram is: \"lconbya\". Find out what this means", "balcony", "The voice guffaws, time to take away those extra hints! HAHAHA", "You try to comb through the countertop only to have the foul odour stick to you"};
		puzzleDescription[6] = new String[] {"While staring at the horizon, you get lost in thought, until the speakers turn on and the voice asks","How many days are there in 4 years? ", "1461", "Wow youre good at this. I gotta make it harder for you.", "You start to wonder if you can live after jumping down the balcony, but fear overtakes you, so you  decide not to jump."};
		puzzleDescription[7] = new String[] {"Your stomach continues to growl and you decide that you might as well eat something. You take a biteof the pancakes and immediately spit it out. It the syrup was actually soy sauce. However you       notice a sheet of paper inside the pancake. It says...", "There are three apples. If you take two away, how many apples do you have", "2", "HAHAHA GOOD WORK! I WAS HOPING TO CATCH YOU ON THAT. I would give you a gold coin, but I don't have any on me. What a shame.", "You look around but fear that you'll start eating the food on that table so you can't help but stop"};
		puzzleDescription[8] = new String[] {"When looking around the treasure chests, you see a single gold coin on top of a card. Beside it,    there is a lever. You read the card and it says \"Pull the lever Kronk\"", "Do you pull the lever?(yes/no)", "yes", "A loud rumbling sound fills the entire house. You faintly hear a voice yelling \"Wrong lever\".       Something must have happened", "You do not dare inspect out of fear for the bomb."};
		puzzleDescription[9] = new String[] {"In one of the drawers of the desk, you see a blueprint of a clown statue that seems really familiar", "Do you take it?(yes/no)", "yes", "At a closer look, you see that there is an empty space in the clown's balloon.", "The room smells strongly of coffee"};
		puzzleDescription[10] = new String[] {"You inspect the statue", "Do you open the statue?(yes/no)", "yes", "It opens up, and at last, there is the key", "No matter how much you look, the clown continues to be creepy"};
		puzzleDescription[11] = new String[] {"There it is. The final step out of this house.", "Do you unlock the door?", "yes", "You unlock it and step out for a breath of fresh air. Now you have an island to explore...", "This is a sturdy door made of mahogany"};
		
		scan = new Scanner(System.in);
	
	}
}