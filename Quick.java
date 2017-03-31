/* Project Title: Quick class
* Description: One of four subclasses under Sort that illustrate how each sort works.
*
* Created by: Herbie, Amanda
* Date: 3/30/17
*/
import java.awt.Color;
import java.util.Arrays;

public class Quick extends Sort {

  public Quick(int w, int h, int n) {
    super(w, h, n);
  }

  public void drawBars(Bar[] bars) {
    StdDraw.clear(Color.BLACK);
    StdDraw.setPenColor(Color.RED);
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -50,"Quick Sort");
    super.drawBars(bars);
  }

  public void quickSort(Bar[] bars) {
    quickSortHelper(bars, 0, bars.length-1);
  }

  public void quickSortHelper(Bar[] bars, int from, int to) {
    if (from >= to) {
      return;
    }
    int p = (from + to) / 2;  // choose pivot

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
    }
    //finish partitioning
    if (p < j) {
      swap(bars, j, p);
      p = j;
    }
    else if (p > i) {
      swap(bars, i, p);
      p = i;
    }

    quickSortHelper(bars, from, p-1);
    quickSortHelper(bars, p + 1, to);
  }

  public void swap(Bar[] bars, int i, int j) {
    Bar temp = bars[i];
    bars[i] = bars[j];
    bars[j] = temp;
  }
}
