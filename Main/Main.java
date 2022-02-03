package blackJack;

import java.util.Scanner;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;

public class Main extends JFrame implements KeyListener{

	static Scanner sc = new Scanner(System.in);package main;

import java.util.Scanner;

import java.util.ArrayList;
import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;

public class Main extends JFrame implements KeyListener{

	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<Card> deck = new ArrayList<Card>();
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.setTitle("House");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(1000, 500);
		main.setVisible(true);
		
		makeDeck();
		
		Player player1 = new Player("Player 1");
		
		
		sc.nextLine();
		giveCard(player1, deck.get(9));
		sc.nextLine();
		giveCard(player1, deck.get(10));
	}
	
	static void makeDeck() {
		for (int i = 1; i <= 56; i ++) {
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
	
	static void giveCard(Player player, Card card) {
		player.giveCard(card);
		deck.remove(deck.indexOf(card));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

}
	
	static ArrayList<Card> deck = new ArrayList<Card>();
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.setTitle("House");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(1000, 500);
		main.setVisible(true);
		
		makeDeck();
		
		Player player1 = new Player("Player 1");
		
		giveCard(player1, deck.get(9));
		sc.nextLine();
		giveCard(player1, deck.get(40));
	}
	
	static void makeDeck() {
		for (int i = 1; i <= 56; i ++) {
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
	
	static void giveCard(Player player, Card card) {
		player.giveCard(card);
		deck.remove(deck.indexOf(card));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

}
