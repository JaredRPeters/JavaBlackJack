package blackJack;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JPanel{
	
	int val;
	String suit;
	
	Card(int val, String suit) {
		this.val = val;
		this.suit = suit;
		
		JLabel label = new JLabel(val + " of " + suit);
		label.setFont(new Font("Verdana",1,10));
		add(label);
	}
	
	
	
}
