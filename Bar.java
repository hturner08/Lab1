/* Project Title: Bar class
* Description: Basic methods and constructors for making and using Bars.
*
* Created by: Amanda, Herbie
* Date: 3/29/17
*/

public class Bar implements Comparable<Bar> {
  public int height;
  public int width;
  Color color;

  public Bar(int h, int w, Color c) {
    height = h;
    width = w;
    color = c;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color c) {
    color = c;
  }

  public int compareTo(Bar other) {
    return this.height - other.height;
  }

  public String toString() {
    String s = "(" + height + ", " + width ", " + color + ")";
    return s;
  }
}
