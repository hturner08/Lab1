/* Project Title: Insertion class
* Description: One of four subclasses under Sort that illustrate how each sort works.
*
* Created by: Herbie, Amanda
* Date: 3/30/17
*/

import java.util.ArrayList;
import java.awt.Color;


public class Insertion extends Sort {
  private int computations;
  public Insertion(int w, int h, int n) {
    super(w, h, n);
    computations = 0;
  }

  public void drawBars(ArrayList<Bar> bars) {
    StdDraw.clear(Color.BLACK);
    StdDraw.setPenColor(Color.RED);
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -50,"Insertion Sort");
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -100,"Computations made:" + computations);
    super.drawBars(bars);
  }

  public void insertionSort(ArrayList<Bar> bars) {

    for (int i = 1; i < bars.size(); i++) {
      // save next element to be inserted
      Bar temp = bars.get(i);
      temp.setColor(Color.BLUE);

      // go back from bars.get(n-1), find insertion spot
      // bars.get(i) <= temp
      int count = i;
      while (count > 0 && temp.compareTo(bars.get(count - 1)) < 0) {
        count--;
        computations++;
      }
      Bar b = bars.get(bars.size()-1);

      // shift elements from i to count
      for (int j = i; j > count; j--) {
        b = bars.get(j-1);
        // b.setColor(Color.BLUE);
        bars.set(j, bars.get(j-1));
      }
      // temp.setColor(Color.GREEN);
      bars.set(count, temp);
      drawBars(bars);
      temp.setColor(Color.RED);
    }
    StdDraw.pause(100);
    for(int i = 0; i < bars.size(); i++)
      bars.get(i).setColor(Color.WHITE);
    drawBars(bars);
  }
}
