import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class CreateColorSamplePopup {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("JColorChooser Create Popup Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton button = new JButton("Pick to Change Background");

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Color initialBackground = button.getBackground();

            final JColorChooser colorChooser = new JColorChooser(initialBackground);
//            colorChooser.setPreviewPanel(new JPanel());
            final JLabel previewLabel = new JLabel("I Love Swing", JLabel.CENTER);
            previewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
            previewLabel.setSize(previewLabel.getPreferredSize());
            previewLabel.setBorder(BorderFactory.createEmptyBorder(0,0,1,0));
            colorChooser.setPreviewPanel(previewLabel);

            // For okay button selection, change button background to selected color
            ActionListener okActionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {
                Color newColor = colorChooser.getColor();
                if (newColor.equals(button.getForeground())) {
                  System.out.println("Color change rejected");
                } else {
                  button.setBackground(colorChooser.getColor());
                }
              }
            };

            // For cancel button selection, change button background to red
            ActionListener cancelActionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {
                button.setBackground(Color.RED);
              }
            };

            final JDialog dialog = JColorChooser.createDialog(null,
              "Change Button Background", true, colorChooser,
              okActionListener, cancelActionListener);

            // Wait until current event dispatching completes before showing dialog
            Runnable showDialog = new Runnable() {
              public void run() {
                dialog.setVisible(true);
              }
            };
            EventQueue.invokeLater(showDialog);
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
