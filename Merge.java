/* Project Title: Merge class
* Description: One of four subclasses under Sort that illustrate how each sort works.
*
* Created by: Herbie, Amanda
* Date: 3/30/17
*/

import java.awt.Color;
import java.util.Arrays;

public class Merge extends Sort {
  private Bar[] temp; // used for extra space
  private int computations;
  public Merge(int w, int h, int n) {
    super(w, h, n);
    computations = 0;
  }

  public void drawBars(Bar[] bars) {
    StdDraw.clear(Color.BLACK);
    StdDraw.setPenColor(Color.RED);
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -50,"Merge Sort");
    StdDraw.text(getCanvasWidth()/2, getCanvasHeight() -100,"Computations made:" + computations);
    super.drawBars(bars);
  }

  public void mergeSort(Bar[] bars) {
    temp = new Bar[bars.length];
    mergeSortHelper(bars, 0, bars.length-1);
  }

  public void mergeSortHelper(Bar[] bars, int from, int to) {
    if (to - from < 2) {
      if (to > from && bars[to].compareTo(bars[from]) < 0) {
        //swap
        Bar temp = bars[to];
        bars[to] = bars[from];
        bars[from] = temp;
        computations++;
      }
    }
    else {
      int middle = (from + to) / 2;
      mergeSortHelper(bars, from, middle);
      mergeSortHelper(bars, middle + 1, to);
      merge(bars, from, middle, to);
      boolean check = true;
      int counter = 0 ;
      while(check){
        if(counter < 49){
          if(bars[counter].height > bars[counter+1].height)
            check=false;
          bars[counter].setColor(Color.WHITE);
          counter++;
        }
        else
          check = false;
      }
      drawBars(bars);
    }
  }

  public void merge(Bar[] bars, int from, int middle, int to) {
    int i = from;
    int j = middle + 1;
    int k = from;

    while (i <= middle && j <= to) {
      if (bars[i].compareTo(bars[j]) < 0) {
        temp[k] = bars[i];
        i++;
      }
      else {
        temp[k] = bars[j];
        j++;
      }
      computations++;
      k++;
    }

    // copy tail end of first half, if any, into temp
    while (i <= middle) {
      temp[k] = bars[i];
      i++;
      k++;
    }

    // copy tail "" second ""
    while (j <= to) {
      temp[k] = bars[j];
      j++;
      k++;
    }

    //copy temp back into a
    for (k = from; k <= to; k++) {
      bars[k] = temp[k];
    }
    for(int l = from; l < to; l++){
      bars[l].setColor(Color.BLUE);
    }
  }
}
