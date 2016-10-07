import java.awt.*;
import javax.swing.*;

public class AdornSample {

  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Adornment Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setUndecorated(true);
	frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

