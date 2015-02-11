import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Turtle extends JPanel {
  private double x, y;      // PIXELS
  private double angle;     // RADIANS

  private class Line {
    public double x1, y1;
    public double x2, y2;
  }
  ArrayList<Line> lines;

  public Turtle(int width, int height) {
    setPreferredSize(new Dimension(width, height));

    lines = new ArrayList<Line>();
    x = (double)width / 2;
    y = (double)height / 2;
    angle = 0.0;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Line l : lines) {
      g.drawLine((int)l.x1, (int)l.y1, (int)l.x2, (int)l.y2);

      System.out.println("Drawing line: " + l.x1 + ", " + l.y1 +
        " to " + l.x2 + ", " + l.y2);
    }
  }

  private void turnLeft(double delta) {
    angle += delta;

    if (angle > 2 * Math.PI) {
      angle -= 2 * Math.PI;
    }
  }

  private void goForward(double step) {
    Line l = new Line();
    l.x1 = x;
    l.y1 = y;

    x += Math.cos(angle) * step;
    y -= Math.sin(angle) * step;

    l.x2 = x;
    l.y2 = y;

    lines.add(l);
  }

  public void test() {
    double step = 200;
    double decay = 0.9;

    while (step > 10) {
      goForward(step);
      turnLeft(Math.PI / 3);
      step *= decay;
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    Turtle t = new Turtle(500, 500);

    t.test();

    frame.getContentPane().add(t);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
