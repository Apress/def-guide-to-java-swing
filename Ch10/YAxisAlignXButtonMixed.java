import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class YAxisAlignXButtonMixed {
  static public class AButton extends Button {
    float alignment;
    AButton(String label, float alignment) {
      super(label);
      this.alignment = alignment;
    }
    public float getAlignmentX() {
      return alignment;
    }
  }
  private static Container makeIt(String title) {
    JPanel container = new JPanel();
    container.setBorder(BorderFactory.createTitledBorder(title));
    BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
    container.setLayout(layout);

    AButton button = new AButton("0.0", 0.0f);
    container.add(button);
    button = new AButton(".25", .25f);
    container.add(button);
    button = new AButton(".50", .50f);
    container.add(button);
    button = new AButton(".75", .75f);
    container.add(button);
    button = new AButton("1.0", 1.0f);
    // container.add(button);
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
