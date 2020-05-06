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

    public Map<FigureColor, Integer> getBase() {
        return base;
    }

    //    public Integer getStartPoints(FigureColor color) {
//        return startPoints.get(color);
//    }

    private List<GameFigure> getNonesList() {
        List<GameFigure> theList = new ArrayList<>();
        for (int k = 0; k < 4; k++)
            theList.add(new None());
        return theList;
    }

    public List<Integer> getFiguresPositions(FigureColor color) {
        List<Integer> theList = new ArrayList<>();
        for (int k = 0; k < 40; k++) {
            GameFigure figure = figures.get(k);
            if (figure instanceof Pawn) {
                if (figure.getColor() == color) {
                    theList.add(k);
                }
            }
        }
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

    public void introducePawn(FigureColor color) {
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

    public void move(int from, int dice) {
        if (!isMoveValid(from, dice)) {
            System.out.println("DEBUG ruch niemożliwy");
        }
        GameFigure figure = getFigure(from);
        int to = from + dice;
        if (to < 40 + startPoints.get(figure.getColor())) {
            System.out.println("DEBUG GameFigure figure: to%40: " + (to % 40));
            System.out.println("DEBUG GameFigure figure: getFigure(to % 40).getColor(): " + getFigure(to % 40).getColor());
            FigureColor color = getFigure(to % 40).getColor(); //
            if (color != FigureColor.NONE) {
                int number = base.get(color);
                base.put(color, number + 1);
            }
            System.out.println("DEBUG GameFigure figure: TO PRAWDOPODOBNIE TUTAJ SIĘ WYSYPUJE: sprawdzamy wartość to" + to);
            to = (to % 40); // DODANE PRZEZE MNIE MOŻLIWE ŻE DO USUNIĘCIA
            setFigure(to, figure);
        } else { //TUTAJ WSTAWIAMY DOMKI I COŚ SIĘ NIE ZGADZA !!!
            homes.get(figure.getColor()).set((to - startPoints.get(figure.getColor())) % 40, figure);
        }
        setFigure(from, new None());

    }

    private boolean isMoveValid(int fieldIndex, int dice) {
        System.out.println("DEBUG isMoveValid:  --- JESTEŚMY w środku metody isMoveValid ---");
        GameFigure figure = getFigure(fieldIndex);
        System.out.println("DEBUG isMoveValid: fieldIndex: " + fieldIndex);
        int startPoint = startPoints.get(figure.getColor());
        System.out.println("DEBUG isMoveValid: startPoint: " + startPoints.get(figure.getColor()));
        int endPoint = (fieldIndex + dice);
        System.out.println("DEBUG isMoveValid: dice: " + dice);
        System.out.println("DEBUG isMoveValid: endPoint(fieldIndex + dice): " + endPoint);
        System.out.println("start point: " + startPoint);
        System.out.println("end point: " + endPoint);
        System.out.println("DEBUG isMoveValid: (endPoint - startPoint): " + (endPoint - startPoint));
        if ((endPoint - startPoint) >= 40 && (endPoint - startPoint) < 44) {  //DODAŁEM && endPoint - startPoint < 44
            boolean isBigger40 = (endPoint - startPoint) >= 40; // to można będzie wyrzucić po DEBUGingu, to jest moja linijka
            System.out.println("DEBUG if: (endPoint - startPoint) >= 40 " + isBigger40);
            return homes.get(figure.getColor()).get((endPoint - startPoint) % 40) instanceof None;
//            GameFigure dfs = homes.get(figure.getColor()).get((endPoint - startPoint) % 40);
//            System.out.println("DEBUG if: (endPoint - startPoint) >= 40 " + homes.get(figure.getColor()).get((endPoint - startPoint) % 40));
        } else {
            boolean someBooleanValue = figure.getColor() != getFigure((endPoint % 40)).getColor(); //to można będzie wyrzucić po DEBUGingu, to jest moja linijka
            FigureColor someColor = getFigure((endPoint % 40)).getColor(); // to można będzie wyrzucić po DEBUGingu, to jest moja linijka
            System.out.println("DEBUG else: getFigure(endPoint % 40).getColor(): " + someColor);
            System.out.println("DEBUG else: figure.getColor() != getFigure(endPoint % 40).getColor(): " + someBooleanValue);//to można będzie wyrzucić po DEBUGingu, to jest moja linijka
            if (figure.getColor() != getFigure((endPoint % 40)).getColor() && (endPoint - startPoint) <= 43) {
                return true;
            } else {
                return false;
            }
        }
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
