package com.kodilla.game;

class Pawn implements GameFigure {
  private FigureColor color;

  public Pawn(FigureColor color) {
    this.color = color;
  }

  @Override
  public FigureColor getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "Pawn{" + "color=" + color + '}';
  }
}
