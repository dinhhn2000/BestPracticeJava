package UtilsTest;

import Utils.Helpers;
import org.junit.jupiter.api.Test;

public class HelperTest {
  @Test
  public void convertStringToInteger() throws Exception {
    String input = "123";
    assert Helpers.convertStringToInteger(input) == 123;

    input = "-987654321";
    assert Helpers.convertStringToInteger(input) == -987654321;
  }

  @Test
  public void convertInvalidStringToInteger() {
    String input = null;
    // Case string contains letters
    try {
      input = "INVALID";
      Helpers.convertStringToInteger(input);
    } catch (Exception e) {
      assert e.getMessage().equals("Cannot convert String " + input + " to Integer");
    }
    // Case string is float
    try {
      input = "123.456";
      Helpers.convertStringToInteger(input);
    } catch (Exception e) {
      assert e.getMessage().equals("Cannot convert String " + input + " to Integer");
    }
  }
}
