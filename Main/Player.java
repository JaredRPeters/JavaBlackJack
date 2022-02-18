package blackJack;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player extends JFrame{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Card> hand = new ArrayList<Card>();	
	String name;
	int currentScore = 0;
	boolean busted = false;
	boolean passed = false;
	boolean hit21 = false;
	
	int preferedWidth = 500;
	int preferedHeight = 500;
	
	JLabel currentScoreLabel;
	
	Thread alterName = new Thread(() -> {
		while(!busted) {
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
		while(busted) {
			if (!getName().equals("Busted")) {
				setTitle("Busted");
				break;
			}
		}
	});
	
	Player(String name) {
		this.name = name;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(name);
		setSize(500, 500);
		setLocation(0, 520);
		setResizable(false); 
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel currentVals = new JPanel();
		currentScoreLabel = new JLabel("Current Score: " + String.valueOf(currentScore));
		currentScoreLabel.setFont(new Font("Verdana",1,10));
		currentVals.add(currentScoreLabel);
		currentVals.setSize(200, 100);
		currentVals.setLocation(200, 200);
		add(currentVals);
	}
	
	Player() {
		//for var hold
	}
	
	Boolean giveCard(Card card) {
		
		if (passed) {
			revalidate();
			return false;
		}
		
		if (!busted && !hit21) {
			revalidate();
			return false;
		}
		
		hand.add(card);
		card.setLocation(card.cardWidth * hand.indexOf(card), this.getHeight() - (int)(card.cardHeight*(1.3f)));
		
		add(card);
		card.repaint();
		currentScore += card.val;
		
		currentScoreLabel.setText("Current Score: " + String.valueOf(currentScore));
		
		revalidate();
		
		if (currentScore > 21) {
			busted = true;
			setTitle("Busted");
		} else if (currentScore == 21) {
			hit21 = true;
			if (!alterName.isAlive()) {
				alterName.start();
			} else {
				alterName.interrupt();
			}
		} else {
			setTitle(name);
		}
		revalidate();
		return true;
	}
}
