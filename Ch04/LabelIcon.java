import javax.swing.*;
import java.awt.*;

public class LabelIcon {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Label Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Icon icon = new DiamondIcon(Color.RED, true, 25, 25);
        JLabel label1 = new JLabel(icon);
        frame.add(label1);

        frame.setSize(200, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
