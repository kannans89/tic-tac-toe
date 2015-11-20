package com.techlabs.board;

import com.techlabs.player.Player;

public class Board {

	// Instance variables
	private char[][] board;
	private int noOfColumnsInBoard;
	private int noOfRowsInBoard;

	private int totalBoxes;

	// Constructor
	public Board(int row, int coloumn) {
		board = new char[row][coloumn];

	}

	// Methods
	public void setUp() {

		noOfRowsInBoard = board.length;

		if (noOfRowsInBoard > 0) {
			noOfColumnsInBoard = board[0].length;
		} else {
			System.out.println("*******************************************");
			System.out.println("ATTENTION !! ---> Require Atleast 1 Row");
			System.out.println("**---------------------------------------**");
		}

		
		  totalBoxes = noOfRowsInBoard * noOfColumnsInBoard;
		  
		  System.out.print("Rows : " + noOfRowsInBoard + "\t" + "Coloumns : " +
		  noOfColumnsInBoard + "\n"); System.out.println("Total no of Boxes : "
		  + totalBoxes);
		  
		for(int row = 0;row < noOfRowsInBoard;row++)
		 {
			 for(int coloumn = 0;coloumn < noOfColumnsInBoard;coloumn++){
				 board[row][coloumn] = '*';
			 }
		 }
		
	}

	public boolean isFull() {
		for (int row = 0; row < noOfRowsInBoard; row++) {
			for (int coloumn = 0; coloumn < noOfColumnsInBoard; coloumn++) {
				int valueOfElement = board[row][coloumn];
				if (valueOfElement == '*') {
					return false;
				}
			}
		}
		return true;
	}

	public boolean updateBoard(int rowToUpdate, int coloumnToUpdate,
			int playerSign) {

		boolean updated = false;
		if (board[rowToUpdate][coloumnToUpdate] == '*') {
			board[rowToUpdate][coloumnToUpdate] = (char) playerSign;
			updated = true;
		} else {
			System.out.println("Move Invalid\n");

		}
		return updated;

	}

	public boolean checkWin(Player currentPlayer) {
		boolean winResult = false;

		boolean winCheck1 = checkHorizontal(currentPlayer);
		boolean winCheck2 = checkVertical(currentPlayer);
		boolean winCheck3 = checkDigonal(currentPlayer);

		if (winCheck1 || winCheck2 || winCheck3) {
			winResult = true;
		}
		if (winResult) {
			System.out.println(currentPlayer.getPlayerName() + " Win's ");
		}
		return winResult;

	}

	// Horizontal
	public boolean checkHorizontal(Player currentPlayer) {
		boolean win = false;

		for (int row = 0; row < noOfRowsInBoard; row++) {
			if (rowcheck(row, currentPlayer)) {
				win = true;
			}
		}

		/*
		 * if ((board[0][0] == currentPlayer.getSign()) && (board[0][1] ==
		 * currentPlayer.getSign()) && (board[0][2]) == currentPlayer.getSign())
		 * { win = true; } else if ((board[1][0] == currentPlayer.getSign()) &&
		 * (board[1][1] == currentPlayer.getSign()) && (board[1][2]) ==
		 * currentPlayer.getSign()) { win = true; } else if ((board[2][0] ==
		 * currentPlayer.getSign()) && (board[2][1] == currentPlayer.getSign())
		 * && (board[2][2]) == currentPlayer.getSign()) { win = true; } else {
		 * win = false; }
		 */
		return win;
	}

	public boolean rowcheck(int row,Player currentPlayer){
		int coloumn =0;
		char mark = (char) currentPlayer.getSign();
		while(coloumn < noOfColumnsInBoard){
			if(mark == '*' || mark != board[row][coloumn] ){
				return false;
			}
			coloumn++;
		}
		return true;
	}

	// Vertical

	public boolean checkVertical(Player currentPlayer) {
		boolean win = false;
		
		for (int coloumn = 0; coloumn < noOfColumnsInBoard; coloumn++) {
			if (coloumncheck(coloumn, currentPlayer)) {
				win = true;
			}
		}
		/*if ((board[0][0] == currentPlayer.getSign())
				&& (board[1][0] == currentPlayer.getSign())
				&& (board[2][0]) == currentPlayer.getSign()) {
			win = true;
		} else if ((board[0][1] == currentPlayer.getSign())
				&& (board[1][1] == currentPlayer.getSign())
				&& (board[2][1]) == currentPlayer.getSign()) {
			win = true;
		} else if ((board[0][2] == currentPlayer.getSign())
				&& (board[1][2] == currentPlayer.getSign())
				&& (board[2][2]) == currentPlayer.getSign()) {
			win = true;
		} else {
			win = false;
		}
*/		return win;
	}
	public boolean coloumncheck(int coloumn,Player currentPlayer){
		int row =0;
		char mark = (char) currentPlayer.getSign();
		while(row < noOfRowsInBoard){
			if(mark == '*' || mark != board[row][coloumn] ){
				return false;
			}
			row++;
		}
		return true;
	}


	// Digonal

	public boolean checkDigonal(Player currentPlayer) {
		boolean win = false;
		
		if(firstDigonal(currentPlayer)||secondDigonal(currentPlayer)){
			win = true;
		}
		return win;
		
		/*if ((board[0][0] == currentPlayer.getSign())
				&& (board[1][1] == currentPlayer.getSign())
				&& (board[2][2]) == currentPlayer.getSign()) {
			win = true;
		} else if ((board[0][2] == currentPlayer.getSign())
				&& (board[1][1] == currentPlayer.getSign())
				&& (board[2][0]) == currentPlayer.getSign()) {
			win = true;
		} else {
			win = false;
		}
		return win;*/
	}
	public boolean firstDigonal(Player currentPlayer){
		int row=0;
		int coloumn=0;
		char mark = (char) currentPlayer.getSign();
		while(row < noOfRowsInBoard && coloumn < noOfColumnsInBoard){
			if(mark == '*' || mark!= board[row][coloumn]){
				return false;
			}
			row++;
			coloumn++;
		}
		return true;
	}
	public boolean secondDigonal(Player currentPlayer){
		int row=0;
		int coloumn=noOfColumnsInBoard-1;
		char mark = (char) currentPlayer.getSign();
		while(row < noOfRowsInBoard  && coloumn >= 0){
			if(mark == '*' || mark!= board[row][coloumn]){
				return false;
			}
			row++;
			coloumn--;
		}
		return true;
	}

	@Override
	public String toString() {
		for(char[] c : board){
			for(char a: c){
			System.out.print(a);
			System.out.print("\t");
			}
			System.out.println();
		}
		return "";
		
		/*return "\nTic-Tac-Toe Board :\n0  " + board[0][0] + "\t" + ""
				+ board[0][1] + "\t" + "" + board[0][2] + "\n1  " + ""
				+ board[1][0] + "\t" + "" + board[1][1] + "\t" + ""
				+ board[1][2] + "\n2  " + "" + board[2][0] + "\t" + ""
				+ board[2][1] + "\t" + "" + board[2][2] + "\n   0\t1\t2";*/
	}

}// end of Board Class
