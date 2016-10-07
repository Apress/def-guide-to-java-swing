import javax.swing.*;
import javax.swing.text.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;

public class PopupSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Popup Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPopupMenu popup = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Option 1");
        popup.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("Option 2");
        popup.add(menuItem2);

        final JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            try {
              int dotPosition = textField.getCaretPosition();
              Rectangle popupLocation = textField.modelToView(dotPosition);
              popup.show(textField, popupLocation.x, popupLocation.y);
            } catch (BadLocationException badLocationException) {
              System.err.println("Oops");
            }
          }
        };
        KeyStroke keystroke =
          KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0, false);
        textField.registerKeyboardAction(actionListener, keystroke,
          JComponent.WHEN_FOCUSED);

        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

