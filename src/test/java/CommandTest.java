import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class CommandTest {
  Command command = new Command();

  @Test
  void initCommand() throws Exception {
    String text = tapSystemOut(Command::new);
    assert text.equals("enter command: ");
  }

  @Test
  void enterQuitCommand() throws Exception {
    int statusCode = catchSystemExit(() -> command.input("Q"));
    assert statusCode == 0;
  }
}
