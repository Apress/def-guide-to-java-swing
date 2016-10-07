import java.awt.*;
import javax.swing.*;

public class SeparatorSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JSeparator Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        JLabel above = new JLabel("Above Separator");
        f.add(above);
        JSeparator separator = new JSeparator();
        f.add(separator);
        JLabel below = new JLabel("Below Separator");
        f.add(below);
        f.setSize (300, 100);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
