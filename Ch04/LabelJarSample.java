import javax.swing.*;
import java.awt.*;

public class LabelJarSample {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Label JarSample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setLayout(new GridLayout(2, 2));

        JLabel label1 = new JLabel("Text Label");
        frame.add(label1);

        Image warnImage = ImageLoader.getImage(LabelJarSample.class, "Warn.gif");
        Icon warnIcon = new ImageIcon(warnImage);
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
