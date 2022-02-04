package blackJack;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
//import java.awt.Graphics;

public class Main extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;

	static Random rand = new Random();
	
	static ArrayList<Card> deck = new ArrayList<Card>();
	
	static ArrayList<Player> players = new ArrayList<Player>();

	int turn = 0;
	
	Main() {
		addKeyListener(this);
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.setTitle("House");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(1000, 500);
		main.setVisible(true);
		
		makeDeck();
		
		players.add(new Player("Player 1"));
		players.add(new Player("Winner?"));
		players.add(new Player("Mike"));
		
		main.toFront();
		main.requestFocus();
		
	}
	
	static void makeDeck() {
		for (int i = 1; i <= 52; i ++) {
			if (i < 14) {
				deck.add(new Card(i, "Spades"));
			} else if (i < 27) {
				deck.add(new Card(i%13 == 0 ? 13 : i % 13, "Clubs"));
			} else if (i < 40) {
				deck.add(new Card(i%13 == 0 ? 13 : i % 13, "Hearts"));
			} else if (i > 39) {
				deck.add(new Card(i%13 == 0 ? 13 : i % 13, "Diamonds"));
			}
		}
	}
	
	static Boolean takeTurn(Player player) {
		return giveCard(player, deck.get(rand.nextInt(deck.size())));
	}
	
	static Boolean giveCard(Player player, Card card) {
		deck.remove(deck.indexOf(card));
		return player.giveCard(card);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyChar() == KeyEvent.VK_SPACE) {
			if (deck.size() > 0) {
				while(!takeTurn(players.get(turn % players.size()))) {
					turn++;
				}
				turn++;
			}
		} else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

}
