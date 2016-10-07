import java.awt.*;
import javax.swing.*;

public class PasswordSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JPasswordField Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box rowOne = Box.createHorizontalBox();
        rowOne.add(new JLabel("Username"));
        rowOne.add(new JTextField());
        Box rowTwo = Box.createHorizontalBox();
        rowTwo.add(new JLabel("Password"));
        rowTwo.add(new JPasswordField());
        f.add(rowOne, BorderLayout.NORTH);
        f.add(rowTwo, BorderLayout.SOUTH);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
