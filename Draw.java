import java.awt.Color;

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

  }
}
