package Dimension;

import java.util.InputMismatchException;

public class Point {
  private final int X;
  private final int Y;

  public Point(int x, int y) {
    if (x <= 0 || y <= 0) throw new InputMismatchException("Coordinate cannot be negative");
    X = x;
    Y = y;
  }

  public int getX() {
    return X;
  }

  public int getY() {
    return Y;
  }

  @Override
  public boolean equals(Object obj) {
    return X == ((Point) obj).getX() || Y == ((Point) obj).getY();
  }
}
