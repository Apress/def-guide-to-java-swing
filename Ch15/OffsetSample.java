import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OffsetSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Offset Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Name: ");
        label.setDisplayedMnemonic(KeyEvent.VK_N);
        final JTextField textField = new JTextField();
        label.setLabelFor(textField);
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        JButton button = new JButton("Get Offset");
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Offset: " + textField.getScrollOffset());
            System.out.println("Visibility: " +
              textField.getHorizontalVisibility());
            BoundedRangeModel model = textField.getHorizontalVisibility();
            int extent = model.getExtent();
            textField.setScrollOffset(extent);
          }
        };
        button.addActionListener(actionListener);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
