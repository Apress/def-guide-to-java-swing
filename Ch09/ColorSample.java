import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class ColorSample {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("JColorChooser Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel("I Love Swing", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
        frame.add(label, BorderLayout.SOUTH);

        final JColorChooser colorChooser = new JColorChooser(label.getBackground());
        colorChooser.setBorder(BorderFactory.createTitledBorder("Pick Foreground Color"));

        ColorSelectionModel model = colorChooser.getSelectionModel();
        ChangeListener changeListener = new ChangeListener() {
          public void stateChanged(ChangeEvent changeEvent) {
            Color newForegroundColor = colorChooser.getColor();
            label.setForeground(newForegroundColor);
          }
        };
        model.addChangeListener(changeListener);
        frame.add(colorChooser, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
