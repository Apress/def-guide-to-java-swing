import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LabelAlign {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Label Align");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(2, 2));

        Border border = LineBorder.createGrayLineBorder();

        JLabel label1 = new JLabel("<html>Bottom<BR>Left");
        label1.setHorizontalAlignment(JLabel.LEFT);
        label1.setVerticalAlignment(JLabel.BOTTOM);
        label1.setBorder(border);
        frame.add(label1);

        JLabel label2 = new JLabel("Top-Right");
        label2.setHorizontalAlignment(JLabel.RIGHT);
        label2.setVerticalAlignment(JLabel.TOP);
        label2.setBorder(border);
        frame.add(label2);

        JLabel label3 = new JLabel("<html>Top<BR>RIGHT");
        label3.setHorizontalAlignment(JLabel.RIGHT);
        label3.setVerticalAlignment(JLabel.TOP);
        label3.setBorder(border);
        frame.add(label3);

        JLabel label4 = new JLabel("<html>Bottom<BR>Center");
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setVerticalAlignment(JLabel.BOTTOM);
        label4.setBorder(border);
        // label4.setIconTextGap(0);
        frame.add(label4);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
