package blackJack;

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
	
	JLabel currentScoreLabel;
	
	Player(String name) {
		this.name = name;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(name);
		setSize(500, 500);
		setLocation(1000, 500);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel currentVals = new JPanel();
		currentScoreLabel = new JLabel("Current Score: " + String.valueOf(currentScore));
		currentScoreLabel.setFont(new Font("Verdana",1,10));
		currentVals.add(currentScoreLabel);
		currentVals.setSize(100, 100);
		currentVals.setLocation(200, 200);
		add(currentVals);
	}
	
	void giveCard(Card card) {
		hand.add(card);
		card.setLocation(1, 30 * hand.indexOf(card) + 1);
		
		add(card);
		currentScore += card.val;
		
		currentScoreLabel.setText("Current Score: " + String.valueOf(currentScore));
		
		revalidate();
		
		if (currentScore > 21) {
			busted = true;
		} else if (currentScore == 21) {
			onScore();
		}

	}
	
	void onScore() {
		currentScoreLabel.setText("Current Score: " + String.valueOf(currentScore));
		revalidate();
		for (int i = 0; i < 10; i++) {
			setTitle(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setTitle("!!Hit 21!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
