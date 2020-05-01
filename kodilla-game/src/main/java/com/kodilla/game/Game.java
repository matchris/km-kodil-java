package com.kodilla.game;

import java.util.*;

class Game {
    private List<GameFigure> figures = new ArrayList<>();
    private Map<FigureColor, List<GameFigure>> homes = new HashMap<>();
    private Map<FigureColor, Integer> base = new HashMap<>();
    private Map<FigureColor, Integer> startPoints = new HashMap<>();
    private List<Player> players = new ArrayList<>();

    public Game() {
        for (int n = 0; n < 40; n++)
            figures.add(new None());
        for (int n = 0; n < 4; n++) {
            List<GameFigure> theList = getNonesList();
            homes.put(getColor(n), theList);
            base.put(getColor(n), 4);
        }
        startPoints.put(FigureColor.YELLOW, 0);
        startPoints.put(FigureColor.BLUE, 10);
        startPoints.put(FigureColor.GREEN, 20);
        startPoints.put(FigureColor.RED, 30);
    }

    public Map<FigureColor, Integer> getStartPoints() {
        return startPoints;
    }

    private List<GameFigure> getNonesList() {
        List<GameFigure> theList = new ArrayList<>();
        for (int k = 0; k < 4; k++)
            theList.add(new None());
        return theList;
    }

    public static FigureColor getColor(int number) {
        switch (number) {
            case 0:
                return FigureColor.YELLOW;
            case 1:
                return FigureColor.BLUE;
            case 2:
                return FigureColor.GREEN;
            default:
                return FigureColor.RED;
        }
    }


    public GameFigure getFigure(int index) {
        return figures.get(index);
    }

    public void setFigure(int index, GameFigure figure) {
        figures.set(index, figure);
    }

    public void introducePawn(FigureColor color, int dice) {
        System.out.println("color: " + color);
        int fieldNumber = startPoints.get(color);
        GameFigure figure = figures.get(fieldNumber);
        if (figure instanceof Pawn) {
            if (figure.getColor() == color) {
                System.out.println("the same color");
                //stoi pionek tego samego koloru
            } else {
                //stoi pionek innego koloru więc go zbijamy
                FigureColor enemyColor = figure.getColor();
                base.put(enemyColor, base.get(enemyColor) + 1);
                figures.set(fieldNumber, new Pawn(color));
                base.put(color, base.get(color) - 1);
            }
        } else {
            //pole jest puste można wyjeżdżać
            figures.set(fieldNumber, new Pawn(color));
            base.put(color, base.get(color) - 1);
        }
    }

    private int getNumber(FigureColor color, int dice) {
        int position = startPoints.get(color) + dice;
        figures.set(position, new Pawn(color));
        return base.get(color);
    }

    public void move(int from, int to) {
        if (!isMoveValid(from, to))
            return;
        GameFigure figure = getFigure(from);
        FigureColor color = getFigure(to).getColor();
        if (color != FigureColor.NONE) {
            int number = base.get(color);
            base.put(color, number + 1);
        }
        setFigure(to, figure);
        setFigure(from, new None());
    }

    private boolean isMoveValid(int from, int to) {
        return true;
    }

    @Override
    public String toString() {
        String s = "Base: Y:" + base.get(FigureColor.YELLOW) + " R:" + base.get(FigureColor.RED) +
                " G:" + base.get(FigureColor.GREEN) + " B:" + base.get(FigureColor.BLUE) + "\n";
        s += printBoard();
        s += "Home: Y:" + homes.get(FigureColor.YELLOW) + " R:" + homes.get(FigureColor.RED) +
                " G:" + homes.get(FigureColor.GREEN) + " B:" + homes.get(FigureColor.BLUE) + "\n";

        return s;
    }

    private String printBoard() {
        String s = "";
        for (int n = 0; n < 4; n++) {
            for (int k = 0; k < 10; k++) {
                s += getFigure(n * 10 + k).toString() + ".";
            }
            s += "|\n";
        }
        return s;
    }
}
