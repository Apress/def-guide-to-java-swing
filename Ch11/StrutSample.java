import javax.swing.*;
import java.awt.*;

public class StrutSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        Box horizontalBox;
        JPanel panel;
        JFrame frame = new JFrame("Horizontal Strut");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));

        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createHorizontalStrut(10));
        horizontalBox.add(new JButton("Left"));
        horizontalBox.add(new JButton("Middle"));
        horizontalBox.add(new JButton("Right"));
        panel = new JPanel(new BorderLayout());
        panel.add(horizontalBox);
        panel.setBorder(BorderFactory.createTitledBorder("Beginning Strut"));
        frame.add(panel);

        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(new JButton("Left"));
        horizontalBox.add(Box.createHorizontalStrut(10));
        horizontalBox.add(new JButton("Middle"));
        horizontalBox.add(Box.createHorizontalStrut(25));
        horizontalBox.add(new JButton("Right"));
        panel = new JPanel(new BorderLayout());
        panel.add(horizontalBox);
        panel.setBorder(BorderFactory.createTitledBorder("2 Middle Struts"));
        frame.add(panel);

        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createHorizontalStrut(25));
        horizontalBox.add(new JButton("Left"));
        horizontalBox.add(new JButton("Middle"));
        horizontalBox.add(new JButton("Right"));
        horizontalBox.add(Box.createHorizontalStrut(10));
        panel = new JPanel(new BorderLayout());
        panel.add(horizontalBox);
        panel.setBorder(BorderFactory.createTitledBorder("Beginning/End Struts"));
        frame.add(panel);

        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(new JButton("Left"));
        horizontalBox.add(new JButton("Middle"));
        horizontalBox.add(new JButton("Right"));
        panel = new JPanel(new BorderLayout());
        horizontalBox.add(Box.createHorizontalStrut(10));
        panel.add(horizontalBox);
        panel.setBorder(BorderFactory.createTitledBorder("End Strut"));
        frame.add(panel);

        frame.setSize(300, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
