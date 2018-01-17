package cards;

public class Card {
	private int number;
	private int suit;
	
	public Card(int number, int suit) {
		this.number = number;
		this.suit = suit;
	}
	public int getNumber() {
		return number;
	}
	public int getSuit() {
		return suit;
	}
	public String getString() {
		String card = "";
		switch(number) {
		case 1: card += "Ace of";
		break;
		case 2: card += "Two of";
		break;
		case 3: card += "Three of";
		break;
		case 4: card += "Four of";
		break;
		case 5: card += "Five of";
		break;
		case 6: card += "Six of";
		break;
		case 7: card += "Seven of";
		break;
		case 8: card += "Eight of";
		break;
		case 9: card += "Nine of";
		break;
		case 10: card += "Ten of";
		break;
		case 11: card += "Jack of";
		break;
		case 12: card += "Queen of";
		break;
		case 13: card += "King of";
		break;
		default: break;
		}
		switch(suit) {
		case 1: card += " diamonds";
		break;
		case 2: card += " clubs";
		break;
		case 3: card += " hearts";
		break;
		case 4: card += " spades";
		break;
		default: break;
		}
		return card;
		
	}
	
}
