package main;

import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		int price = 0;
		
		int currentLevel = sc.nextInt();
		int goal = sc.nextInt();
		
		for (int i = currentLevel-1; i < goal; i++) {
			int currentCost = i / 5 + 1;
			
			price += currentCost;
			
			System.out.println((i+1) + " - " + currentCost);
		}
		
		System.out.println("Final Price: " + price);
		
	}
}
