import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class ALineBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Line Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border thinBorder = LineBorder.createBlackLineBorder();
        Border thickBorder = new LineBorder(Color.WHITE, 12);
        Border roundedBorder = new LineBorder(Color.BLACK, 12, true);
        JButton thinButton = new JButton("1 Pixel");
        thinButton.setBorder(thinBorder);
        JButton thickButton = new JButton("12 Pixel");
        thickButton.setBorder(thickBorder);
        JButton roundedButton = new JButton("Rounded 12 Pixel");
        roundedButton.setBorder(roundedBorder);
        Container contentPane = frame.getContentPane();
        contentPane.add(thinButton, BorderLayout.NORTH);
        contentPane.add(thickButton, BorderLayout.CENTER);
        contentPane.add(roundedButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(300, frame.getHeight());
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

