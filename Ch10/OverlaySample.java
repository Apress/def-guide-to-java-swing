import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OverlaySample {
  public static final String SET_MINIMUM = "Minimum";
  public static final String SET_MAXIMUM = "Maximum";
  public static final String SET_CENTRAL = "Central";
  public static final String SET_MIXED   = "Mixed";

  static JButton smallButton = new JButton();
  static JButton mediumButton = new JButton();
  static JButton largeButton = new JButton();

  public static void setupButtons(String command) {
    if (SET_MINIMUM.equals(command)) {
      smallButton.setAlignmentX(0.0f);
      smallButton.setAlignmentY(0.0f);
      mediumButton.setAlignmentX(0.0f);
      mediumButton.setAlignmentY(0.0f);
      largeButton.setAlignmentX(0.0f);
      largeButton.setAlignmentY(0.0f);
    } else if (SET_MAXIMUM.equals(command)) {
      smallButton.setAlignmentX(1.0f);
      smallButton.setAlignmentY(1.0f);
      mediumButton.setAlignmentX(1.0f);
      mediumButton.setAlignmentY(1.0f);
      largeButton.setAlignmentX(1.0f);
      largeButton.setAlignmentY(1.0f);
    } else if (SET_CENTRAL.equals(command)) {
      smallButton.setAlignmentX(0.5f);
      smallButton.setAlignmentY(0.5f);
      mediumButton.setAlignmentX(0.5f);
      mediumButton.setAlignmentY(0.5f);
      largeButton.setAlignmentX(0.5f);
      largeButton.setAlignmentY(0.5f);
    } else if (SET_MIXED.equals(command)) {
      smallButton.setAlignmentX(0.0f);
      smallButton.setAlignmentY(0.0f);
      mediumButton.setAlignmentX(0.5f);
      mediumButton.setAlignmentY(0.5f);
      largeButton.setAlignmentX(1.0f);
      largeButton.setAlignmentY(1.0f);
    } else {
      throw new IllegalArgumentException("Illegal Command: " + command);
    }
    // Redraw panel
    ((JPanel)largeButton.getParent()).revalidate();
  }

  public static void main(String args[]) {

    final ActionListener generalActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        JComponent comp = (JComponent)actionEvent.getSource();
        System.out.println (actionEvent.getActionCommand() + ": " + comp.getBounds());
      }
    };

    final ActionListener sizingActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        setupButtons(actionEvent.getActionCommand());
      }
    };

    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Overlay Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
          public boolean isOptimizedDrawingEnabled() {
            return false;
          }
        };
        LayoutManager overlay = new OverlayLayout(panel);
        panel.setLayout(overlay);

        Object settings[][] = {
          {"Small", new Dimension(25, 25), Color.white},
          {"Medium", new Dimension(50, 50), Color.gray},
          {"Large", new Dimension(100, 100), Color.black}
        };
        JButton buttons[] = {smallButton, mediumButton, largeButton};

        for (int i=0, n=settings.length; i<n; i++) {
          JButton button = buttons[i];
          button.addActionListener(generalActionListener);
          button.setActionCommand((String)settings[i][0]);
          button.setMaximumSize((Dimension)settings[i][1]);
          button.setBackground((Color)settings[i][2]);
          panel.add(button);
        }

        setupButtons(SET_CENTRAL);

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createTitledBorder("Change Alignment"));
        String actionSettings[] = {SET_MINIMUM, SET_MAXIMUM, SET_CENTRAL, SET_MIXED};
        for (int i=0, n=actionSettings.length; i<n; i++) {
          JButton button = new JButton(actionSettings[i]);
          button.addActionListener(sizingActionListener);
          actionPanel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.add(actionPanel, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
