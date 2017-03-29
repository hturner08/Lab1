import java.awt.Color;

public class Merge extends Sort {
  private Bar[] temp; // used for extra space

  public Merge(int w, int h, int n) {
    super(w, h, n);
  }

  public void drawBars(Bar[] bars) {
    // You write this!
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
      }
    }
    else {
      int middle = (from + to) / 2;
      mergeSortHelper(bars, from, middle);
      mergeSortHelper(bars, middle + 1, to);
      merge(bars, from, middle, to);
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
  }
}