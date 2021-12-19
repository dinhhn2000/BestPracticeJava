
public class Canvas {
  private final int width;
  private final int height;

  public Canvas(int w, int h) throws Exception {
    if (w <= 0 || h <= 0) {
      throw new Exception("Invalid width or height");
    }
    this.width = w;
    this.height = h;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }


}
