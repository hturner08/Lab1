import java.awt.Color;
import java.util.*;
import java.util.ArrayList;

public class Draw{
  public static void main(String[] args) {
    int canvasWidth = 800;
    int canvasHeight = 400;
    int numBarsSlow = 50;  // you'll see why you need this later
    int numBarsFast = 200;  // you'll see why you need this later
    StdDraw.clear(Color.BLACK);  // sets background to black
    StdDraw.enableDoubleBuffering(); // turns on animation because we will be animating

    StdDraw.setCanvasSize(canvasWidth, canvasHeight);
    StdDraw.setPenColor(StdDraw.RED);
    // sets up window such that (0,0) is lower left hand corner; (canvasWidth, canvasHeight) is upper right hand corner
    StdDraw.setXscale(0, canvasWidth);
    StdDraw.setYscale(0, canvasHeight);

    ArrayList<Bar> bars = new ArrayList<Bar>();
    for(int i = 0; i < numBarsSlow; i++){
      bars.add(new Bar(2*(i+1),2,Color.RED));
    }
    Bar[] bars2 = new Bar[numBarsFast];
    for(int i = 0; i < numBarsFast;i++){
      bars2[i] = new Bar(2*(i+1),2,Color.RED);
    }

    Insertion test = new Insertion(canvasWidth, canvasHeight, numBarsSlow);
    Collections.shuffle(bars);
    test.drawBars(bars);
    test.insertionSort(bars);
    test.drawBars(bars);

  }
}
