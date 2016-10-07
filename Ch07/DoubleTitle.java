import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class DoubleTitle {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Double Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TitledBorder topBorder = BorderFactory.createTitledBorder("Top");
        topBorder.setTitlePosition(TitledBorder.TOP);
        TitledBorder doubleBorder = new TitledBorder(topBorder, "Bottom",
          TitledBorder.RIGHT, TitledBorder.BOTTOM);
        JButton doubleButton = new JButton();
        doubleButton.setBorder(doubleBorder);
        Container contentPane = frame.getContentPane();
        contentPane.add(doubleButton, BorderLayout.CENTER);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
