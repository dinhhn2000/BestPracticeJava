import org.junit.jupiter.api.Test;

public class CanvasTest {
  @Test
  void initCanvas() throws Exception {
    int width = 12;
    int height = 24;
    Canvas canvas = new Canvas(width, height);
    assert canvas.getWidth() == width;
    assert canvas.getHeight() == height;

    try {
      new Canvas(-1, 50);
    } catch (Exception e) {
      assert e.getMessage().equals("Invalid width or height");
    }
  }
}
