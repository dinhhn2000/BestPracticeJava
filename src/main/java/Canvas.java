import java.util.ArrayList;
import java.util.Arrays;

public class Canvas {
  static final char EMPTY = ' ';
  private final char[][] body;
  private final ArrayList<Object> elementStack = new ArrayList<>();

  public Canvas(int w, int h) throws Exception {
    if (w <= 0 || h <= 0) {
      throw new Exception("Invalid width or height");
    }
    body = new char[w][h];
    for (char[] e : body) {
      Arrays.fill(e, EMPTY);
    }
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

  public void addLine(Line line) throws Exception {
    elementStack.add(line);

    // Check out of boundary
    if (line.getStart().getX() <= 0 || line.getStart().getX() > body[0].length || line.getStart().getY() <= 0 || line.getStart().getY() > body.length
            || line.getEnd().getX() <= 0 || line.getEnd().getX() > body[0].length || line.getEnd().getY() <= 0 || line.getEnd().getY() > body.length)
      throw new Exception("This line cannot be added into this canvas");

    // Process add line
    ArrayList<Point> allPoints = line.getAllPoints();
    allPoints.forEach(p -> body[p.getY() - 1][p.getX() - 1] = 'x');
  }
}