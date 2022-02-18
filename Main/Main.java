package blackJack;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class Main extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;

	static Random rand = new Random();
	
	static ArrayList<Card> deck = new ArrayList<Card>();
	
	static ArrayList<Player> players = new ArrayList<Player>();

	static int turn = 0;
	
	JLabel currentAction;
	String currentActionStr = "None";
	
	Main() {
		addKeyListener(this);
		
		
		JPanel currentThing = new JPanel();
		currentAction = new JLabel("Current Action: " + currentActionStr);
		currentAction.setFont(new Font("Verdana",1,10));
		currentThing.add(currentAction);
		currentThing.setSize(200, 100);
		currentThing.setLocation(200, 200);
		
		add(currentThing);
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
		players.add(new Player("Four"));
//		players.add(new Player("Five"));
		
		int i = 0;
		for (Player p : players) {
			p.setLocation(500*i, 520);
			p.giveCard(deck.get(rand.nextInt(deck.size())));
			p.giveCard(deck.get(rand.nextInt(deck.size())));
			i++;
		}
		
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
	
	
	
	static Boolean giveCard(Player player, Card card) {
		if (player.giveCard(card)) {
			deck.remove(deck.indexOf(card));
			return true;
		}
		return false;
	}
	
	static void CommitAction(String action) {
		if (action.equals("Hit")) {
			if (deck.size() > 0) {
				int attempt = 0;
				while(!giveCard(players.get(turn % players.size()), deck.get(rand.nextInt(deck.size())))) {
					attempt++;
					if (attempt == players.size()) break;
					turn++;
				}
				turn++;
			}
		} else if (action.equals("Pass")) {
			while(players.get(turn % players.size()).passed || players.get(turn % players.size()).busted) {
				turn++;
			}
			players.get(turn % players.size()).passed = true;
			players.get(turn % players.size()).setTitle("Passed");
			turn++;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("KeyCode: " + e.getKeyCode());
		
		if (e.getKeyChar() == KeyEvent.VK_SPACE) {
			CommitAction(currentActionStr);
		} else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getKeyChar() == 'h') {
			currentActionStr = "Hit";
		} else if (e.getKeyChar() == 'p') {
			currentActionStr = "Pass";
		}
		
		currentAction.setText("Current Action: " + currentActionStr);
		revalidate();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

}
