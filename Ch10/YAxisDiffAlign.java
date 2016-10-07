import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class YAxisDiffAlign {
  private static Container makeIt(String title, boolean more) {
    JPanel container = new JPanel() {
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Insets insets = getInsets();
        int width = getWidth() - insets.left - insets.right;
        int halfWidth = width/2 + insets.left;
        int height = getHeight();
        int halfHeight = height/2 + insets.top;
        g.drawLine(halfWidth, 0, halfWidth, height);
      }
    };
    container.setBorder(BorderFactory.createTitledBorder(title));
    BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
    container.setLayout(layout);

    JButton button;
    button = new JButton("0.0");
    button.setOpaque(false);
    button.setAlignmentX(Component.LEFT_ALIGNMENT);
    container.add(button);
    if (more) {
      button = new JButton(".25");
    button.setOpaque(false);
      button.setAlignmentX(0.25f);
      container.add(button);
      button = new JButton(".5");
    button.setOpaque(false);
      button.setAlignmentX(Component.CENTER_ALIGNMENT);
      container.add(button);
      button = new JButton(".75");
    button.setOpaque(false);
      button.setAlignmentX(0.75f);
      container.add(button);
    }
    button = new JButton("1.0");
    button.setOpaque(false);
    button.setAlignmentX(Component.RIGHT_ALIGNMENT);
    container.add(button);

    return container;
  }

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Alignment Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container panel1 = makeIt("Mixed", false);
        Container panel2 = makeIt("Mixed", true);

        frame.setLayout (new GridLayout(1, 2));
        frame.add(panel1);
        frame.add(panel2);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
