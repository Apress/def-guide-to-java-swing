import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class ColorMatteBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Color Matted Border");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border solidBorder = new MatteBorder(10, 5, 2, 20, Color.RED);
        JButton solidButton = new JButton("10x5x2x20");
        solidButton.setBorder(solidBorder);
        Container contentPane = frame.getContentPane();
        contentPane.add(solidButton, BorderLayout.CENTER);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

