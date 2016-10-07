import javax.swing.*;
import java.awt.*;

public class LabelSample {

  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "JLabel Sample" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(2, 2));

        JLabel label1 = new JLabel("Text Label");
        frame.add(label1);

        Icon warnIcon = new ImageIcon("Warn.gif");
        JLabel label2 = new JLabel(warnIcon);
        frame.add(label2);

        JLabel label3 = new JLabel("Warning", warnIcon, JLabel.CENTER);
        frame.add(label3);

        String htmlLabel = "<html><sup>HTML</sup> <sub><em>Label</em></sub><br>" +
          "<font color=\"#FF0080\"><u>Multi-line</u></font>";
        JLabel label4 = new JLabel(htmlLabel);
        frame.add(label4);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
