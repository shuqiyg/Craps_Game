/********************************************** 
Workshop # 1
Course: JAC433
Last Name:Yang
First Name:Shuqi
ID:132162207
Section:NBB 
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature 
Date:2022-01-23
**********************************************/ 
import java.util.Scanner;

public class Craps {
	private int[] winArr = {3, 11};
	private int[] lossArr = {2, 4, 10};
	private int[] pointVals = {5, 6, 7, 8, 9, 12};
	int estPoint;
	
	public static void main(String[] args) {
		Craps crapGame = new Craps();
		System.out.println("Please Press the Start to initiate the game.");
		Scanner input = new Scanner(System.in);
		String readInput = input.nextLine();
		input.close();
		crapGame.playGame();
	}
	
	public void playGame() {
		boolean exit = false;
		while(!exit) {
			int value = rollDice();
			for(int i: winArr) {
				if(value == i) {
					System.out.println("Naturals! Congradulations, You win!");
					exit = true;
					return;
				}
			}
			for(int i: lossArr) {
				if(value == i) {
					System.out.println("Craps, Better Luck Next Time, You Lose!");
					return;
				}
			}
			for(int i: pointVals) {
				if(value == i) {
					estPoint = value;
					System.out.println("Point is (established) set to " + estPoint);
					while(!exit) {
						value = rollDice();
					     if(value == 7) {
							System.out.println("Craps, Better Luck Next Time, You Lose!");
							return;
						}else if(value == estPoint) {
							System.out.println("Naturals! Congradulations, You win!");
							return;
						}
					}
				}
			}
		}
	}

	private int rollDice() {
		int d1 = genRandomSum();
		int d2 = genRandomSum();
		int sum = d1 + d2;
		System.out.println("You rolled " + d1 + " + " + d2 + " = " + sum);
		return sum;	
 	}
	
	private int genRandomSum() {
		return (int)(Math.random()*6 + 1);
	}
}
