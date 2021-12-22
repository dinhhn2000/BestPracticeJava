import Dimension.Geometry;
import Dimension.Point;
import DrawingTool.Brush;
import Interface.Canvas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BrushTest {
  @Test
  void invalidGeometryType() {
    Geometry geometry = new Geometry() {
      @Override
      public ArrayList<Point> getAllPoints() {
        return null;
      }
    };
    geometry.setType("INVALID TYPE");

    try {
      Brush brush = new Brush();
      brush.draw(new Canvas(1, 1), geometry);
    } catch (Exception e) {
      assert e.getMessage().equals("Not exist geometry type: " + geometry.getType());
    }
  }
}
