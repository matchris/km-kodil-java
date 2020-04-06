package com.kodilla.game;

class Application {
  public static void main(String[] args) {

    Game game = new Game();
    game.setFigure(5, new Pawn(FigureColor.YELLOW));
    game.move(5, 8);
    GameFigure figure = game.getFigure(8);
    System.out.println(figure);
  }
}
