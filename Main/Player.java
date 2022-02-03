package main;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		card.setLocation(1, 30 * hand.indexOf(card) + 1);
		
		add(card);
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
		
		JPanel currentVals = new JPanel();
		JLabel currentScoreLabel = new JLabel("Current Score: " + String.valueOf(currentScore));
		currentScoreLabel.setFont(new Font("Verdana",1,10));
		currentVals.add(currentScoreLabel);
		currentVals.setSize(100, 100);
		currentVals.setLocation(200, 200);
		add(currentVals);

		revalidate();
	}
}
