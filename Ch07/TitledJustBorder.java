import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class TitledJustBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Justified Titled Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TitledBorder leftBorder = BorderFactory.createTitledBorder("Left");
        leftBorder.setTitleJustification(TitledBorder.LEFT);
        JButton leftButton = new JButton();
        leftButton.setBorder(leftBorder);
        TitledBorder rightBorder = BorderFactory.createTitledBorder("Right");
        rightBorder.setTitleJustification(TitledBorder.RIGHT);
        JButton rightButton = new JButton();
        rightButton.setBorder(rightBorder);
        TitledBorder centerBorder = BorderFactory.createTitledBorder("Center");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        JButton centerButton = new JButton();
        centerButton.setBorder(centerBorder);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        contentPane.add(leftButton);
        contentPane.add(rightButton);
        contentPane.add(centerButton);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
