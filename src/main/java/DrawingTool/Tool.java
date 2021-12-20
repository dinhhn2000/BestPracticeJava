package DrawingTool;

import Interface.Canvas;

public abstract class Tool {
  private static char color = 'x';

  public abstract Canvas draw(Canvas canvas, Object obj) throws Exception;

  public void setColor(char newColor) {
    color = newColor;
  }
}
