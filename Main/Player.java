package blackJack;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Player extends JFrame{
	
	ArrayList<Card> hand = new ArrayList<Card>();	
	String name;
	int currentScore = 0;
	boolean busted = false;
	
	int preferedWidth = 500;
	int preferedHeight = 500;
	
	Player(String name) {
		this.name = name;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(name);
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
	}
	
	void giveCard(Card card) {
		hand.add(card);
		card.setSize(100, 100);
		card.setLocation(1, 10 * hand.indexOf(card) + 1);
		add(card);
		System.out.println(name + " gained " + card.val + card.suit);
		currentScore = 0;
		for (Card c : hand) {
			currentScore += c.val;
		}
		if (currentScore > 21) {
			busted = true;
			System.out.println(name + " busted with " + currentScore);
		} else if (currentScore == 21) {
			System.out.println("Victory for " + name);
		}
	}
}
