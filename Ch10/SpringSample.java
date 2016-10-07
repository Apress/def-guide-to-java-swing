import java.awt.*;
import javax.swing.*;

public class SpringSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("SpringLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();

        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        Component left = new JLabel("Left");
        Component right = new JTextField(15);

        contentPane.add(left);
        contentPane.add(right);

        layout.putConstraint(SpringLayout.WEST,  left, 10,
          SpringLayout.WEST,  contentPane);
        layout.putConstraint(SpringLayout.NORTH, left, 25,
          SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, right, 25,
          SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, right, 20,
          SpringLayout.EAST, left);

        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
