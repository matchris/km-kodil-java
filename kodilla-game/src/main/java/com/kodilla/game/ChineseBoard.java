package com.kodilla.game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private ImageView viewDice = new ImageView();
    private Image pawn = new Image("file:kodilla-game/src/main/resources/HomesBasesStartPoint/blue80x80.pngf");
    private FlowPane pawns = new FlowPane(Orientation.HORIZONTAL);
    private Label resultDice;


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

        //BEGIN----------->WYŚWIETLANIE KOSTKI<-------------------------
        Label message1 = new Label("Press to roll dice");
        resultDice = new Label();
        Button startButton = new Button("Roll dice!");
        startButton.setOnAction(new StartButtonHandler());
        VBox vbox = new VBox(10, message1, startButton,/* hbox,*/ resultDice, viewDice);
        vbox.setPadding(new Insets(15));
        vbox.setAlignment(Pos.CENTER);
//        Scene diceScene = new Scene(vbox);
//        primaryStage.setScene(diceScene);
//        primaryStage.show();
        //-------------->WYŚWIETLANIE KOSTKI<------------------------END

        for (int n = 0; n < 11; n++) {
            grid.getRowConstraints().add(new RowConstraints(80));
            grid.getColumnConstraints().add(new ColumnConstraints(80));
        }

        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 880, 880, Color.BLACK);
        primaryStage.setTitle("Chinese");
        primaryStage.setScene(scene);

        Game game = new Game();

        //ustawiamy jakieś pionki na planszy
        int playerNumber = 0;
        int toPosition = 6;
        FigureColor currentPlayerColor = game.getColor(playerNumber);
        currentPlayerColor = game.getColor(playerNumber);
        int fromStartPosition = game.getStartPoints().get(currentPlayerColor);
        game.introducePawn(game.getColor(playerNumber));
        game.move(fromStartPosition, toPosition);
        int newPosition = toPosition + 31;
        game.move(toPosition, newPosition);
        game.introducePawn(game.getColor(playerNumber)); // to co jest domkiem lub punktem startowym zjada mi pionka
        game.move(fromStartPosition, toPosition);

        currentPlayerColor = game.getColor(1);
        fromStartPosition = game.getStartPoints().get(currentPlayerColor);
        game.introducePawn(game.getColor(1));
        game.move(fromStartPosition, 16);
        game.introducePawn(game.getColor(1));
        game.move(fromStartPosition, 5);
        game.introducePawn(game.getColor(1));

        GameGFX gameGFX = new GameGFX(game, grid);
        gameGFX.display();
        primaryStage.show();
    }

    //-------------->WYŚWIETLANIE KOSTKI<---------------------------
    class StartButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int rollResult = Dice.getResult();
            DiceImage diceImage = new DiceImage();
            Image dicePic1;
            diceImage.setImage(rollResult);
            dicePic1 = diceImage.getImage();
            viewDice = new ImageView(dicePic1);
            resultDice.setText("You rolled a " + rollResult);
        }
        //-------------->WYŚWIETLANIE KOSTKI<---------------------------
    }
}