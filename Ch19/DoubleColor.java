import javax.swing.*;
import java.awt.*;

public class DoubleColor {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Double Color Choosers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JColorChooser left = new JColorChooser();
        left.setDragEnabled(true);
        frame.add(left, BorderLayout.WEST);

        JColorChooser right = new JColorChooser();
        right.setDragEnabled(true);
        frame.add(right, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
