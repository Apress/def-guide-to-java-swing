import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFocus {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Focus Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton focusButton = new JButton("Focused");
        JButton notFocusButton = new JButton("Not Focused");

        frame.setLayout(new FlowLayout());
        frame.add(focusButton);
        frame.add(notFocusButton);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
