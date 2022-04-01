package cardgamewar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
	List<String> names = List.of("Bob", "Linda", "Tina", "Gene", "Louise");

	private Random random = new Random();

	public static void main(String[] args) {
		new App().playTheGame();

	}

	private void playTheGame() { //new instance
		List<String> playerNames = new LinkedList<>(names);
		Player player1 = findPlayer(playerNames);
		Player player2 = findPlayer(playerNames);
		Deck deck = new Deck();

		System.out.println(player1.getName() + " is playing " + player2.getName());
		shuffleDeck(deck);
		dealTheCards(player1, player2, deck);
		playTheGame(player1, player2);
		determineWinner(player1, player2);

	}

	private void determineWinner(Player player1, Player player2) {
		Player winner = null;
		Player loser = null;

		if (player1.getScore() > player2.getScore()) {
			winner = player1;
			loser = player2;
		}
		else if (player2.getScore() > player1.getScore()) {
			winner = player2;
			loser = player1;
		}
		if (winner == null) {
			System.out.println("It's a tie!");
		}
		else {
			System.out.println("The winner is " + winner.getName() + " with a score of " + winner.getScore() + ".");

			System.out.println("The loser is " + loser.getName() + " with a score of " + loser.getScore() + ".");
		}
	}

	private void playTheGame(Player player1, Player player2) {
		//step 5 half deck size
		int deckSize = player1.handSize() + player2.handSize();
		//System.out.println(player1.handSize());
		//System.out.println("deck=" + deckSize); //Total number of cards

		for (int playNum = 0; playNum < deckSize / 2; playNum++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();

			if (card1.getRank() > card2.getRank()) {
				player1.incrementScore();
			}
			else if (card2.getRank() > card1.getRank()) {
				player2.incrementScore();
			}
		}
	}

	private void dealTheCards(Player player1, Player player2, Deck deck) {
		//step 4
		int deckSize =  deck.size();

		for (int pos = 0; pos  < deckSize; pos++) {
			if (pos % 2 == 0) {
				player1.draw(deck);
			}
			else {
				player2.draw(deck);
			}
		}

	}

	private void shuffleDeck(Deck deck) {
		deck.shuffle();

	}

	private Player findPlayer(List<String> names) {
		int pos = random.nextInt(names.size()); 
		String name = names.remove(pos); //this removes the names so a player isn't playing against themselves
		return new Player(name);
	}

}
