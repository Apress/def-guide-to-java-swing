import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class LabelFor {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("LabelFor Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Username");
        JTextField textField = new JTextField();
        label.setDisplayedMnemonic(KeyEvent.VK_U);
        label.setLabelFor(textField);
        Container box = Box.createHorizontalBox();
        box.add(label);
        box.add(textField);
        frame.add(box, BorderLayout.NORTH);
        frame.add(new JButton("Submit"), BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
