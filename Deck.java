package cardgamewar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Integer> cardValues = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
	private List<String> cardSuits = List.of("Spade", "Heart", "Diamond", "Clover"); 


	private List<Card> cards;

	public Deck() { 
		createDeck(); 
	}

	private void createDeck() {
		cards = new ArrayList<>();
		for(int cardValuePos = 0; cardValuePos < cardValues.size(); cardValuePos++) { 
			int rank = cardValuePos + 1; 
			Integer cardValue = cardValues.get(cardValuePos);
			for(String cardSuit : cardSuits) {
				cards.add(new Card(cardValue, cardSuit, rank)); 
			}
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Deck:\n");

		for(Card card : cards) { //could use "this" in replacement of cards
			builder.append("  ").append(card).append("\n");
		}
		return builder.toString();
	}

	public void shuffle() {
		Random random = new Random();

		List<Card> temp = new LinkedList<>(cards);
		cards.clear();

		while(!temp.isEmpty()) {
			int pos = random.nextInt(temp.size());
			cards.add(temp.remove(pos)); //
		}

	}
	public int size() {
		return cards.size(); //return the size of the card
	}

	public Card draw() {
		return cards.remove(0);
	}
}



