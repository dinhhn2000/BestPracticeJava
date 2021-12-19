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

  public Canvas input(@NotNull String command) throws Exception {
    try {
      switch (command.charAt(0)) {
        case CREATE_CANVAS -> {
          String[] params = command.split(" ");
          if (params.length != 3) throw new Exception("Not correct params number");
          return new Canvas(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
        }

//      case LINE: {
//        break;
//      }
//      case RECTANGLE: {
//        break;
//      }
//      case FILL: {
//        break;
//      }
        case QUIT -> System.exit(0);
        default -> System.err.println("Incorrect command");
      }
      return new Canvas(3, 3);
    } catch (Exception e) {
      System.err.println(e.getMessage());
//      System.err.println("Incorrect command");
    }
    return new Canvas(3, 3);
  }
}
