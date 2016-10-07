import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrenchPopup {
  public static void main(String args[]) {

    Runnable runner = new Runnable() {
      public void run() {
        // Localize buttons for French
        UIManager.put("OptionPane.cancelButtonText", "Annuler");
        UIManager.put("OptionPane.noButtonText", "Non");
        UIManager.put("OptionPane.okButtonText", "D'accord");
        UIManager.put("OptionPane.yesButtonText", "Oui");

        JFrame frame = new JFrame("French Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton ("Ask");
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();
            int result = JOptionPane.showConfirmDialog(source, "Est-ce que vous avez 18 ans ou plus?", "Choisisez une option", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
              System.out.println ("Yes");
            } else if (result == JOptionPane.NO_OPTION) {
              System.out.println ("No");
            } else if (result == JOptionPane.CANCEL_OPTION) {
              System.out.println ("Cancel");
            } else if (result == JOptionPane.CLOSED_OPTION) {
              System.out.println ("Closed");
            }
          }
        };
        button.addActionListener(actionListener);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
