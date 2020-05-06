package com.kodilla.game;

import java.util.*;

class Application {
    public static void main(String[] args) {

        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        List<Player> players = getNumberOfPlayers();
        int playerNumber = 1;
        Player currentPlayer = players.get(playerNumber);
        FigureColor currentPlayerColor = game.getColor(playerNumber);


        System.out.println("Your name is: " + currentPlayer.getName() + ", and You play: " + currentPlayerColor);
        while (true) {
            currentPlayerColor = game.getColor(playerNumber);
            currentPlayer = players.get(playerNumber);
            System.out.println(game);

            //Wylosować ruch dla jednego gracza i wykonać
            int dice = Dice.getResult();
            if (isMoveAvailable()) {

                int toPosition = +dice;
                int currentPlayerNumber = currentPlayer.getPlayerNumber();
                int pawnsInBase = game.getBase().get(currentPlayerColor);
                int fromStartPosition = game.getStartPoints().get(currentPlayerColor);
                int fromPosition = 0;
                System.out.println("Liczba pionków w bazie przed ruchem: " + pawnsInBase);

                //if domek number is full and dice == 6 then introduce else move()
                //else game.figures.stream().filter(FigureColor color ->  color.getCollor == currentPlayerColor.
                // asList().
                //znalezienie pionka który jest wysunięty najdalej na nim wykonujemy metodę move


                System.out.println("DEBUG dice: " + dice + " pionki na planszy: " + !game.getFiguresPositions(currentPlayerColor).isEmpty());

                //Jeśli plansza pusta to przy założeniu że Domek pusty

                if (!game.getFiguresPositions(currentPlayerColor).isEmpty()) {
                    int furthestPawnOnBoard = Collections.max(game.getFiguresPositions(currentPlayerColor));
                    System.out.println("DEBUG furthestPawnOnBoard: " + furthestPawnOnBoard);
                    fromPosition = furthestPawnOnBoard;  // na razie nie uwzględniamy 6
                    System.out.println("SPRAWDZAMY FROM POSITION BO TU SIĘ WYSYPUJE: " + fromPosition + " dice " + dice + " to position: " + (fromPosition + dice));
                    if (dice != 6) {
                        game.move(fromPosition, dice);  //tutaj rafia from position ktora jest większa niż 40
                    } else {
                        int dice2 = Dice.getResult();
                        if (dice2 != 6) {
                            game.move(fromPosition, dice + dice2);
                        } else {
                            int dice3 = Dice.getResult();
                            game.move(fromPosition, dice + dice2 + dice3);
                        }
                    }
                } else if (pawnsInBase > 0 && dice == 6) { // kod wykonywany tylko w przypadku pełnej bazy
                    System.out.println("DEBUG musi być: base > 0, dice = 6");
                    game.introducePawn(game.getColor(currentPlayerNumber));
                    int dice2 = Dice.getResult();
                    if (dice2 == 6) {
                        System.out.println("DEBUG musi być: base > 0, dice = 6, dice2 = 6");
                        int dice3 = Dice.getResult();
                        toPosition = dice2 + dice3;
                        game.setFigure(fromStartPosition, new Pawn(currentPlayerColor));
                        game.move(fromStartPosition, toPosition);
                    } else {
                        System.out.println("DEBUG musi być: base > 0, dice 6, dice2 != 6");
                        toPosition = dice2;
                        game.setFigure(fromStartPosition, new Pawn(currentPlayerColor));
                        game.move(fromStartPosition, toPosition);
                    }
                }
                System.out.println("Ruch przechodzi do kolejnego gracza");

                /*else if (pawnsInBase >0){
                    System.out.println("DEBUG musi być: base > 0, dice 6, dice2 != 6");
                    game.introducePawn(game.getColor(currentPlayerNumber)); // zakładamy że w domkach jest porządek
                    game.setFigure(fromStartPosition, new Pawn(currentPlayerColor));
                    game.move(fromStartPosition, toPosition);
                }*/


                System.out.print("Pozycje pionków bieżącego gracza na planszy: ");
                System.out.println(game.getFiguresPositions(currentPlayerColor));

//                GameFigure figure = game.getFigure(toPosition);
                sc.nextLine();
            }
            playerNumber++;
            if (playerNumber > 3)
                playerNumber = 0;
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

    private static boolean isSix(int dice) {
        {
            if (dice == 6) {
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

