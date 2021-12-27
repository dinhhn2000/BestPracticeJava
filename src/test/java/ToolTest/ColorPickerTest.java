package ToolTest;

import DrawingTool.ColorPicker;
import Interface.Canvas;
import org.junit.jupiter.api.Test;

public class ColorPickerTest {
  @Test
  public void testDrawFunction() throws Exception {
    assert new ColorPicker().draw(new Canvas(1, 1), new Object()) == null;
  }
}
