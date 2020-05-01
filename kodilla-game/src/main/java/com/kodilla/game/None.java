package com.kodilla.game;

import static com.kodilla.game.FigureColor.NONE;

class None implements GameFigure {
  @Override
  public FigureColor getColor() {
    return NONE;
  }

  @Override
  public String toString() {
    return " ";
  }
}
