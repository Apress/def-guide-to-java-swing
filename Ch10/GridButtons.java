import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class GridButtons {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final JFrame frame = new JFrame("GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 4));
        String months[] = new DateFormatSymbols().getMonths();
        for (int i = 0, n=months.length-1; i < n; i++) {
          JButton button = new JButton(months[i]);
          frame.add(button);
        }
        frame.setSize(500, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
