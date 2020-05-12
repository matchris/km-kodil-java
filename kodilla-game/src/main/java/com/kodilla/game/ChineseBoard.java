package com.kodilla.game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChineseBoard extends Application {

    String ypHomeBaseStart = "file:kodilla-game/src/main/resources/HomesBasesStartPoint/blue80x80.png";
    String bpHomeBaseStart = "file:kodilla-game/src/main/resources/HomesBasesStartPoint/green80x80.png";
    String gpHomeBaseStart = "file:kodilla-game/src/main/resources/HomesBasesStartPoint/red80x80.png";
    String rpHomeBaseStart = "file:kodilla-game/src/main/resources/HomesBasesStartPoint/yellow80x80.png";
    String backgroundMainView = "file:kodilla-game/src/main/resources/BackGround/background.jpg";
    String field = "file:kodilla-game/src/main/resources/Pawns/field80x80.png";
    private Image imageback = new Image(backgroundMainView);

    private Image pawn = new Image("file:kodilla-game/src/main/resources/HomesBasesStartPoint/blue80x80.pngf");
    private FlowPane pawns = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(880, 880, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);
        for (int n = 0; n < 11; n++) {
            grid.getRowConstraints().add(new RowConstraints(80));
            grid.getColumnConstraints().add(new ColumnConstraints(80));
        }

//        ImageView img = new ImageView(ypHomeBaseStart);
//        ImageView img1 = new ImageView(rpHomeBaseStart);
//        ImageView img2 = new ImageView(gpHomeBaseStart);
//        ImageView noneImage = new ImageView(field);
//        pawns.getChildren().add(img);
//
//        grid.add(img, 5, 5, 1, 1);
//        grid.add(img1, 0, 0, 1, 1);
//        grid.add(img2, 1, 1, 1, 1);
//        grid.add(noneImage,3,3,1,1);

        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 880, 880, Color.BLACK);
        primaryStage.setTitle("Chinese");
        primaryStage.setScene(scene);
        Game game = new Game();
        GameGFX gameGFX = new GameGFX(game,grid);
        gameGFX.display();
        primaryStage.show();
    }
}