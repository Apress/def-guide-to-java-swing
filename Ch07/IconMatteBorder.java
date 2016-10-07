import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class IconMatteBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Icon Matted Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon diamondIcon = new DiamondIcon(Color.RED, true, 10, 10);
        Border diamondBorder = new MatteBorder(10, 10, 10, 10, diamondIcon);
        JButton diamondButton = new JButton("diamonds");
        diamondButton.setBorder(diamondBorder);
        Icon diamondIcon2 = new ImageIcon("diamond.gif");
        Border diamondBorder2 = new MatteBorder(36, 40, 36, 40, diamondIcon2);
        JButton diamondButton2 = new JButton("diamonds2");
        diamondButton2.setBorder(diamondBorder2);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(2, 1));
        contentPane.add(diamondButton);
        contentPane.add(diamondButton2);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

