/* Project Title: Selection class
* Description: One of four subclasses under Sort that illustrate how each sort works.
*
* Created by: Amanda, Herbie
* Date: 3/30/17
*/

import java.util.ArrayList;
import java.awt.Color;

public class Selection extends Sort {
  private int computations;
  public Selection(int w, int h, int n) {
    super(w, h, n);
    computations = 0;
  }

  public void drawBars(ArrayList<Bar> bars) {
    StdDraw.clear(Color.BLACK);
    StdDraw.setPenColor(Color.RED);
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -50,"Selection Sort");
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -100,"Computations made:" + computations);
    super.drawBars(bars);
  }

  public void selectionSort(ArrayList<Bar> bars) {
    for (int i = 0; i < bars.size(); i++) {
      int min = i;

      // find min (Blue = current, Green = current min)
      for (int j = i + 1; j < bars.size(); j++) {
        computations++;
        if (bars.get(j).compareTo(bars.get(min)) < 0) {
          min = j;
        }
      }

      // swap!
      Bar temp = bars.get(min);
      temp.setColor(Color.BLUE);
      Bar init = bars.get(i);
      init.setColor(Color.WHITE);
      bars.set(min, init);
      bars.set(i, temp);
      drawBars(bars);
      temp.setColor(Color.RED);
      init.setColor(Color.RED);
    }
    for(int i = 0; i < bars.size(); i++)
      bars.get(i).setColor(Color.WHITE);
    drawBars(bars);
  }
}
