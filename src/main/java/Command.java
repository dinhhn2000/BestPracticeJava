import org.jetbrains.annotations.NotNull;

public class Command {
//    char action;

  public Command() {
    System.out.print("enter command: ");
  }

  public void input(@NotNull String command) {
    System.out.println(command);
    switch (command.charAt(0)) {
      case 'Q': {
        System.exit(0);
        break;
      }
    }
  }
}
