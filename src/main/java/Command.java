import com.github.stefanbirkner.systemlambda.Statement;
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

  public void input(@NotNull String command) {
    switch (command.charAt(0)) {
      case CREATE_CANVAS -> {
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
  }

}
