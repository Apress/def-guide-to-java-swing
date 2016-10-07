import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlignmentSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Alignment Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        JTextField textField = new JTextField("Left");
        textField.setHorizontalAlignment(JTextField.LEFT);
        frame.add(textField);
        textField = new JTextField("Center");
        textField.setHorizontalAlignment(JTextField.CENTER);
        frame.add(textField);
        textField = new JTextField("Right");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField);
        textField = new JTextField("Leading");
        textField.setHorizontalAlignment(JTextField.LEADING);
        frame.add(textField);
        textField = new JTextField("Trailing");
        textField.setHorizontalAlignment(JTextField.TRAILING);
        frame.add(textField);
        frame.pack();
        frame.setSize(250, (int)frame.getSize().getHeight());
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
