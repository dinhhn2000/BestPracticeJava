package Interface;

import Dimension.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class Canvas {
  public static final char EMPTY = ' ';
  private char[][] content;

  public Canvas(int w, int h) throws Exception {
    if (w <= 0 || h <= 0) throw new Exception("Invalid width or height");
    content = new char[h][w];
    for (char[] e : content) Arrays.fill(e, EMPTY);
  }

  public int getWidth() {
    return content[0].length;
  }

  public int getHeight() {
    return content.length;
  }

  public char[][] getContent() {
    return content;
  }

  public void setContent(char[][] newContent) {
    content = newContent;
  }

  public boolean checkOutOfBoundary(Point p) {
    return p.getX() <= 0 || p.getX() > content[0].length || p.getY() <= 0 || p.getY() > content.length;
  }

  public Canvas drawing(ArrayList<Point> allPoints, char color) {
    allPoints.forEach(p -> content[p.getY() - 1][p.getX() - 1] = color);
    return this;
  }
}