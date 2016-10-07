import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Buttons {
  static int align = 0;
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final JFrame frame = new JFrame("FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        final ActionListener listener = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            // LEFT, CENTER, RIGHT are 0, 1, 2
            frame.setLayout(new FlowLayout((align++) % 3));
            frame.validate();
          }
        };
        String days[] = new DateFormatSymbols().getWeekdays();
        for (int i = 1, n=days.length; i < n; i++) {
          JButton button = new JButton(days[i]);
          button.addActionListener(listener);
          frame.add(button);
        }
        frame.setSize(500, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
