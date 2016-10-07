import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class ASoftBevelBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Soft Bevel Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        Border loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        JButton raisedButton = new JButton("Raised");
        raisedButton.setBorder(raisedBorder);
        JButton loweredButton = new JButton("Lowered");
        loweredButton.setBorder(loweredBorder);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout (new GridLayout(1, 2));
        contentPane.add(raisedButton);
        contentPane.add(loweredButton);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
