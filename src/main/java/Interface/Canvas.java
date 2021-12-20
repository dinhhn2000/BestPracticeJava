package Interface;

import Dimension.Geometry;
import Dimension.Line;
import Dimension.Point;
import Dimension.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class Canvas {
  public static final char EMPTY = ' ';
  private final char[][] body;

  public Canvas(int w, int h) throws Exception {
    if (w <= 0 || h <= 0) throw new Exception("Invalid width or height");
    body = new char[h][w];
    for (char[] e : body) Arrays.fill(e, EMPTY);
  }

  public Canvas(Canvas canvas) {
    body = new char[canvas.getHeight()][canvas.getWidth()];

  }

  public int getWidth() {
    return body[0].length;
  }

  public int getHeight() {
    return body.length;
  }

  public char[][] getContent() {
    return body;
  }

  public boolean checkOutOfBoundary(Point p) {
    return p.getX() <= 0 || p.getX() > body[0].length || p.getY() <= 0 || p.getY() > body.length;
  }

  public Canvas drawing(ArrayList<Point> allPoints) {
    allPoints.forEach(p -> body[p.getY() - 1][p.getX() - 1] = 'x');
    return this;
  }

  public void addLine(Line line) throws Exception {
    // Check out of boundary
    if (checkOutOfBoundary(line.getStart()) || checkOutOfBoundary(line.getEnd()))
      throw new Exception("This line cannot be added into this canvas");

    // Process add line
    ArrayList<Point> allPoints = line.getAllPoints();
    allPoints.forEach(p -> body[p.getY() - 1][p.getX() - 1] = 'x');
  }

  public void addRectangle(Rectangle rectangle) throws Exception {
    // Check out of boundary
    if (checkOutOfBoundary(rectangle.getTopLeft()) || checkOutOfBoundary(rectangle.getBottomRight()))
      throw new Exception("This rectangle cannot be added into this canvas");

    // Process add rectangle
    ArrayList<Point> allPoints = rectangle.getAllPoints();
    allPoints.forEach(p -> body[p.getY() - 1][p.getX() - 1] = 'x');
  }

  public Canvas addGeometry(Geometry geometry) throws Exception {
    switch (geometry.getType()) {
      case Geometry.LINE -> addLine((Line) geometry);
      case Geometry.RECTANGLE -> addRectangle((Rectangle) geometry);
      default -> throw new IllegalStateException("Unexpected value: " + geometry.getType());
    }
    return this;
  }
}