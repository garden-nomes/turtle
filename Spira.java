import javax.swing.*;
import java.awt.*;

public class Spira {

  public static void main(String[] args) {
    Turtle t = new Turtle(800, 800, 200, 700);

    double decay = 0.95;
    double step = 200;
    double angle = Math.PI / 6;

    while (step > 1) {
      t.goForward(step);
      t.turnLeft(angle);

      step *= decay;
    }

    JFrame f = new JFrame();
    f.getContentPane().add(t);
    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
