import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Label Focus Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Name: ");
        label.setDisplayedMnemonic(KeyEvent.VK_N);
        JTextField textField = new JTextField();
        label.setLabelFor(textField);
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JButton("Somewhere Else"), BorderLayout.SOUTH);
        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
