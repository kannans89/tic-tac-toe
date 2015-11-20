package com.techlabs.player;


public class Player {
	// instance variables
	private String playerName;
	private int playerSignNumber;

	public Player(String name, char sign) {
		playerName = name;
		playerSignNumber = sign;
	}

	public int getSign() {
		return playerSignNumber;
	}

	public String getPlayerName() {
		return playerName;
	}

}
