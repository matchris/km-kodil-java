package com.kodilla.game;

import javafx.scene.image.Image;

import static com.kodilla.game.FigureColor.NONE;

class None implements GameFigure {
  private String field = "file:kodilla-game/src/main/resources/Pawns/field80x80.png";

  @Override
  public FigureColor getColor() {
    return NONE;
  }

  @Override
  public Image getImage() {
    return new Image(field);
  }

  @Override
  public Image getImageBHS() {
    return null;
  }

  @Override
  public String toString() {
    return " ";
  }
}
