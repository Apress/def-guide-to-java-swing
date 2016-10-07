import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class ATitledBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Titled Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border thisBorder = BorderFactory.createTitledBorder("Easy");
        Icon thatIcon = new ImageIcon("diamond.gif");
        Border thatBorder1 = new MatteBorder(18, 20, 18, 20, thatIcon);
        Border thatBorder2 = new TitledBorder (thatBorder1, "Harder");
        Font font = new Font("Serif", Font.ITALIC, 12);
        Border thatBorder = new TitledBorder(thatBorder2, "Harder", TitledBorder.LEFT, TitledBorder.ABOVE_BOTTOM, font, Color.RED);
        JButton thisButton = new JButton("Easy");
        thisButton.setBorder(thisBorder);
        JButton thatButton = new JButton("Harder");
        thatButton.setBorder(thatBorder);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));
        contentPane.add(thisButton);
        contentPane.add(thatButton);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

