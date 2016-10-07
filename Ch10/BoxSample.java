import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Enumeration;

public class BoxSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Box Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button;
        Vector<JButton> buttons = new Vector<JButton>();
        Dimension dim;
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        JPanel topLeft = new JPanel();
        topLeft.setLayout(new BoxLayout(topLeft, BoxLayout.X_AXIS));
        topLeft.add(button = new JButton("One"));
        buttons.add(button);
        changeBoth(button);
        topLeft.add(button = new JButton("Two"));
        buttons.add(button);
        changeBoth(button);
        changeWidth(topLeft);
        JPanel bottomLeft = new JPanel();
        bottomLeft.setLayout(new BoxLayout(bottomLeft, BoxLayout.X_AXIS));
        bottomLeft.add(button = new JButton("Six"));
        buttons.add(button);
        changeBoth(button);
        bottomLeft.add(button = new JButton("Seven"));
        buttons.add(button);
        changeBoth(button);
        changeWidth(bottomLeft);
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.add(topLeft);
        left.add(button = new JButton("Four"));
        buttons.add(button);
        changeBoth(button);
        left.add(bottomLeft);
        changeBoth(left);

        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.add(button = new JButton("Three"));
        buttons.add(button);
        changeWidth(button);
        right.add(button = new JButton("Five"));
        buttons.add(button);
        changeBoth(button);
        changeBoth(right);
        frame.add(left);
        frame.add(right);
        tweak(buttons);
        frame.pack();
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
  private static void changeWidth(JComponent comp) {
    comp.setAlignmentX(Component.CENTER_ALIGNMENT);
    comp.setAlignmentY(Component.CENTER_ALIGNMENT);
    Dimension dim = comp.getPreferredSize();
    dim.width = Integer.MAX_VALUE;
    comp.setMaximumSize(dim);
  }
  private static void changeHeight(JComponent comp) {
    comp.setAlignmentX(Component.CENTER_ALIGNMENT);
    comp.setAlignmentY(Component.CENTER_ALIGNMENT);
    Dimension dim = comp.getPreferredSize();
    dim.height = Integer.MAX_VALUE;
    comp.setMaximumSize(dim);
  }
  private static void changeBoth(JComponent comp) {
    comp.setAlignmentX(Component.CENTER_ALIGNMENT);
    comp.setAlignmentY(Component.CENTER_ALIGNMENT);
    Dimension dim = new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    comp.setMaximumSize(dim);
  }
  private static void tweak(Vector<JButton> buttons) {
    // calc max preferred width
    JButton button;
    Dimension dim;
    int maxWidth = 0;
    Enumeration<JButton> elements = buttons.elements();
    while (elements.hasMoreElements()) {
      button = elements.nextElement();
      dim = button.getPreferredSize();
      if (dim.width > maxWidth)
       maxWidth = dim.width;
    }
    // set max preferred width
    elements = buttons.elements();
    while (elements.hasMoreElements()) {
      button = elements.nextElement();
      dim = button.getPreferredSize();
      dim.width = maxWidth;
      button.setPreferredSize(dim);
    }
  }
}

