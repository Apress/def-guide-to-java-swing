import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class AnEtchedBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Etched Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border raisedBorder = new EtchedBorder(EtchedBorder.RAISED);
        Border loweredBorder = new EtchedBorder(EtchedBorder.LOWERED);
        JButton raisedButton = new JButton("Raised");
        raisedButton.setBorder(raisedBorder);
        JButton loweredButton = new JButton("Lowered");
        loweredButton.setBorder(loweredBorder);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout (new GridLayout(1, 2, 5, 5));
        contentPane.add(raisedButton);
        contentPane.add(loweredButton);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
