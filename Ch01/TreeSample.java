import java.awt.*;
import javax.swing.*;

public class TreeSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JTree Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTree tree = new JTree();
        JScrollPane scrollPane = new JScrollPane(tree);
        f.add(scrollPane, BorderLayout.CENTER);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
