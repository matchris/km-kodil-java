package com.kodilla.game;

import javafx.scene.image.Image;

public class DiceImage {
    Image pic1 = new Image("file:kodilla-game/src/main/resources/dice/dice-1.png");
    Image pic2 = new Image("file:kodilla-game/src/main/resources/dice/dice-2.png");
    Image pic3 = new Image("file:kodilla-game/src/main/resources/dice/dice-3.png");
    Image pic4 = new Image("file:kodilla-game/src/main/resources/dice/dice-4.png");
    Image pic5 = new Image("file:kodilla-game/src/main/resources/dice/dice-5.png");
    Image pic6 = new Image("file:kodilla-game/src/main/resources/dice/dice-6.png");

    private Image diceImage;

    public void setImage(int sides) {

        switch (sides) {
            case 1:
                diceImage = pic1;
            case 2:
                diceImage = pic2;
            case 3:
                diceImage = pic3;
            case 4:
                diceImage = pic4;
            case 5:
                diceImage = pic5;
            default:
            case 6:
                diceImage = pic6;
        }

    }

    public Image getImage() {
        return diceImage;
    }
}
