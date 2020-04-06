package com.kodilla.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Game {
  private List<GameFigure> figures = new ArrayList<>();
  private Map<FigureColor, List<GameFigure>> homes = new HashMap<>();
  private Map<FigureColor, Integer> base = new HashMap<>();
  private Map<FigureColor, Integer> startPoints = new HashMap<>();

  public Game() {
    for (int n = 0; n < 40; n++)
      figures.add(new None());
    for (int n = 0; n < 4; n++) {
      List<GameFigure> theList = new ArrayList<>();
      for (int k = 0; k < 4; k++)
        theList.add(new None());
      homes.put(getColor(n), theList);
      base.put(getColor(n), 4);
    }
    startPoints.put(FigureColor.YELLOW, 0);
    startPoints.put(FigureColor.BLUE, 10);
    startPoints.put(FigureColor.RED, 20);
    startPoints.put(FigureColor.GREEN, 30);
  }

  public static FigureColor getColor(int number) {
    switch (number) {
    case 0:
      return FigureColor.YELLOW;
    case 1:
      return FigureColor.BLUE;
    case 2:
      return FigureColor.GREEN;
    default:
      return FigureColor.RED;
    }
  }

  public GameFigure getFigure(int index) {
    return figures.get(index);
  }

  public void setFigure(int index, GameFigure figure) {
    figures.set(index, figure);
  }

  public void introducePawn(FigureColor color, int dice) {
    int position = startPoints.get(color) + dice;
    figures.set(position, new Pawn(color));
    int number = base.get(color);
    base.put(color, number - 1);
  }

  public void move(int from, int to) {
    if (!isMoveValid(from, to))
      return;
    GameFigure figure = getFigure(from);
    FigureColor color = getFigure(to).getColor();
    if (color != FigureColor.NONE) {
      int number = base.get(color);
      base.put(color, number + 1);
    }
    setFigure(to, figure);
    setFigure(from, new None());
  }

  private boolean isMoveValid(int from, int to) {
    return true;
  }
}
