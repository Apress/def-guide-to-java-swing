import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;	

public class AProgressBar {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("ProgressBars R Us");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JProgressBar aJProgressBar = new JProgressBar();
        aJProgressBar.setValue(50);
        JProgressBar bJProgressBar = new JProgressBar();
        bJProgressBar.setValue(25);
        bJProgressBar.setStringPainted(true);
        Border border = BorderFactory.createTitledBorder("Reading File");
        bJProgressBar.setBorder(border);
        JProgressBar cJProgressBar = new JProgressBar(JProgressBar.VERTICAL);
        cJProgressBar.setValue(75);
        cJProgressBar.setBorderPainted(false);

        JProgressBar dJProgressBar = new JProgressBar(JProgressBar.VERTICAL);
        dJProgressBar.setValue(100);
        dJProgressBar.setString("Ack");
        dJProgressBar.setStringPainted(true);

        frame.add(aJProgressBar, BorderLayout.NORTH);
        frame.add(bJProgressBar, BorderLayout.SOUTH);
        frame.add(cJProgressBar, BorderLayout.EAST);
        frame.add(dJProgressBar, BorderLayout.WEST);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
