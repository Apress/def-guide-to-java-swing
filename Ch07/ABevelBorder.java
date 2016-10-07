import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class ABevelBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Bevel Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border raisedBorder = BorderFactory.createRaisedBevelBorder();
        Border loweredBorder = BorderFactory.createLoweredBevelBorder();
        Border myRaisedBorder =  BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.RED);
        Border myLoweredBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.PINK, Color.RED);
        JButton raisedButton = new JButton("Raised");
        raisedButton.setBorder(raisedBorder);
        JButton loweredButton = new JButton("Lowered");
        loweredButton.setBorder(loweredBorder);
        JButton myRaisedButton = new JButton("My Raised");
        myRaisedButton.setBorder(myRaisedBorder);
        JButton myLoweredButton = new JButton("My Lowered");
        myLoweredButton.setBorder(myLoweredBorder);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(2, 2, 5, 5));
        contentPane.add(raisedButton);
        contentPane.add(loweredButton);
        contentPane.add(myRaisedButton);
        contentPane.add(myLoweredButton);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
