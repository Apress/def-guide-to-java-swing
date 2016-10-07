import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusCycleSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Focus Cycle Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx    = 1.0;
        constraints.weighty    = 1.0;
        constraints.gridwidth  = 1;
        constraints.gridheight = 1;
        constraints.fill       = GridBagConstraints.BOTH;

        // Row One
        constraints.gridy=0;
        for (int i=0; i<3; i++) {
          JButton button = new JButton("" + i);
          constraints.gridx=i;
          frame.add(button, constraints);
        }

        // Row Two
        JPanel panel = new JPanel();
        panel.setFocusCycleRoot(true);
        panel.setFocusTraversalPolicyProvider(true);
        panel.setLayout(new GridLayout(1,3));
        for (int i=0; i<3; i++) {
          JButton button = new JButton("" + (i+3));
          panel.add(button);
        }
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=3;
        frame.add(panel, constraints);

        // Row Three
        constraints.gridy=2;
        constraints.gridwidth=1;
        for (int i=0; i<3; i++) {
          JButton button = new JButton("" + (i+6));
          constraints.gridx=i;
          frame.add(button, constraints);
        }

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
