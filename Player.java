package cardgamewar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand = new ArrayList<>();
	private int score;

	public Player(String name) { // constructor 
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {//describe method 1.c.ii.1
		return "Player [name=" + name + ", hand=" + hand + ", score=" + getScore() + "]";
	}

	public void draw(Deck deck) {
		hand.add(deck.draw());

	}

	public int handSize() {
		return hand.size();
	}

	public Card flip() {
		return hand.remove(0);
	}

	public void incrementScore() {
		score = getScore() + 1;

	}
	public int getScore() {
		return score;
	}
}
