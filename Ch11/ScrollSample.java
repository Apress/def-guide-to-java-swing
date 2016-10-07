import javax.swing.*;
import java.awt.*;

public class ScrollSample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "JScrollPane Sample" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon icon = new ImageIcon("dog.jpg");
        JLabel dogLabel = new JLabel(icon);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(dogLabel);
//        scrollPane.getViewport().setView(dogLabel);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

