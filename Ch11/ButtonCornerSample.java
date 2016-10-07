import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonCornerSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Cornering Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon acrossLogo = new ImageIcon("logo-across.jpg");
        Icon downLogo = new ImageIcon("logo-down.jpg");
        Icon bookCover = new ImageIcon("jbuilder-big.jpg");
        JLabel columnLabel = new JLabel(acrossLogo);
        JLabel rowLabel = new JLabel(downLogo);
        JLabel coverLabel = new JLabel(bookCover);
        JButton button = new JButton("+");
        button.setFont(new Font("Monospaced", Font.PLAIN, 8));
        JScrollPane scrollPane = new JScrollPane(coverLabel);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, button);
        scrollPane.setColumnHeaderView(columnLabel);
        scrollPane.setRowHeaderView(rowLabel);

        ActionListener actionListener = new JScrollPaneToTopAction(scrollPane);
        button.addActionListener(actionListener);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
