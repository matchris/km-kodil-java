package com.kodilla.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Application {
    public static void main(String[] args) {

        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        List<Player> players = getNumberOfPlayers();
        int playerNumber = 1;
        Player currentPlayer = players.get(playerNumber);
        System.out.println("Your name is: " + currentPlayer.getName() + ", and You play: " + game.getColor(playerNumber));
        while (true) {
            System.out.println(game);

            //Wylosować ruch dla jednego gracza i wykonać
            int dice = Dice.getResult();
            if (isMoveAvailable()) {

                int toPosition = +dice;
                int fromPosition = 0;

                int currentPlayerNumber = currentPlayer.getPlayerNumber();
                game.introducePawn(game.getColor(currentPlayerNumber), dice);

                FigureColor currentPlayerColor = game.getColor(currentPlayerNumber);
                fromPosition = game.getStartPoints().get(currentPlayerColor);

                game.setFigure(fromPosition, new Pawn(currentPlayerColor));
                game.move(fromPosition, toPosition);

//                GameFigure figure = game.getFigure(toPosition);
                sc.nextLine();
            }
        }
    }

/*  ----------------- boolean isMoveAvailable(int dice) conditions ------------------- // CASE ??
boolean move(FigureColor color, int fieldIndex, int dice){
Czy na fieldIndex mamy figurę coloru color if Not return false
int endPoint = (fieldIndex - startPoints) + dice;
if (endPoint > 43) return false;
if notEmpty(endPoint) && getFigure(endPoint).getColor()==color return false;
if notEmpty(endPoint) hitEnemyFigure(endPoint);
setFigure(..., endPoint)
return true;


 }


  dla jakich pionków ruch możliwy i jeśli dla więcej niż jeden
  to wyświetlić je i dać wybór którym pionkiem wykonać ruch (czy nie należy pionki ponumerować?)

    IF pionekJestNaPlanszy() && (gdy nie skończy ruchu:   //plansza to też pola domku
        1.  poza POLEM_KOŃCOWYM, czyli (43 - (bieżaca pozycja - StartPoints)) > = 0  //getCurrentPosition
            ||
        2. na polu z własnym pionkiem
            ||
        //3. na polu StartPoints innego gracza na którym stoi jego pionek) to niekoniecznie
    ELSE IF isBaseEmpty() == false
     // introducePawn()
     Else IF pawnsAtHomesOnTheLastCells == TRUE  przedziale (POLE KOŃCOWE - (4 - pionkiWBazie), POLE KOŃCOWE)


    -------------------- end isMoveAvailable -------------------------
*/

    private static boolean isSix(int dice){{
            if(dice == 6) {
                return true;
            } else {
                return false;
            }
        }
    }
    private static boolean isMoveAvailable() {
        return true;
    }

    private static List<Player> getNumberOfPlayers() {
        Scanner sc = new Scanner(System.in);
        int playerNumber = 0;

        do {
            System.out.print("Choose Players number 2-4: ");
            playerNumber = sc.nextInt();
            if (playerNumber > 4 || playerNumber < 2) {
                System.out.println("You've chosen wrong number, choose once again.");
            }
        } while (!(playerNumber == 2 || playerNumber == 3 || playerNumber == 4));

        List<Player> players = new ArrayList<>();
        System.out.print("Your name: ");
        String playerName = sc.next();
        players.add(new Player(playerName, 0));
        for (int i = 1; i < playerNumber; i++) {
            String name = "Computer" + i;
            players.add(new Player(name, i));
        }
        return players;
    }
}

