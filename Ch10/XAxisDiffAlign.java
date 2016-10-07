import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class XAxisDiffAlign {
  private static Container makeIt(String title, boolean more) {
    JPanel container = new JPanel() {
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Insets insets = getInsets();
        int width = getWidth();
        int height = getHeight() - insets.top - insets.bottom;
        int halfHeight = height/2 + insets.top;
        g.drawLine(0, halfHeight, width, halfHeight);
      }
    };
    container.setBorder(BorderFactory.createTitledBorder(title));
    BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
    container.setLayout(layout);

    JButton button;
    button = new JButton("0.0");
    button.setOpaque(false);
    button.setAlignmentY(Component.TOP_ALIGNMENT);
    container.add(button);
    if (more) {
      button = new JButton(".25");
    button.setOpaque(false);
      button.setAlignmentY(0.25f);
      container.add(button);
      button = new JButton(".5");
    button.setOpaque(false);
      button.setAlignmentY(Component.CENTER_ALIGNMENT);
      container.add(button);
      button = new JButton(".75");
    button.setOpaque(false);
      button.setAlignmentY(0.75f);
      container.add(button);
    }
    button = new JButton("1.0");
    button.setOpaque(false);
    button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
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

        frame.add(panel1, BorderLayout.WEST);
        frame.add(panel2, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
