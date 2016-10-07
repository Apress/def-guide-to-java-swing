import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class GridBagButtons {
  private static final Insets insets = new Insets(0,0,0,0);
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final JFrame frame = new JFrame("GridBagLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        JButton button;
	// Row One - Three Buttons
        button = new JButton("One");
        addComponent(frame, button, 0, 0, 1, 1,
          GridBagConstraints.CENTER, GridBagConstraints.NONE);
        button = new JButton("Two");
        addComponent(frame, button, 1, 0, 1, 1,
          GridBagConstraints.CENTER, GridBagConstraints.NONE);
        button = new JButton("Three");
        addComponent(frame, button, 2, 0, 1, 1,
          GridBagConstraints.CENTER, GridBagConstraints.NONE);
	// Row Two - Two Buttons
        button = new JButton("Four");
        addComponent(frame, button, 0, 1, 2, 1,
          GridBagConstraints.CENTER, GridBagConstraints.NONE);
        button = new JButton("Five");
        addComponent(frame, button, 2, 1, 1, 2,
          GridBagConstraints.CENTER, GridBagConstraints.NONE);
	// Row Three - Two Buttons
        button = new JButton("Six");
        addComponent(frame, button, 0, 2, 1, 1,
          GridBagConstraints.CENTER, GridBagConstraints.NONE);
        button = new JButton("Seven");
        addComponent(frame, button, 1, 2, 1, 1,
          GridBagConstraints.CENTER, GridBagConstraints.NONE);
        frame.setSize(500, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }

  private static void addComponent(Container container, Component component,
      int gridx, int gridy, int gridwidth, int gridheight, int anchor,
      int fill) {
    GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
      gridwidth, gridheight, 1.0, 1.0, anchor, fill, insets, 0, 0);
    container.add(component, gbc);
  }

}
