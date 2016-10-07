import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;

public class NavigationSample {
  private static final String START_STRING = "Start\n";
  private static final int START_STRING_LENGTH = START_STRING.length();

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Navigation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea(START_STRING);
        textArea.setCaretPosition(START_STRING_LENGTH);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        NavigationFilter filter = new NavigationFilter() {
          public void setDot(NavigationFilter.FilterBypass fb, int dot,
              Position.Bias bias) {
            if (dot < START_STRING_LENGTH) {
              fb.setDot(START_STRING_LENGTH, bias);
            } else {
              fb.setDot(dot, bias);
            }
          }
          public void moveDot(NavigationFilter.FilterBypass fb, int dot,
              Position.Bias bias) {
            if (dot < START_STRING_LENGTH) {
              fb.setDot(START_STRING_LENGTH, bias);
            } else {
              fb.setDot(dot, bias);
            }
          }
        };

        textArea.setNavigationFilter(filter);

        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
