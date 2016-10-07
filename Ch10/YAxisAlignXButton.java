import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class YAxisAlignXButton {
  private static Container makeIt(String title) {
    String labels[] = {"--", "----", "--------", "------------"};

    JPanel container = new JPanel();
    container.setBorder(BorderFactory.createTitledBorder(title));
    BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
    container.setLayout(layout);

    for (int i=0,n=labels.length; i<n; i++) {
      Button button = new Button(labels[i]);
// Use default alignment - same for all
      container.add(button);
    }
    return container;
  }

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Alignment Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container panel = makeIt("AWT Button");

        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
