import javax.swing.*;
import java.awt.*;
import java.util.*;

public class LSystem extends Turtle {
  public static final int sideLength = 3;

  private String sequence;

  public LSystem(int n) {
    super(850, 800, 300, 600);
    sequence = growSequence("FX", n);
    run(sequence);
  }

  public String growSequence(String s, int n) {
    String s2 = "";

    for (char c : s.toCharArray()) {
      switch (c) {
        case 'X':
          s2 += "X+YF+";
          break;
        case 'Y':
          s2 += "-FX-Y";
          break;
        default:
          s2 += c;
          break;
      }
    }

    if (n > 0) {
      return growSequence(s2, n - 1);
    } else {
      return s2;
    }
  }

  public void run(String s) {
    for (char c : s.toCharArray()) {
      switch (c) {
        case 'F':
          goForward(sideLength);
          break;
        case '-':
          turnLeft(Math.PI / 2);
          break;
        case '+':
          turnLeft(3 * Math.PI / 2);
          break;
        default:
          break;
      }
    }
  }

  public static void main(String[] args) {
    LSystem s = new LSystem(14);

    JFrame f = new JFrame();
    f.getContentPane().add(s);
    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
