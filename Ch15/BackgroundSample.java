import javax.swing.*;
import java.awt.*;

public class BackgroundSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Background Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ImageIcon imageIcon = new ImageIcon("draft.gif");
        JTextArea textArea = new JTextArea() {
          Image image = imageIcon.getImage();
          Image grayImage = GrayFilter.createDisabledImage(image);
          {setOpaque(false);}  // instance initializer
          public void paint (Graphics g) {
            g.drawImage(grayImage, 0, 0, this);
            super.paint(g);
          }
        };
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(250, 250);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
