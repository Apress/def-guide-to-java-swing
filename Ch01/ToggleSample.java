import java.awt.*;
import javax.swing.*;

public class ToggleSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JToggleButton Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JToggleButton("North"), BorderLayout.NORTH);
        f.add(new JToggleButton("East"), BorderLayout.EAST);
        f.add(new JToggleButton("West"), BorderLayout.WEST);
        f.add(new JToggleButton("Center"), BorderLayout.CENTER);
        f.add(new JToggleButton("South"), BorderLayout.SOUTH);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
