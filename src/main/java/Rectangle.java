import java.util.ArrayList;
import java.util.InputMismatchException;

public class Rectangle implements Geometry {
  private final Point topLeft;
  private final Point topRight;
  private final Point bottomLeft;
  private final Point bottomRight;

  public Rectangle(Point tl, Point br) {
    if (tl.getX() > br.getX() && tl.getY() > br.getY())
      throw new InputMismatchException("Wrong format!!! Must be top-left & bottom-right");
    if (tl.getX() == br.getX() || tl.getY() == br.getY())
      throw new InputMismatchException("This rectangle does not exist");
    topLeft = tl;
    bottomRight = br;
    topRight = new Point(bottomRight.getX(), topLeft.getY());
    bottomLeft = new Point(topLeft.getX(), bottomRight.getY());
  }

  public Point getTopLeft() {
    return topLeft;
  }

  public Point getBottomRight() {
    return bottomRight;
  }

  @Override
  public ArrayList<Point> getAllPoints() {
    ArrayList<Point> result = new ArrayList<>();
    result.addAll(new Line(topLeft, topRight).getAllPoints());
    result.addAll(new Line(topRight, bottomRight).getAllPoints());
    result.addAll(new Line(bottomRight, bottomLeft).getAllPoints());
    result.addAll(new Line(bottomLeft, topLeft).getAllPoints());
    return result;
  }
}
