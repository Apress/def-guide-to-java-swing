import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;	

public class IndeterminateProgressBar {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Indeterminate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JProgressBar aJProgressBar = new JProgressBar();
	aJProgressBar.setIndeterminate(true);
        frame.add(aJProgressBar, BorderLayout.NORTH);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
