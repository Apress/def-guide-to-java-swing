import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResizeSplit {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "Resize Split" : args[0]);

        final JFrame vFrame = new JFrame(title);
        vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton topButton = new JButton("Top");
        JButton bottomButton = new JButton("Bottom");
        final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
//        splitPane.setResizeWeight(0.5);
        splitPane.setResizeWeight(1.0);
        splitPane.setTopComponent(topButton);
        splitPane.setBottomComponent(bottomButton);

        vFrame.add(splitPane, BorderLayout.CENTER);
        vFrame.setSize(300, 150);
        vFrame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
