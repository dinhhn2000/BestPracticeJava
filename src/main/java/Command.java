import org.jetbrains.annotations.NotNull;

public class Command {
  private static final char QUIT = 'Q';
  private static final char CREATE_CANVAS = 'C';
  private static final char LINE = 'L';
  private static final char RECTANGLE = 'R';
  private static final char FILL = 'B';

  public Command() {
    System.out.print("enter command: ");
  }

  public Canvas input(@NotNull String command, Canvas canvas) throws Exception {
    try {
      String[] params = command.split(" ");
      switch (command.charAt(0)) {
        case CREATE_CANVAS -> {
          // Ex: C 20 4
          if (params.length != 3) throw new Exception("Not correct params amount");
          return new Canvas(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
        }
        case LINE -> {
          // Ex: L 1 2 6 2
          if (params.length != 5) throw new Exception("Not correct params amount");
          Point start = new Point(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
          Point end = new Point(Integer.parseInt(params[3]), Integer.parseInt(params[4]));
          canvas.addLine(new Line(start, end));
          return canvas;
        }
        case RECTANGLE -> {
          // Ex: R 14 1 18 3
          if (params.length != 5) throw new Exception("Not correct params amount");
          Point tl = new Point(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
          Point br = new Point(Integer.parseInt(params[3]), Integer.parseInt(params[4]));
          canvas.addRectangle(new Rectangle(tl, br));
          return canvas;
        }
        case FILL -> {
          // Ex: B 10 3 o
          if (params.length != 4) throw new Exception("Not correct params amount");

        }
        case QUIT -> System.exit(0);
        default -> System.err.println("Incorrect command");
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    return new Canvas(3, 3);
  }
}
