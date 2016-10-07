import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExpandableSplit {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "Expandable Split" : args[0]);

        JFrame vFrame = new JFrame(title);
        vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent leftButton = new JButton("Top");
        JComponent rightButton = new JButton("Bottom");
        final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setLeftComponent(leftButton);
        splitPane.setRightComponent(rightButton);
        ActionListener oneActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            splitPane.resetToPreferredSizes();
          }
        };
        ((JButton)rightButton).addActionListener(oneActionListener);
        ActionListener anotherActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            splitPane.setDividerLocation(10);
            splitPane.setContinuousLayout(true);
          }
        };
        ((JButton)leftButton).addActionListener(anotherActionListener);
        vFrame.add(splitPane, BorderLayout.CENTER);
        vFrame.setSize(300, 150);
        vFrame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
