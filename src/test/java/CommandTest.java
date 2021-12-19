import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class CommandTest {
  Command command = new Command();

  @Test
  void initCommand() throws Exception {
    String actualMessage = tapSystemOut(Command::new);
    String expectedMessage = "enter command: ";
    assert actualMessage.contains(expectedMessage);
  }

  @Test
  void enterQuitCommand() throws Exception {
    int statusCode = catchSystemExit(() -> command.input("Q"));
    assert statusCode == 0;
  }

  @Test
  void enterInvalidCommand() throws Exception {
    String actualMessage = tapSystemErr(() -> command.input("INVALID_COMMAND"));
    String expectedMessage = "Incorrect command";
    assert actualMessage.contains(expectedMessage);
  }
}
