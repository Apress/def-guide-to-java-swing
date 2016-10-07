import javax.swing.*;
import java.awt.*;

public class TooltipSample {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Tooltip Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setToolTipText("<HtMl>Tooltip<br>Message");
        frame.add(panel, BorderLayout.CENTER);

        JButton button = new JButton("Hello, World") {
          public JToolTip createToolTip() {
            JToolTip tip = super.createToolTip();
            tip.setBackground(Color.YELLOW);
            tip.setForeground(Color.RED);
            return tip;
          }
          public boolean contains(int x, int y) {
            if (x < 100) {
              setToolTipText("Got Green Eggs?");
            } else {
              setToolTipText("Got Ham?");
            }
            return super.contains(x, y);
          }
        };
        button.setToolTipText("Hello, World");
        frame.add(button, BorderLayout.NORTH);

        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

