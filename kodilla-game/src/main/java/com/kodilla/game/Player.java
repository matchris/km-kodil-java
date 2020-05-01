package com.kodilla.game;

public class Player {
    public String name;
    public int playerNumber;

    Player(){
    }

    Player(String name, int playerNumber) {
        this.playerNumber = playerNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}
