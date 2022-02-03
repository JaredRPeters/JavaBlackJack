package main;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JPanel{
	
	String[] above10 = {"Jack", "Queen", "King"};
	
	int val;
	String suit;
	
	Card(int val, String suit) {
		this.val = val;
		this.suit = suit;
		
		JLabel cardVal;
		
		if (val > 10) {
			cardVal = new JLabel(above10[val-11] + " of " + suit);
		} else {
			cardVal = new JLabel(val + " of " + suit);
		}
		cardVal.setFont(new Font("Verdana",1,10));
		setSize(100, 100);
		add(cardVal);
	}
	
	
	
}
