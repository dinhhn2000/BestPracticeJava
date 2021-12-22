package Interface;

import Dimension.Line;
import Dimension.Point;
import Dimension.Rectangle;
import DrawingTool.Brush;
import DrawingTool.Bucket;
import DrawingTool.ColorPicker;
import DrawingTool.Tool;
import Utils.Helpers;

public class Command {
  private static final char QUIT = 'Q';
  private static final char CREATE_CANVAS = 'C';
  private static final char LINE = 'L';
  private static final char RECTANGLE = 'R';
  private static final char FILL = 'B';

  public Command() {
    System.out.print("enter command: ");
  }

  private String[] getParamsAndValidate(String command, int paramsNumber) throws Exception {
    String[] params = command.split(" ");
    if (params.length != paramsNumber) throw new Exception("Not correct params amount");
    return params;
  }

  public Canvas input(String command, Canvas canvas) throws Exception {
    try {
      String[] params;
      Tool tool;
      switch (command.charAt(0)) {
        case CREATE_CANVAS -> {
          // Ex: C 20 4
          params = getParamsAndValidate(command, 3);
          int width = Helpers.convertStringToInteger(params[1]);
          int height = Helpers.convertStringToInteger(params[2]);
          return new Canvas(width, height);
        }
        case LINE -> {
          // Ex: L 1 2 6 2
          params = getParamsAndValidate(command, 5);
          int startX = Helpers.convertStringToInteger(params[1]);
          int startY = Helpers.convertStringToInteger(params[2]);
          int endX = Helpers.convertStringToInteger(params[3]);
          int endY = Helpers.convertStringToInteger(params[4]);
          Point start = new Point(startX, startY);
          Point end = new Point(endX, endY);
          tool = new Brush();
          return tool.draw(canvas, new Line(start, end));
        }
        case RECTANGLE -> {
          // Ex: R 14 1 18 3
          params = getParamsAndValidate(command, 5);
          int topLeftX = Helpers.convertStringToInteger(params[1]);
          int topLeftY = Helpers.convertStringToInteger(params[2]);
          int bottomRightX = Helpers.convertStringToInteger(params[3]);
          int bottomRightY = Helpers.convertStringToInteger(params[4]);
          Point tl = new Point(topLeftX, topLeftY);
          Point br = new Point(bottomRightX, bottomRightY);
          tool = new Brush();
          return tool.draw(canvas, new Rectangle(tl, br));
        }
        case FILL -> {
          // Ex: B 10 3 o
          params = getParamsAndValidate(command, 4);
          ColorPicker.setColor(params[3].charAt(0));
          int x = Helpers.convertStringToInteger(params[1]);
          int y = Helpers.convertStringToInteger(params[2]);
          tool = new Bucket();
          return tool.draw(canvas, new Point(x, y));
        }
        case QUIT -> System.exit(0);
        default -> System.err.println("Incorrect command");
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
      throw e;
    }
    return null;
  }
}
