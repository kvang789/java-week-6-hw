package cardgamewar;

import java.util.Collection;
import java.util.List;

public class Card {
	private int cardValue;
	private String cardSuit;
	private int rank; 

	public Card(int cardValue, String cardSuit, int rank) {
		this.cardValue = cardValue;
		this.cardSuit = cardSuit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return cardValue + " of " + cardSuit; 
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getCardValue() { 
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;

	}

}


