package com.kodilla.game;

import javafx.scene.image.Image;

class Pawn implements GameFigure {
    private FigureColor color;
    private String yp = "file:kodilla-game/src/main/resources/Pawns/yellowPawn.png";
    private String bp = "file:kodilla-game/src/main/resources/Pawns/bluePawn.png";
    private String gp = "file:kodilla-game/src/main/resources/Pawns/greenPawn.png";
    private String rp = "file:kodilla-game/src/main/resources/Pawns/redPawn.png";

    private String ypbhs = "file:kodilla-game/src/main/resources/Pawns/yellow80x80.png";
    private String bpbhs = "file:kodilla-game/src/main/resources/Pawns/blue80x80.png";
    private String gpbhs = "file:kodilla-game/src/main/resources/Pawns/green80x80.png";
    private String rpbhs = "file:kodilla-game/src/main/resources/Pawns/red80x80.png";
    public Pawn(FigureColor color) {
        this.color = color;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public Image getImage() {
        if (color == FigureColor.BLUE)
            return new Image(bp);
        else if (color == FigureColor.GREEN)
            return new Image(gp);
        else if (color == FigureColor.RED)
            return new Image(rp);
        else if (color == FigureColor.YELLOW)
            return new Image(yp);
        return null;
    }

    @Override
    public Image getImageBHS() {  //
        if (color == FigureColor.BLUE)
            return new Image(bpbhs);
        else if (color == FigureColor.GREEN)
            return new Image(gpbhs);
        else if (color == FigureColor.RED)
            return new Image(rpbhs);
        else if (color == FigureColor.YELLOW)
            return new Image(ypbhs);
        return null;
    }

    @Override
    public String toString() {
        switch (color) {
            case YELLOW:
                return "Y";
            case BLUE:
                return "B";
            case GREEN:
                return "G";
            case RED:
                return "R";
            case NONE:
                return " ";
        }
        return " ";
    }
}
