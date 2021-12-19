import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

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
    int statusCode = catchSystemExit(() -> command.input("Q", null));
    assert statusCode == 0;
  }

  @Test
  void enterInvalidCommand() throws Exception {
    String actualMessage = tapSystemErr(() -> command.input("INVALID_COMMAND", null));
    assert actualMessage.contains("Incorrect command");
  }

  @Test
  void enterCreateCanvasCommand() throws Exception {
    String testInput;
    Canvas actualResult;
    // Case 1
    testInput = "C 3 4";
    actualResult = command.input(testInput, null);
    assert actualResult.getWidth() == 3;
    assert actualResult.getHeight() == 4;

    // Case 2
    String actualErrMessage = tapSystemErr(() -> command.input("C 0 -3", null));
    assert actualErrMessage.contains("Invalid width or height");


    // Case 3
    testInput = "C 30 7";
    actualResult = command.input(testInput, null);
    assert actualResult.getWidth() == 30;
    assert actualResult.getHeight() == 7;

    // Case 4
    actualErrMessage = tapSystemErr(() -> command.input("C -3 50 3", null));
    assert actualErrMessage.contains("Not correct params number");
  }

  @Test
  void enterLineCommand() throws Exception {
    // Setup canvas
    String testInput;
    Canvas inputCanvas;

    // Case 1: Draw 1 line
    // -------
    // |x____|
    // |x____|
    // |x____|
    // |x____|
    // |_____|
    // -------
    inputCanvas = new Canvas(5, 5);
    testInput = "L 1 1 1 4";
    Canvas actualResult1 = command.input(testInput, inputCanvas);
    char[][] expectedResult1 = new char[inputCanvas.getHeight()][inputCanvas.getWidth()];
    for (char[] e : expectedResult1) Arrays.fill(e, Canvas.EMPTY);
    IntStream.range(0, 4).forEach(i -> expectedResult1[i][0] = 'x');
    assert Arrays.deepEquals(actualResult1.getContent(), expectedResult1);

    // Case 2: Draw 2 lines
    // -------
    // |_x___|
    // |_xxx_|
    // |_x___|
    // |_x___|
    // |_x___|
    // -------
    inputCanvas = new Canvas(5, 5);
    testInput = "L 2 1 2 5";
    Canvas actualResult2 = command.input(testInput, inputCanvas);
    testInput = "L 2 2 4 2";
    actualResult2 = command.input(testInput, actualResult2);
    char[][] expectedResult2 = new char[inputCanvas.getHeight()][inputCanvas.getWidth()];
    for (char[] e : expectedResult2) Arrays.fill(e, Canvas.EMPTY);
    IntStream.range(0, 5).forEach(i -> expectedResult2[i][1] = 'x');
    IntStream.range(1, 4).forEach(i -> expectedResult2[1][i] = 'x');
    System.out.println(Arrays.deepToString(actualResult2.getContent()));
    System.out.println(Arrays.deepToString(expectedResult2));
    assert Arrays.deepEquals(actualResult2.getContent(), expectedResult2);

    // Case 3: Out of boundary
    inputCanvas = new Canvas(5, 5);
    testInput = "L 2 1 2 10";
    try {
      command.input(testInput, inputCanvas);
    } catch (Exception e) {
      assert e.getMessage().equals("This line cannot be added into this canvas");
    }
  }
}
