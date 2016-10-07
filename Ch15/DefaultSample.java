import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class DefaultSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Default Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            System.out.println(actionEvent.getActionCommand() + " selected");
          }
        };

        JPanel panel = new JPanel();
        JButton defaultButton = new JButton("Default Button");
        defaultButton.addActionListener(actionListener);
        panel.add(defaultButton);

        JButton otherButton = new JButton("Other Button");
        otherButton.addActionListener(actionListener);
        panel.add(otherButton);

        frame.add(panel, BorderLayout.SOUTH);

        Keymap keymap = textField.getKeymap();
        KeyStroke keystroke =
          KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        keymap.removeKeyStrokeBinding(keystroke);

        frame.getRootPane().setDefaultButton(defaultButton);

        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
