import java.awt.*;
import javax.swing.*;

public class OvalPanel extends JPanel {

  Color color;

  public OvalPanel() {
    this(Color.black);
  }
  public OvalPanel(Color color) {
    this.color = color;
  }
  public void paintComponent(Graphics g) {
    int width = getWidth();
    int height = getHeight();
    g.setColor(color);
    g.drawOval(0, 0, width, height);
  }

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Oval Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setLayout(new GridLayout(2, 2));

        Color colors[] = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        for (int i=0; i<4; i++) {
          OvalPanel panel = new OvalPanel(colors[i]);
          frame.add(panel);
        }

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
