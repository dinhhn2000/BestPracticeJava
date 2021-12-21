package Utils;

public class Helpers {
  public static int convertStringToInteger(String str) throws Exception {
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      throw new Exception("Cannot convert String " + str + " to Integer");
    }
  }
}
