package com.kodilla.game;

import java.util.Random;

public class Dice {

    public static int getResult() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
