import java.awt.*;
import javax.swing.*;

public class AdornSample2 {

  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Adornment Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
