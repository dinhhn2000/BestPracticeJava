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
    assert actualMessage.contains("Incorrect command");
  }

  @Test
  void enterCreateCanvasCommand() throws Exception {
    String testInput;
    Canvas actualResult;
    // Case 1
    testInput = "C 3 4";
    actualResult = command.input(testInput);
    assert actualResult.getWidth() == 3;
    assert actualResult.getHeight() == 4;

    // Case 2
    String actualErrMessage = tapSystemErr(() -> command.input("C 0 -3"));
    assert actualErrMessage.contains("Invalid width or height");


    // Case 3
    testInput = "C 30 7";
    actualResult = command.input(testInput);
    assert actualResult.getWidth() == 30;
    assert actualResult.getHeight() == 7;

    // Case 4
    actualErrMessage = tapSystemErr(() -> command.input("C -3 50 3"));
    assert actualErrMessage.contains("Not correct params number");
  }

}
