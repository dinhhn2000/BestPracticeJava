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
      switch (command.charAt(0)) {
        case CREATE_CANVAS -> {
          String[] params = command.split(" ");
          if (params.length != 3) throw new Exception("Not correct params number");
          return new Canvas(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
        }
        case LINE -> {
          String[] params = command.split(" ");
          if (params.length != 5) throw new Exception("Not correct params number");
          Point start = new Point(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
          Point end = new Point(Integer.parseInt(params[3]), Integer.parseInt(params[4]));
          canvas.addLine(new Line(start, end));
          return canvas;
        }
//      case RECTANGLE: {
//        break;
//      }
//      case FILL: {
//        break;
//      }
        case QUIT -> System.exit(0);
        default -> System.err.println("Incorrect command");
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    return new Canvas(3, 3);
  }
}
