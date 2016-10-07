import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionPaneSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JOptionPane Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton ("Ask");
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();
            Object response = JOptionPane.showInputDialog(
              source, 
              "Where do you want to go tomorrow?",
              "JOptionPane Sample", 
              JOptionPane.QUESTION_MESSAGE,
              null,
              new String[] {"Tower of London", "Westminster Abbey", "Buckingham Palace", "Trafalgar Square", "Madame Tussaud's Wax Museum"},
              "Westminster Abbey");
            System.out.println ("Response: " + response);
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
