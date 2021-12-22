import Interface.Canvas;
import Interface.Command;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input;
    Canvas canvas = null;
    Command command = new Command();

    while (true) {
      try {
        command.printGreetingMessage();
        input = scanner.nextLine();
        canvas = command.input(input, canvas);
        if (canvas != null) canvas.render();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

  }
}
