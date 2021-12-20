import Dimension.Point;
import Dimension.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

class RectangleTest {
  @Test
  void initRectangle() {
    // Success case
    Point topLeft = new Point(1, 1);
    Point bottomRight = new Point(5, 5);
    Rectangle rect = new Rectangle(topLeft, bottomRight);
    assert rect.getTopLeft() == topLeft;
    assert rect.getBottomRight() == bottomRight;

    // Input is a line
    try {
      new Rectangle(new Point(1, 1), new Point(1, 6));
    } catch (InputMismatchException e) {
      assert e.getMessage().equals("This rectangle does not exist");
    }

    // Wrong order
    try {
      new Rectangle(new Point(9, 9), new Point(2, 2));
    } catch (InputMismatchException e) {
      System.out.println(e.getMessage());
      assert e.getMessage().equals("Wrong format!!! Must be top-left & bottom-right");
    }
  }

  @Test
  void testGetAllPoints() {
    Point topLeft = new Point(1, 1);
    Point bottomRight = new Point(5, 5);
    Rectangle rect = new Rectangle(topLeft, bottomRight);
    ArrayList<Point> actualResult = rect.getAllPoints();
    IntStream.range(topLeft.getY(), bottomRight.getY() + 1).forEach(i -> {
      assert actualResult.contains(new Point(topLeft.getX(), i));
      assert actualResult.contains(new Point(bottomRight.getX(), i));
    });
    IntStream.range(topLeft.getX(), bottomRight.getX() + 1).forEach(i -> {
      assert actualResult.contains(new Point(i, topLeft.getY()));
      assert actualResult.contains(new Point(i, bottomRight.getY()));
    });
  }
}