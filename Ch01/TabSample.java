import java.awt.*;
import javax.swing.*;

public class TabSample {
  static void addIt (JTabbedPane tabbedPane, String text) {
    JLabel label = new JLabel(text);
    JButton button = new JButton(text);
    JPanel panel = new JPanel();
    panel.add(label);
    panel.add(button);
    tabbedPane.addTab(text, panel);
  }
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JTabbedPane Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        addIt(tabbedPane, "Tab One");
        addIt(tabbedPane, "Tab Two");
        addIt(tabbedPane, "Tab Three");
        addIt(tabbedPane, "Tab Four");
        addIt(tabbedPane, "Tab Five");
        f.add(tabbedPane, BorderLayout.CENTER);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
