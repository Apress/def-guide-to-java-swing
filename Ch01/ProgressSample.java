import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ProgressSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JProgressBar Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(25);
        progressBar.setStringPainted(true);
        Border border = BorderFactory.createTitledBorder("Reading...");
        progressBar.setBorder(border);
        f.add(progressBar, BorderLayout.NORTH);
        f.setSize (300, 100);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
