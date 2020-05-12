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
//        grid.getChildren().clear();
        for (int n = 0; n < 11; n++) {
            grid.getRowConstraints().add(new RowConstraints(80));
            grid.getColumnConstraints().add(new ColumnConstraints(80));
        }
        for (int n = 0; n < 40; n++) {
            GameFigure f = game.getFigure(n);
            System.out.println("for n = " + n + " f.getColor: " + f.getColor());
            ImageView iv = new ImageView(f.getImage());
            if(f.getImage()!=null){
                System.out.println("f.getImage: !=null");
            }
            Coord coord = getCoord(n);
            System.out.println("coord: n = " + n + " : " + coord);
            if (coord != null)
                grid.add(iv, coord.getX(), coord.getY());
        }

    }

    private Coord getCoord(int n) {
        Map<Integer, Coord> coords = new HashMap<>();
        coords.put(0, new Coord(10, 4));
        coords.put(1, new Coord(9, 4));
        coords.put(2, new Coord(8, 4));
        coords.put(3, new Coord(7, 4));
        coords.put(4, new Coord(6, 4));
        coords.put(5, new Coord(6, 3));
        coords.put(6, new Coord(6, 2));
        coords.put(7, new Coord(6, 1));
        coords.put(8, new Coord(6, 0));
        coords.put(9, new Coord(5, 0));
        coords.put(10, new Coord(4, 0));
        coords.put(11, new Coord(4, 1));
        coords.put(12, new Coord(4, 2));
        coords.put(13, new Coord(4, 3));
        coords.put(14, new Coord(4, 4));
        coords.put(15, new Coord(3, 4));
        coords.put(16, new Coord(2, 4));
        coords.put(17, new Coord(1, 4));
        coords.put(18, new Coord(0, 4));
        coords.put(19, new Coord(0, 5));
        return coords.get(n);
    }
}
