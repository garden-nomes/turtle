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

  public Turtle(int width, int height, int x1, int y1) {
    setPreferredSize(new Dimension(width, height));

    lines = new ArrayList<Line>();
    x = x1;
    y = y1;
    angle = 0.0;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Line l : lines) {
      g.drawLine((int)l.x1, (int)l.y1, (int)l.x2, (int)l.y2);
    }
  }

  public void turnLeft(double delta) {
    angle += delta;

    if (angle > 2 * Math.PI) {
      angle -= 2 * Math.PI;
    }
  }

  public void goForward(double step) {
    Line l = new Line();
    l.x1 = x;
    l.y1 = y;

    x += Math.cos(angle) * step;
    y -= Math.sin(angle) * step;

    l.x2 = x;
    l.y2 = y;

    lines.add(l);
  }
}
