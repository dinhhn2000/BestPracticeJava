package Dimension;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public class Line extends Geometry {
  private final Point start;
  private final Point end;

  public Line(Point s, Point e) {
    if (s.getX() != e.getX() && s.getY() != e.getY())
      throw new InputMismatchException("System only support vertical & horizontal lines");
    if (s.getX() == e.getX() && s.getY() == e.getY()) throw new InputMismatchException("This line does not exist");
    start = s;
    end = e;
    setType(Geometry.LINE);
  }

  public Point getStart() {
    return start;
  }

  public Point getEnd() {
    return end;
  }

  @Override
  public ArrayList<Point> getAllPoints() {
    ArrayList<Point> result = new ArrayList<>();
    if (start.getX() == end.getX()) {
      if (start.getY() < end.getY())
        IntStream.range(start.getY(), end.getY() + 1).forEach(y -> result.add(new Point(start.getX(), y)));
      else IntStream.range(end.getY(), start.getY() + 1).forEach(y -> result.add(new Point(start.getX(), y)));
    } else {
      if (start.getX() < end.getX()) {
        IntStream.range(start.getX(), end.getX() + 1).forEach(x -> result.add(new Point(x, start.getY())));
      } else {
        IntStream.range(end.getX(), start.getX() + 1).forEach(x -> result.add(new Point(x, start.getY())));
      }
    }
    return result;
  }
}
