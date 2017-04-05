/* Project Title: Draw class
* Description: This is the class used to run the program on terminal. It contains
* the main method that runs insertion, selection, merge, and quick sort, in that order.
*
* Created by: Amanda, Herbie
* Date: 4/4/17
*/

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
      bars.add(new Bar(5*(i+5),2,Color.RED));
    }
    Bar[] bars2 = new Bar[numBarsSlow];
    // for(int i = 0; i < numBarsFast;i++){
    //   bars2[i] = new Bar(5*(i+5),2,Color.RED);
    // }

    //Insertion sorter
    Insertion test0 = new Insertion(canvasWidth, canvasHeight, numBarsSlow);
    Collections.shuffle(bars);
    for(int i = 0; i < bars.size(); i++)
      bars.get(i).setColor(Color.RED);
    test0.drawBars(bars);
    test0.insertionSort(bars);

    StdDraw.pause(1000);

    // Selection sorter
    Selection test1 = new Selection(canvasWidth, canvasHeight, numBarsSlow);
    Collections.shuffle(bars);
    for(int i = 0; i < bars.size(); i++)
      bars.get(i).setColor(Color.RED);
    test1.drawBars(bars);
    test1.selectionSort(bars);

    //Merge sorter
    Merge test2 = new Merge(canvasWidth, canvasHeight, numBarsSlow);
    Collections.shuffle(bars);
    int counter = 0;
    for(Bar b : bars){
      bars2[counter] = b;
      bars2[counter].setColor(Color.RED);
      counter++;
    }
    test2.drawBars(bars2);
    test2.mergeSort(bars2);

    StdDraw.pause(1000);

    //Quick sorter
    Quick test3 = new Quick(canvasWidth, canvasHeight, numBarsSlow);
    Collections.shuffle(bars);
    counter = 0;
    for(Bar b : bars){
      bars2[counter] = b;
      bars2[counter].setColor(Color.RED);
      counter++;
    }
    test3.drawBars(bars2);
    test3.quickSort(bars2);
  }
}
