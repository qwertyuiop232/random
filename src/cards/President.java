package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class President {
	static int numPlayer;
	static ArrayList<Card> play1 = new ArrayList<>();
	static ArrayList<Card> play2 = new ArrayList<>();
	static ArrayList<Card> play3 = new ArrayList<>();
	static ArrayList<Card> play4 = new ArrayList<>();
	static ArrayList<Card> play5 = new ArrayList<>();
	static ArrayList<Card> play6 = new ArrayList<>();
	static ArrayList<ArrayList<Card>> totPlayers = new ArrayList<>();
	static DeckCards deck;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter number of players");
		numPlayer = -1;
		
		while(numPlayer < 2 || numPlayer > 6) {

			numPlayer = scan.nextInt();
		}
		init();
		deal();
		play();
	}
	private static void play() {
		int currentTurn = 0;
		ArrayList<Card> table = new ArrayList<>();
		boolean[] passed = new boolean[numPlayer];
		int passCounter;
		while(totPlayers.size() > 1 ) {
			System.out.println("Player" + (currentTurn + 1) + "'s turn");
			System.out.println("You have:\n");
			deck.sort(totPlayers.get(currentTurn));
			for (int i = 0; i < totPlayers.get(currentTurn).size(); i++) {
				System.out.println(Integer.toString(i + 1) + ". " + totPlayers.get(currentTurn).get(i).getString());
			}
			try {
				putCard(table, currentTurn, passed);
			} catch (IndexOutOfBoundsException e){
				continue;
			}
			if(currentTurn + 1 == numPlayer) {
				currentTurn = -1;
			}
			currentTurn++;
			if(totPlayers.get(currentTurn).isEmpty()) {
				totPlayers.remove(totPlayers.get(currentTurn));
				table.clear();
				System.out.println("Wiped the tables");
			}
			while(passed[currentTurn]) {
				int count = 0;
				currentTurn++;
				if(count == totPlayers.size() - 1) {
					table.clear();
					System.out.println("Wiped the tables");
				}
				Arrays.fill(passed, false);
				count++;
			}

		}
	}
	
	private static void putCard(ArrayList<Card> table, int currentTurn, boolean[] passed) {
		boolean valid = false;
		while(!valid) {
			int in1 = 0, in2 = 0, in3 = 0, in4 = 0;
			System.out.println("What will you play? (use num)");
			if(scan.hasNextInt()) {
				in1 = scan.nextInt();
				if(table.isEmpty() && totPlayers.get(currentTurn).size() - in1 > 1) {
					table.add(totPlayers.get(currentTurn).get(in1 - 1));
					totPlayers.get(currentTurn).remove(in1 - 1);
					out(table);
					valid = true;
				} else if(table.size() == 1 && (table.get(0).getNumber() < totPlayers.get(currentTurn).get(in1 -1).getNumber() ) ) {
					table.remove(0);
					table.add(totPlayers.get(currentTurn).get(in1 - 1));
					totPlayers.get(currentTurn).remove(in1 - 1);
					out(table);
					valid = true;
				}else if(table.size() == 1 && table.get(0).getNumber() == totPlayers.get(currentTurn).get(in1 -1).getNumber() && table.get(0).getSuit() < totPlayers.get(currentTurn).get(in1 - 1).getSuit()) {
					table.remove(0);
					table.add(totPlayers.get(currentTurn).get(in1 - 1));
					totPlayers.get(currentTurn).remove(in1 - 1);
					out(table);
					valid = true;
				}
			} else if(scan.hasNextLine()){
				if(scan.nextLine().equals("pass")) {
					passed[currentTurn] = true;
					valid = true;
				} else if(scan.nextLine().contains("and")) {
					int num = 1;
					
				}
			}else {
				System.out.println("invalid");
				continue;
			}
		}		
	}
	private static void out(ArrayList<Card> table) {
		for(int i = 0; i < table.size(); i++) {
			System.out.println("There is " + table.get(i).getString() + " on the table");
		}
	}
	private static void deal() {
		deck.shuffle();
		int cards = 52 / numPlayer;
		int extra = 52 % numPlayer;
		
		for(int i = 0; i < numPlayer; i++) { 
			
			for(int j = 0; j < cards; j++) {
				totPlayers.get(i).add(deck.drawCard());
			}
			if(extra > 0) {
				totPlayers.get(i).add(deck.drawCard());
				extra--;
			}
		}
		
	}
	private static void init() {
		int count = numPlayer;
		
		totPlayers.add(play1);
		totPlayers.add(play2);
		totPlayers.add(play3);
		totPlayers.add(play4);
		totPlayers.add(play5);
		totPlayers.add(play6);
		for(int i = 5; i > count -1; i--) {
			totPlayers.remove(i);
		}
		deck = new DeckCards();
		deck.shuffle();
	}
}
