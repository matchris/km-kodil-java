package com.kodilla.game;

import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.HashMap;
import java.util.Map;

public class GameGFX {
    private final Game game;
    private final GridPane grid;

    public GameGFX(Game game, GridPane grid) {
        this.game = game;
        this.grid = grid;
    }

    public void display() {
        grid.getChildren().clear();
//        for (int n = 0; n < 11; n++) {
//            grid.getRowConstraints().add(new RowConstraints(80));
//            grid.getColumnConstraints().add(new ColumnConstraints(80));
//        }
        for (int n = 0; n < 40; n++) {
            GameFigure f = game.getFigure(n);
            System.out.println("for n = " + n + " f.getColor: " + f.getColor());
            ImageView iv = new ImageView(f.getImage());
            if (f.getImage() != null) {
                System.out.println("f.getImage: !=null");
            }
            Coord coord = getCoord(n);
            System.out.println("coord: n = " + n + " : " + coord);
            if (coord != null && n%10!=0)
                grid.add(iv, coord.getX(), coord.getY());
        }

        for (int k = 0; k < 4; k++) {
            GameFigure startsColor = new Pawn(Game.getColor(k));
            ImageView starts = new ImageView(startsColor.getImageBHS());
            Coord coord = getCoord(72 + k);
            grid.add(starts, coord.getX(), coord.getY());
            for (int n = 0; n < 4; n++) {
                GameFigure plColor = new Pawn(Game.getColor(k));
                ImageView bases = new ImageView(plColor.getImage());
                ImageView homes = new ImageView(plColor.getImageBHS());
                if (k == 0) {
                    coord = getCoord(n + 52);
                    Coord coordHomes = getCoord(n + 68);
                    grid.add(bases, coord.getX(), coord.getY());
                    grid.add(homes, coordHomes.getX(), coordHomes.getY());
                } else if (k == 1) {
                    coord = getCoord(n + 40);
                    Coord coordHomes = getCoord(n + 56);
                    grid.add(bases, coord.getX(), coord.getY());
                    grid.add(homes, coordHomes.getX(), coordHomes.getY());
                } else if (k == 2) {
                    coord = getCoord(n + 44);
                    Coord coordHomes = getCoord(n + 60);
                    grid.add(bases, coord.getX(), coord.getY());
                    grid.add(homes, coordHomes.getX(), coordHomes.getY());

                } else {
                    coord = getCoord(n + 48);
                    Coord coordHomes = getCoord(n + 64);
                    grid.add(bases, coord.getX(), coord.getY());
                    grid.add(homes, coordHomes.getX(), coordHomes.getY());
                }
            }
        }
    }

    private Coord getCoord(int n) {
        Map<Integer, Coord> coords = new HashMap<>();
        coords.put(0, new Coord(4, 10));
        coords.put(1, new Coord(4, 9));
        coords.put(2, new Coord(4, 8));
        coords.put(3, new Coord(4, 7));
        coords.put(4, new Coord(4, 6));
        coords.put(5, new Coord(3, 6));
        coords.put(6, new Coord(2, 6));
        coords.put(7, new Coord(1, 6));
        coords.put(8, new Coord(0, 6));
        coords.put(9, new Coord(0, 5));
        coords.put(10, new Coord(0, 4));
        coords.put(11, new Coord(1, 4));
        coords.put(12, new Coord(2, 4));
        coords.put(13, new Coord(3, 4));
        coords.put(14, new Coord(4, 4));
        coords.put(15, new Coord(4, 3));
        coords.put(16, new Coord(4, 2));
        coords.put(17, new Coord(4, 1));
        coords.put(18, new Coord(4, 0));
        coords.put(19, new Coord(5, 0));
        coords.put(20, new Coord(6, 0));
        coords.put(21, new Coord(6, 1));
        coords.put(22, new Coord(6, 2));
        coords.put(23, new Coord(6, 3));
        coords.put(24, new Coord(6, 4));
        coords.put(25, new Coord(7, 4));
        coords.put(26, new Coord(8, 4));
        coords.put(27, new Coord(9, 4));
        coords.put(28, new Coord(10, 4));
        coords.put(29, new Coord(10, 5));
        coords.put(30, new Coord(10, 6));
        coords.put(31, new Coord(9, 6));
        coords.put(32, new Coord(8, 6));
        coords.put(33, new Coord(7, 6));
        coords.put(34, new Coord(6, 6));
        coords.put(35, new Coord(6, 7));
        coords.put(36, new Coord(6, 8));
        coords.put(37, new Coord(6, 9));
        coords.put(38, new Coord(6, 10));
        coords.put(39, new Coord(5, 10));
        //blue bases
        coords.put(40, new Coord(0, 0));
        coords.put(41, new Coord(1, 0));
        coords.put(42, new Coord(0, 1));
        coords.put(43, new Coord(1, 1));
        //green bases
        coords.put(44, new Coord(9, 0));
        coords.put(45, new Coord(10, 0));
        coords.put(46, new Coord(9, 1));
        coords.put(47, new Coord(10, 1));
        //red bases
        coords.put(48, new Coord(9, 9));
        coords.put(49, new Coord(10, 9));
        coords.put(50, new Coord(9, 10));
        coords.put(51, new Coord(10, 10));
        //yellow bases
        coords.put(52, new Coord(0, 9));
        coords.put(53, new Coord(1, 9));
        coords.put(54, new Coord(0, 10));
        coords.put(55, new Coord(1, 10));
        //blue houses
        coords.put(56, new Coord(1, 5));
        coords.put(57, new Coord(2, 5));
        coords.put(58, new Coord(3, 5));
        coords.put(59, new Coord(4, 5));
        //green houses
        coords.put(60, new Coord(5, 1));
        coords.put(61, new Coord(5, 2));
        coords.put(62, new Coord(5, 3));
        coords.put(63, new Coord(5, 4));
        //red houses
        coords.put(64, new Coord(6, 5));
        coords.put(65, new Coord(7, 5));
        coords.put(66, new Coord(8, 5));
        coords.put(67, new Coord(9, 5));
        //yellow houses
        coords.put(68, new Coord(5, 6));
        coords.put(69, new Coord(5, 7));
        coords.put(70, new Coord(5, 8));
        coords.put(71, new Coord(5, 9));
        //start points yellow, blue, green, red
        coords.put(72, new Coord(4, 10));
        coords.put(73, new Coord(0, 4));
        coords.put(74, new Coord(6, 0));
        coords.put(75, new Coord(10, 6));

        return coords.get(n);
    }
}
