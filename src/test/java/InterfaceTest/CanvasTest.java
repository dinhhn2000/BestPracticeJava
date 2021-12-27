package InterfaceTest;

import Dimension.Point;
import Interface.Canvas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class CanvasTest {
  @Test
  public void initCanvas() throws Exception {
    int width = 12;
    int height = 24;
    Canvas canvas = new Canvas(width, height);
    assert canvas.getWidth() == width;
    assert canvas.getHeight() == height;

    try {
      new Canvas(-1, 50);
    } catch (Exception e) {
      assert e.getMessage().equals("Invalid width or height");
    }
  }

  @Test
  public void testIfPointIsOutOfCanvas() throws Exception {
    Canvas canvas = new Canvas(10, 10);
    Point insidePoint = new Point(3, 10);
    Point outsidePoint = new Point(13, 10);
    assert !canvas.checkOutOfBoundary(insidePoint);
    assert canvas.checkOutOfBoundary(outsidePoint);
  }

  @Test
  public void testDrawingOnCanvas() throws Exception {
    Canvas canvas = new Canvas(5, 5);
    ArrayList<Point> points = new ArrayList<>();
    for (int i = 1; i <= 5; i++) points.add(new Point(i, 4));
    canvas.drawing(points, 'x');
    char[][] expectedResult = new char[][]{{' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {'x', 'x', 'x', 'x', 'x'}, {' ', ' ', ' ', ' ', ' '}};
    assert Arrays.deepEquals(canvas.getContent(), expectedResult);
  }

  @Test
  public void testRenderingOnCanvas() throws Exception {
    Canvas canvas = new Canvas(3, 3);
    String expectedString = "-----\n|   |\n|   |\n|   |\n-----\n";
    String actualResult = tapSystemOut(canvas::render);
    String expectedResult = tapSystemOut(() -> System.out.println(expectedString));
    assert Arrays.deepEquals(new String[]{actualResult}, new String[]{expectedResult});
  }
}
