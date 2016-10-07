import javax.swing.*;
import java.awt.*;

public class GlueSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        Box horizontalBox;
        JPanel panel;
        JFrame frame = new JFrame("Horizontal Glue");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));

        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createGlue());
        horizontalBox.add(new JButton("Left"));
        horizontalBox.add(new JButton("Middle"));
        horizontalBox.add(new JButton("Right"));
        panel = new JPanel(new BorderLayout());
        panel.add(horizontalBox);
        panel.setBorder(BorderFactory.createTitledBorder("Beginning Glue"));
        frame.add(panel);

        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(new JButton("Left"));
        horizontalBox.add(Box.createGlue());
        horizontalBox.add(new JButton("Middle"));
        horizontalBox.add(Box.createGlue());
        horizontalBox.add(new JButton("Right"));
        panel = new JPanel(new BorderLayout());
        panel.add(horizontalBox);
        panel.setBorder(BorderFactory.createTitledBorder("2 Middle Glues"));
        frame.add(panel);

        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createGlue());
        horizontalBox.add(new JButton("Left"));
        horizontalBox.add(new JButton("Middle"));
        horizontalBox.add(new JButton("Right"));
        horizontalBox.add(Box.createGlue());
        panel = new JPanel(new BorderLayout());
        panel.add(horizontalBox);
        panel.setBorder(BorderFactory.createTitledBorder("Beginning/End Glues"));
        frame.add(panel);

        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(new JButton("Left"));
        horizontalBox.add(new JButton("Middle"));
        horizontalBox.add(new JButton("Right"));
        panel = new JPanel(new BorderLayout());
        horizontalBox.add(Box.createGlue());
        panel.add(horizontalBox);
        panel.setBorder(BorderFactory.createTitledBorder("End Glue"));
        frame.add(panel);

        frame.setSize(300, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
