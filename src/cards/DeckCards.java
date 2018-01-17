package cards;
// deck without jokers

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckCards {
	private int cardCounter;
	Card[] cardArr = new Card[52];

	
	public DeckCards() {
		int count = 0;

		
		for(int i = 1; i < 14; i++) {
			
			for(int j = 1; j < 5; j++) {
				cardArr[count] = new Card(i,j);
				count++;
			}
		}
		cardCounter = -1;
	}
	public void shuffle() {
		cardCounter = -1;
		// shuffles the cards
		Random random = new Random();
        int n = cardArr.length;
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(cardArr, i, change);
        }
        
	}
	/**
	 * implementation from shuffleArray class in Collections
	 * @param cardArr2
	 * @param i
	 * @param change
	 */
	private void swap(Card[] cardArr2, int i, int change) {
	        Card helper = cardArr[i];
	        cardArr[i] = cardArr[change];
	        cardArr[change] = helper;
	}
	/**
	 * shuffles deck if no more
	 * 
	 * @return card 
	 */
	public Card drawCard() {
		if(cardCounter < 52) {
			cardCounter++;
			return cardArr[cardCounter];
		} else {
			System.out.println("New deck");
			shuffle();
			cardCounter = -1;
			return cardArr[cardCounter];
		}
	}
	public void sort(ArrayList<Card> deck) {
		int i = 0;
		int j = deck.size() - 1;
		quicksort(i, j, deck);
		
	}
	   private void quicksort(int low, int high, ArrayList<Card> deck) {
	        int i = low, j = high;
	        // Get the pivot element from the middle of the list
	        int pivot = deck.get((low + high) / 2).getNumber();

	        // Divide into two lists
	        while (i <= j) {
	            // If the current value from the left list is smaller then the pivot
	            // element then get the next element from the left list
	            while (deck.get(i).getNumber() < pivot) {
	                i++;
	            }
	            // If the current value from the right list is larger then the pivot
	            // element then get the next element from the right list
	            while (deck.get(j).getNumber() > pivot) {
	                j--;
	            }

	            // If we have found a values in the left list which is larger then
	            // the pivot element and if we have found a value in the right list
	            // which is smaller then the pivot elment then we exchange the
	            // values.
	            if (i <= j) {
	                Collections.swap(deck, i, j);
	                i++;
	                j--;
	            }
	        }
	        // Recursion
	        if (low < j)
	            quicksort(low, j, deck);
	        if (i < high)
	            quicksort(i, high, deck);
	    }
}
