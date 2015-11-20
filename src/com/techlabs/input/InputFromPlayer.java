package com.techlabs.input;

import java.util.Scanner;

import com.techlabs.player.Player;

public class InputFromPlayer {
	// Instance Variables
	int row;
	int coloumn;

	// Input from PLAYER
	public int[] getInput(Player currentPlayer) {

		int[] inputData = new int[3];

		System.out.println(currentPlayer.getPlayerName() + " turn :- ");
		System.out.print("Enter Row :");			
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);		
		row = scan.nextInt();
		System.out.print("Enter Coloumn : ");
		coloumn = scan.nextInt();
		
		inputData[0] = row;
		inputData[1] = coloumn;
		inputData[2] = currentPlayer.getSign();
		// System.out.println("Row = "+inputData[0]+", Coloumn = "+inputData[1]+", Entered Sign = "+inputData[2]);

		return inputData;

	}
}
