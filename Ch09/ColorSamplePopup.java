import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorSamplePopup {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("JColorChooser Sample Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton button = new JButton("Pick to Change Background");

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Color initialBackground = button.getBackground();
            Color background = JColorChooser.showDialog(null, "Change Button Background", initialBackground);
            if (background != null) {
              button.setBackground(background);
            }
          }
        };
        button.addActionListener(actionListener);
        frame.add(button, BorderLayout.CENTER);

        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
