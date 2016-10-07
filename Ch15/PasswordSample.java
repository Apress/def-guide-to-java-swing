import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Password Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel userPanel = new JPanel(new BorderLayout());
        JLabel userLabel = new JLabel("Username: ");
        userLabel.setDisplayedMnemonic(KeyEvent.VK_U);
        JTextField userTextField = new JTextField();
        userLabel.setLabelFor(userTextField);
        userPanel.add(userLabel, BorderLayout.WEST);
        userPanel.add(userTextField, BorderLayout.CENTER);

        JPanel passPanel = new JPanel(new BorderLayout());
        JLabel passLabel = new JLabel("Password: ");
        passLabel.setDisplayedMnemonic(KeyEvent.VK_P);
        JPasswordField passTextField = new JPasswordField();
        passLabel.setLabelFor(passTextField);
        passPanel.add(passLabel, BorderLayout.WEST);
        passPanel.add(passTextField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(userPanel, BorderLayout.NORTH);
        panel.add(passPanel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.NORTH);

        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
