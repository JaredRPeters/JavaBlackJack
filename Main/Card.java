package blackJack;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Card extends JPanel{
	private static final long serialVersionUID = 1L;

	String[] above10 = {"Jack", "Queen", "King"};
	
	int val;
	String suit;
	
	public int cardWidth = 100;
	public int cardHeight = 200;
	
	int borderDepth = 3;
	
	String cardVal;
	
	Card(int val, String suit) {
		setSize(cardWidth, cardHeight);
		
		this.val = val;
		this.suit = suit;
		
		if (val > 10) {
			cardVal = above10[val-11] + " of " + suit;
		} else if (val == 1){
			cardVal = "Ace of " + suit;
		}else {
			cardVal = val + " of " + suit;
		}
		
		if (this.val > 10) {
			this.val = 10;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, cardWidth, cardHeight);
		g.setColor(Color.RED);
		g.fillRect(borderDepth, borderDepth, cardWidth-borderDepth*2, cardHeight-borderDepth*2);
		g.setColor(Color.BLACK);
		g.drawString(cardVal, 4, cardHeight/2);
	}
	
}
