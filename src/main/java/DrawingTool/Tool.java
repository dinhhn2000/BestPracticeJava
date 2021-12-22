package DrawingTool;

import Interface.Canvas;

public abstract class Tool {
  static char color = 'x';

  public abstract Canvas draw(Canvas canvas, Object obj) throws Exception;

}
