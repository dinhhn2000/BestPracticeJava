package DrawingTool;

import Dimension.Point;
import Interface.Canvas;

public class Bucket extends Tool {
  @Override
  public Canvas draw(Canvas canvas, Object obj) throws Exception {
    Point p = (Point) obj;
    if (canvas.checkOutOfBoundary(p)) throw new Exception("This point is not inside the canvas");

    // Recursive paint
    char[][] canvasContent = canvas.getContent();
    char color = Tool.getColor();
    char initColor = canvasContent[p.getY() - 1][p.getX() - 1];
    Fill(canvasContent, p.getX() - 1, p.getY() - 1, color, initColor);
    canvas.setContent(canvasContent);
    return canvas;
  }

  private void Fill(char[][] content, int x, int y, char newColor, char defaultColor) {
    // If current coordinate is not defaultColor -> pass
    if (content[y][x] != defaultColor) return;

    // If current coordinate is defaultColor -> Set current coordinate newColor -> Recursive for 4 other positions
    content[y][x] = newColor;
    // Top
    if (y > 0) Fill(content, x, y - 1, newColor, defaultColor);
    // Right
    if (x < content[0].length - 1) Fill(content, x + 1, y, newColor, defaultColor);
    // Bottom
    if (y < content.length - 1) Fill(content, x, y + 1, newColor, defaultColor);
    // Left
    if (x > 0) Fill(content, x - 1, y, newColor, defaultColor);
  }
}
