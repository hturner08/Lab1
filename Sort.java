/* Project Title: Sort class
* Description: Provides a Sort constructor and helper methods, as well as the
* drawBars method that displays an array of bars on the screen.
*
* Created by: Amanda, Herbie
* Date: 3/29/17
*/

import java.util.ArrayList;

public class Sort {
  public int canvasWidth;
  public int canvasHeight;
  public int numBars;

  public Sort(int w, int h, int n) {
    canvasHeight = h;
    canvasWidth = w;
    numBars = n;
  }

  public int getCanvasWidth() {
    return canvasWidth;
  }

  public int getCanvasHeight() {
    return canvasHeight;
  }

  public int numBars() {
    return numBars;
  }

  public void drawBars(ArrayList<Bar> bars) {
    Bar test = bars.get(0);
    int totwidth = bars.size() * test.getWidth(); // assuming bars are of the same width
    int blankdiff = (canvasWidth - totwidth)/bars.size();
    int currx = 0;
    for (Bar b : bars) {
      StdDraw.setPenColor(b.getColor());
      StdDraw.filledRectangle(currx + b.getWidth()/2, b.getHeight()/2, b.getWidth()/2, b.getHeight()/2);
      StdDraw.pause(3);
      currx += b.getWidth() + blankdiff;
    }
    StdDraw.show();
  }

  public void drawBars(Bar[] bars) {
    Bar test = bars[0];
    int totwidth = bars.length * test.getWidth(); // assuming bars are of the same width
    int blankdiff = (canvasWidth - totwidth)/bars.length;
    int currx = 0;
    for (Bar b : bars) {
      StdDraw.setPenColor(b.getColor());
      StdDraw.filledRectangle(currx + b.getWidth()/2, b.getHeight()/2, b.getWidth()/2, b.getHeight()/2);
      StdDraw.show();
      StdDraw.pause(100);
      currx += b.getWidth() + blankdiff;
    }
  }
}
