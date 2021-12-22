import Utils.Helpers;
import org.junit.jupiter.api.Test;

public class HelperTest {
  @Test
  void convertInvalidStringToInteger() {
    String input = "INVALID";
    try {
      Helpers.convertStringToInteger(input);
    } catch (Exception e) {
      assert e.getMessage().equals("Cannot convert String " + input + " to Integer");
    }
  }
}
