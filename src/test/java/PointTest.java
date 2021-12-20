import Dimension.Point;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

class PointTest {
  @Test
  void initPoint() {
    // Success case
    int x = 1;
    int y = 5;
    Point p = new Point(x, y);
    assert p.getY() == y;
    assert p.getX() == x;

    // Negative coordinate
    try {
      new Point(-1, 6);
    } catch (InputMismatchException e) {
      assert e.getMessage().equals("Coordinate cannot be negative");
    }
  }
}