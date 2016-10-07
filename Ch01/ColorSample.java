import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JColorChooser Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton button = new JButton("Pick to Change Background");

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Color initialBackground = button.getBackground();
            Color background = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
            if (background != null) {
              button.setBackground(background);
            }
          }
        };
        button.addActionListener(actionListener);
        f.add(button, BorderLayout.CENTER);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
