package DrawingTool;

import Dimension.Geometry;
import Dimension.Line;
import Dimension.Rectangle;
import Interface.Canvas;

public class Brush extends Tool {
  @Override
  public Canvas draw(Canvas canvas, Object obj) throws Exception {
    Geometry geometry = (Geometry) obj;
    setColor('x');
    switch (geometry.getType()) {
      case Geometry.LINE -> {
        return drawLine(canvas, (Line) geometry);
      }
      case Geometry.RECTANGLE -> {
        return drawRectangle(canvas, (Rectangle) geometry);
      }
      default -> throw new Exception("Not exist geometry type: " + geometry.getType());
    }
  }

  private Canvas drawLine(Canvas canvas, Line line) throws Exception {
    // Check out of boundary
    if (canvas.checkOutOfBoundary(line.getStart()) || canvas.checkOutOfBoundary(line.getEnd()))
      throw new Exception("This line cannot be added into this canvas");

    // Process add line
    return canvas.drawing(line.getAllPoints(), getColor());
  }

  private Canvas drawRectangle(Canvas canvas, Rectangle rectangle) throws Exception {
    // Check out of boundary
    if (canvas.checkOutOfBoundary(rectangle.getTopLeft()) || canvas.checkOutOfBoundary(rectangle.getBottomRight()))
      throw new Exception("This rectangle cannot be added into this canvas");

    // Process add rectangle
    return canvas.drawing(rectangle.getAllPoints(), getColor());
  }
}
