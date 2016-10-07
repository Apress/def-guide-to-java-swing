import javax.swing.*;
import java.awt.*;

public class SplitSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame vFrame = new JFrame("JSplitPane Sample");
        vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane vSplitPane = new JSplitPane();
        vSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        vFrame.add(vSplitPane, BorderLayout.CENTER);
        vFrame.setSize(300, 150);
        vFrame.setVisible(true);

        JFrame hFrame = new JFrame("JSplitPane Sample");
        vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane hSplitPane = new JSplitPane();
        hFrame.add(hSplitPane, BorderLayout.CENTER);
        hFrame.setSize(300, 150);
        hFrame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
