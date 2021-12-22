package DrawingTool;

import Interface.Canvas;

public class ColorPicker extends Tool {
  public static void setColor(char newColor) {
    color = newColor;
  }

  @Override
  public Canvas draw(Canvas canvas, Object obj) {
    return null;
  }
}
