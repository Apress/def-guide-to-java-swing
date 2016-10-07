import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class RedGreenBorder extends AbstractBorder {
  public boolean isBorderOpaque() {
    return true;
  }
  public Insets getBorderInsets(Component c) {
    return new Insets(3, 3, 3, 3);
  }
  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    Insets insets = getBorderInsets(c);
    Color horizontalColor;
    Color verticalColor;
    if (c.isEnabled()) {
      boolean pressed = false;
      if (c instanceof AbstractButton) {
        ButtonModel model = ((AbstractButton)c).getModel();
        pressed = model.isPressed();
      }
      if (pressed) {
        horizontalColor = Color.RED;
        verticalColor = Color.GREEN;
      } else {
        horizontalColor = Color.GREEN;
        verticalColor = Color.RED;
      }
    } else {
      horizontalColor = Color.LIGHT_GRAY;
      verticalColor = Color.LIGHT_GRAY;
    }
    g.setColor(horizontalColor);

    g.translate(x, y);

    // top
    g.fillRect(0, 0, width, insets.top);
     // bottom
    g.fillRect(0, height-insets.bottom, width, insets.bottom);

    g.setColor(verticalColor);
    // left
    g.fillRect(0, insets.top, insets.left, height-insets.top-insets.bottom);
     // right
    g.fillRect(width-insets.right, insets.top, insets.right, height-insets.top-insets.bottom);
    g.translate(-x, -y);
  }
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("My Border");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border border = new RedGreenBorder();
        JButton helloButton = new JButton("Hello");
        helloButton.setBorder(border);
        JButton braveButton = new JButton("Brave New");
        braveButton.setBorder(border);
        braveButton.setEnabled(false);
        JButton worldButton = new JButton("World");
        worldButton.setBorder(border);
        Container contentPane = frame.getContentPane();
        contentPane.add(helloButton, BorderLayout.NORTH);
        contentPane.add(braveButton, BorderLayout.CENTER);
        contentPane.add(worldButton, BorderLayout.SOUTH);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
