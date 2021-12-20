package Dimension;

import java.util.ArrayList;

public abstract class Geometry {
  private String type = "GEOMETRY";
  public static final String LINE = "line";
  public static final String RECTANGLE = "rectangle";

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public abstract ArrayList<Point> getAllPoints();
}
