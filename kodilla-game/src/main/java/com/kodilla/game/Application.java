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
                int dice2 = Dice.getResult();
                int dice3 = Dice.getResult();
                int currentPlayerNumber = currentPlayer.getPlayerNumber();
                int pawnsInBase = game.getBase().get(currentPlayerColor);
                int fromStartPosition = game.getStartPoints().get(currentPlayerColor);
                int fromPosition = 0;
                System.out.println("Liczba pionków w bazie przed ruchem: " + pawnsInBase);

                //if domek number is full and dice == 6 then introduce else move()
                //else game.figures.stream().filter(FigureColor color ->  color.getCollor == currentPlayerColor.
                // asList().
                //znalezienie pionka który jest wysunięty najdalej na nim wykonujemy metodę move


                System.out.println("dice: " + dice + " dice2: " + dice2 + " dice3: " + dice3 + " :CZY pionki na planszy: " + !game.getFiguresPositions(currentPlayerColor).isEmpty());


                System.out.println("kolor bieżącego gracza: " + currentPlayerColor);
                boolean isFigureOnBoard = !game.getFiguresPositions(currentPlayerColor).isEmpty();
                if (isFigureOnBoard) {
                    List<Integer> figuresOnBoard = game.getFiguresPositions(currentPlayerColor);
                    Optional<Integer> firstPawnOnBoard = figuresOnBoard.stream().findFirst();
                    System.out.println("first Pawn On Board" + firstPawnOnBoard.get());  //dodałem do firstPawnOnBoard.get
                    int furthestPawnOnBoard = Collections.max(figuresOnBoard);
                    System.out.println("DEBUG furthestPawnOnBoard: " + furthestPawnOnBoard);
                    fromPosition = furthestPawnOnBoard;
                    if (dice != 6) {
                        System.out.println("Dice w pierwszej pętli gdy pionki są na planszy dice: " + dice);
                        game.move(fromPosition, dice);
                    } else {
                        if (dice2 != 6) {
                            System.out.println("Dice w drugiej pętli gdy pionki są na planszy dice: " + dice + " dice2: " + dice2);
                            boolean isNotValid = !game.isMoveValid(fromPosition, dice + dice2); //to może będzie trzeba wyrzucić
                            System.out.println("isNotValid jeśli true to powinno ustawić nowego pionka i tyle");

                            if (isNotValid && pawnsInBase > 0) {  //tutaj musimy sprawdzić warunek jeśli ruch jest niemożliwy to wyprowadź pionka
                                game.introducePawn(game.getColor(currentPlayerNumber));
                                game.setFigure(fromStartPosition, new Pawn(currentPlayerColor));
                                game.move(fromStartPosition, dice2);
                            } else {
                                System.out.println("OSTATNI ELSE DLA ELSE");
                                game.move(fromPosition, dice + dice2);
                            }
//
//                            System.out.println("Dice w trzeciej pętli gdy pionki są na planszy dice: " + dice + " dice2: " + dice2 + " dice3: " + dice3);
//                            game.introducePawn(game.getColor(currentPlayerNumber));
//                            game.setFigure(fromStartPosition, new Pawn(currentPlayerColor));
//                            game.move(fromStartPosition, dice2 + dice3);
                        } else {
                            boolean isNotValid = !game.isMoveValid(fromPosition, dice + dice2 + dice3);
                            if (isNotValid && pawnsInBase > 0) {  //tutaj musimy sprawdzić warunek jeśli ruch jest niemożliwy to wyprowadź pionka
                                game.introducePawn(game.getColor(currentPlayerNumber));
                                game.setFigure(fromStartPosition, new Pawn(currentPlayerColor));
                                game.move(fromStartPosition, dice2+dice3);
                            } else {
                                System.out.println("OSTATNI ELSE DLA ELSE");
                                game.move(fromPosition, dice + dice2 + dice3);
                            }
                        }
                    }

                } else if (pawnsInBase > 0 && dice == 6 || dice2 == 6 || dice3 == 6) { // kod wykonywany tylko w przypadku pustej planszy i porządku w domku (zakładamy że jest)

                    if (dice == 6) {
                        System.out.println("PĘTLA 1.0");
                        if (dice2 != 6) {
                            System.out.println("PĘTLA 1.1");
                            toPosition = dice2;
                            game.introducePawn(game.getColor(currentPlayerNumber));
                            game.move(fromStartPosition, toPosition);
                        } else {
                            System.out.println("PĘTLA 1.2");
                            toPosition = dice2 + dice3;
                            game.introducePawn(game.getColor(currentPlayerNumber));
                            game.move(fromStartPosition, toPosition);
                        }
                    } else if (dice2 == 6) {
                        System.out.println("PĘTLA 2.0");
                        toPosition = dice3;
                        game.introducePawn(game.getColor(currentPlayerNumber));
                        game.move(fromStartPosition, toPosition);
                    } else {
                        System.out.println("PĘTLA 3.0");
                        game.introducePawn(game.getColor(currentPlayerNumber));
                    }
                }
                System.out.println("Ruch przechodzi do kolejnego gracza");
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

