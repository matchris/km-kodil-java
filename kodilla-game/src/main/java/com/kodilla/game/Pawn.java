package com.kodilla.game;

class Pawn implements GameFigure {
    private FigureColor color;

    public Pawn(FigureColor color) {
        this.color = color;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        switch (color){
            case YELLOW: return "Y";
            case BLUE: return "B";
            case GREEN: return "G";
            case RED: return "R";
            case NONE: return " ";
        }
        return " ";
    }
}
