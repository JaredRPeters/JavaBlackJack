package main;

import javax.swing.JFrame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Component;
import java.awt.Dimension;

public class Player extends JFrame{
	private static final long serialVersionUID = 1L;
	
	String name;
	
	Player(String name) {
		this.name = name;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		int prefferedWidth = 500;
		int prefferedHeight = 500;
		
		Player player = new Player("Player 1");
		
		player.addComponentListener (new ComponentAdapter() 
		{  
		        public void componentResized(ComponentEvent evt) {
		            Component c = (Component)evt.getSource();
		            System.out.println(player.getWidth());
		            System.out.println(player.getWidth() > prefferedWidth);
		            if (player.getWidth() > prefferedWidth) {
		            	player.setResizable(false);
		            	player.setPreferredSize(new Dimension(prefferedWidth, player.getHeight()));
		            	player.setResizable(true);
		            }
		        }
		});
	}
}
