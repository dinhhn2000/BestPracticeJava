import Dimension.Line;
import Dimension.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;

class LineTest {
  @Test
  void initLine() {
    // Success case
    Point start = new Point(1, 2);
    Point end = new Point(5, 2);
    Line line = new Line(start, end);
    assert line.getStart() == start;
    assert line.getEnd() == end;

    // 2 same points
    try {
      new Line(new Point(1, 1), new Point(1, 1));
    } catch (InputMismatchException e) {
      assert e.getMessage().equals("This line does not exist");
    }

    // Not a horizontal or vertical line
    try {
      new Line(new Point(1, 1), new Point(2, 2));
    } catch (InputMismatchException e) {
      assert e.getMessage().equals("System only support vertical & horizontal lines");
    }
  }

  @Test
  void testGetAllPoints() {
    Point start = new Point(1, 1);
    Point end = new Point(1, 10);
    Line line = new Line(start, end);
    ArrayList<Point> actualResult = line.getAllPoints();
    for (int i = start.getY(); i <= end.getY(); i++) assert actualResult.contains(new Point(start.getX(), i));
  }
}