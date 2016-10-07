import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManualDisplayPopup {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {

        JFrame frame = new JFrame("NoButton Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton ("Ask");
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();
            JOptionPane optionPane = new JOptionPane("Continue printing?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            JDialog dialog = optionPane.createDialog(source, "Manual Creation");
            dialog.setVisible(true);
            int selection = OptionPaneUtils.getSelection(optionPane);
            System.out.println (selection);
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
