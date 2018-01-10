package random;

public class LetterTest {
	public static void main(String[] args) {
		String[] roomDescriptions = new String[12];
		roomDescriptions[0] = "Surrounding you is a regular old bedroom. There is a massive bed in front of you. This appears to bewhere you slept last night.";
		roomDescriptions[1] = "This is an unfamiliar work room. On the desk, papers are scattered about. You can smell a scent of  coffee";
		roomDescriptions[2] = "A musty old library. Seems like this owner never used it. The spines of the book are perfectly      straight";
		roomDescriptions[3] = "This seems like a regular old hall, except for the coffin-shaped light fixtures.";
		roomDescriptions[4] = "This is the guest bedroom. Weird paintings are hung up. All the pieces depict groteque images of    family members. Of course, you don't know enough art to understand it";
		roomDescriptions[5] = "Here is the kitchen. Quite a mess you see here. Pots and pans in the sink. Rotting fruits. The      stench almost seems solidified.";
		roomDescriptions[6] = "As you walk on the balcony, you notice a beautiful scenery; green trees, blue skies, even an        ocean...You start to wonder how you can find civilization again, but decide that you need to get outof this house first";
		roomDescriptions[7] = "A wonderful dining room. There is breakfast already set out. You see a large stack of pancakes with syrup on top. Your stomach growls at the sight of it, but you are hesitant as it may be tampered    with. ";
		roomDescriptions[8] = "Many treasure chests are strewn about this treasure room. You can see the glint of gold in it.      Suddenly, the speaker comes to life and says… What’s the use of puzzles without a prize. Feel free  to take any of them… of course my most prized possession is an active bomb! An irritating laughter  is heard in the background";
		roomDescriptions[9] = "In the hidden room, you see an open window with a zipline attached. A microphone is set up in front of a large desk. There is a huge monitor displaying hidden cameras of all the rooms in the house.   There is a coffee mug that is still warm...";
		roomDescriptions[10] = "This is the main hallway. It is very beautifully designed. It emanates an archaic feeling. Oddly, a marble statue of a clown stares at you and you can't help but stare back";
		roomDescriptions[11] = "This is the front door; Your key to salvation, however,a giant padlock is placed on the handle.";
	for(int i =0; i <12;i++) {
		printOutput(roomDescriptions[i], 2);

	}
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
}
