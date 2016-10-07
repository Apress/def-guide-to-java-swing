import javax.swing.*;
import java.awt.*;

public class BoxSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame verticalFrame = new JFrame("Vertical");
        verticalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(new JLabel("Top"));
        verticalBox.add(new JTextField("Middle"));
        verticalBox.add(new JButton("Bottom"));
        verticalFrame.add(verticalBox, BorderLayout.CENTER);
        verticalFrame.setSize(150, 150);
        verticalFrame.setVisible(true);

        JFrame horizontalFrame = new JFrame("Horizontal");
        horizontalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(new JLabel("Left"));
        horizontalBox.add(new JTextField("Middle"));
        horizontalBox.add(new JButton("Right"));
        horizontalFrame.add(horizontalBox, BorderLayout.CENTER);
        horizontalFrame.setSize(150, 150);
        horizontalFrame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
