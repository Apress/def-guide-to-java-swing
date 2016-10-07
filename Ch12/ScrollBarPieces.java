import javax.swing.*;
import java.awt.*;	
import javax.swing.plaf.ColorUIResource;

public class ScrollBarPieces {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "ScrollBar Sample" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollBar oneJScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        frame.add(oneJScrollBar, BorderLayout.NORTH);
        frame.setSize(200, 44);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
