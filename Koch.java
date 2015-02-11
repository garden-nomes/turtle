import javax.swing.*;
import java.awt.*;

public class Koch {

  public static void main(String[] args) {
    double sideLength = 500;
    int n;
    if (args.length > 0) {
      n = Integer.parseInt(args[0]);
    } else {
      n = 5;
    }

    Turtle t = new Turtle(800, 800, 400 - (int)sideLength / 2, 400 - (int)(sideLength / 2 * Math.sin(Math.PI / 3)) / 2);
    for (int i = 0; i < 3; i++) {
      koch(t, sideLength / Math.pow(3, n), n);
      t.turnLeft(4 * Math.PI / 3);
    }

    JFrame f = new JFrame();
    f.getContentPane().add(t);
    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void koch(Turtle t, double sideLength, int n) {
    if (n > 0) {
      koch(t, sideLength, n - 1);

      t.turnLeft(Math.PI / 3);

      koch(t, sideLength, n - 1);

      t.turnLeft(4 * Math.PI / 3);

      koch(t, sideLength, n - 1);

      t.turnLeft(Math.PI / 3);

      koch(t, sideLength, n - 1);
    } else {
      t.goForward(sideLength);
    }
  }
}
