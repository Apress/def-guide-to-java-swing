import javax.swing.*;
import java.awt.*;

public class CornerSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Cornering Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon miniLogo = new ImageIcon("logo.gif");
        Icon acrossLogo = new ImageIcon("logo-across.jpg");
        Icon downLogo = new ImageIcon("logo-down.jpg");
        Icon bookCover = new ImageIcon("jbuilder.jpg");
        JLabel logoLabel = new JLabel(miniLogo);
        JLabel columnLabel = new JLabel(acrossLogo);
        JLabel rowLabel = new JLabel(downLogo);
        JLabel coverLabel = new JLabel(bookCover);
        JScrollPane scrollPane = new JScrollPane(coverLabel);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, logoLabel);
        scrollPane.setColumnHeaderView(columnLabel);
        scrollPane.setRowHeaderView(rowLabel);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(150, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

