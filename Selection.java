/* Project Title: Selection class
* Description: One of four subclasses under Sort that illustrate how each sort works.
*
* Created by: Herbie, Amanda
* Date: 3/30/17
*/

import java.util.ArrayList;
import java.awt.Color;

public class Selection extends Sort {

  public Selection(int w, int h, int n) {
    super(w, h, n);
  }

  public void drawBars(ArrayList<Bar> bars) {
    StdDraw.clear(Color.BLACK);
    StdDraw.setPenColor(Color.RED);
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -50,"Selection Sort");
    super.drawBars(bars);
  }

  public void selectionSort(ArrayList<Bar> bars) {
    for (int i = 0; i < bars.size(); i++) {
      int first = i;

      // find min (Blue = current, Green = current min)
      for (int j = i + 1; j < bars.size(); j++) {
        if (bars.get(j).compareTo(bars.get(first)) < 0) {
          first = j;
        }
      }

      // swap!
      Bar temp = bars.get(first);
      bars.set(first, bars.get(i));
      bars.set(i, temp);
    }
  }
}
