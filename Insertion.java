import java.util.ArrayList;
import java.awt.Color;

public class Insertion extends Sort {
  public Insertion(int w, int h, int n) {
    super(w, h, n);
  }

  public void drawBars(ArrayList<Bar> bars) {
    // Write this...
  }

  public void insertionSort(ArrayList<Bar> bars) {
    for (int i = 1; i < bars.size(); i++) {
      // save next element to be inserted
      Bar temp = bars.get(i);

      // go back from bars.get(n-1), find insertion spot
      // bars.get(i) <= temp
      int count = i;
      while (count > 0 && temp.compareTo(bars.get(count - 1)) < 0) {
        count--;
      }

      // shift elements from i to count
      for (int j = i; j > count; j--) {
        bars.set(j, bars.get(j-1));
      }
      bars.set(count, temp);
    }
  }
}
