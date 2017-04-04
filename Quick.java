/* Project Title: Quick class
* Description: One of four subclasses under Sort that illustrate how each sort works.
*
* Created by: Herbie, Amanda
* Date: 3/30/17
*/
import java.awt.Color;
import java.util.Arrays;

public class Quick extends Sort {
  private int computations;
  public Quick(int w, int h, int n) {
    super(w, h, n);
    computations = 0;
  }

  public void drawBars(Bar[] bars) {
    StdDraw.clear(Color.BLACK);
    StdDraw.setPenColor(Color.RED);
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -50,"Quick Sort");
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -100,"Computations made:" + computations );
    super.drawBars(bars);
  }

  public void quickSort(Bar[] bars) {
    quickSortHelper(bars, 0, bars.length-1);
    for(int l = 0; l < bars.length; l++){
      bars[l].setColor(Color.WHITE);
    }
    drawBars(bars);
  }

  public void quickSortHelper(Bar[] bars, int from, int to) {
    int locator = 0;
    if (from >= to) {
      return;
    }
    int p = (from + to) / 2;  // choose pivot
    //Shows pivot
    locator = p;
    bars[locator].setColor(Color.GREEN);
    drawBars(bars);

    int i = from;
    int j = to;
    while (i <= j) {
      if (bars[i].compareTo(bars[p]) <= 0) {
        i++;
      }
      else if (bars[j].compareTo(bars[p]) >= 0) {
        j--;
      }
      else {
        swap(bars, i, j);
        i++;
        j--;
      }
      computations++;
    }
    //finish partitioning
    if (p < j) {
      swap(bars, j, p);
      p = j;
      locator = j;
      computations++;
    }
    else if (p > i) {
      swap(bars, i, p);
      p = i;
      locator = i;
      computations++;
    }
    //Updates graphics
    drawBars(bars);
    bars[locator].setColor(Color.RED);
    quickSortHelper(bars, from, p-1);
    quickSortHelper(bars, p + 1, to);
  }

  public void swap(Bar[] bars, int i, int j) {
    Bar temp = bars[i];
    bars[i] = bars[j];
    bars[j] = temp;
  }
}
