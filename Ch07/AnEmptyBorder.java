import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class AnEmptyBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Empty Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 0, 0);
        JButton emptyButton = new JButton("With Empty");
        emptyButton.setBorder(emptyBorder);
        JButton nonemptyButton = new JButton("Without Empty");
        Container contentPane = frame.getContentPane();
        contentPane.add(emptyButton, BorderLayout.NORTH);
        contentPane.add(nonemptyButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(300, frame.getHeight());
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
