import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SamplePopup {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Sample Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton ("Ask");
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();
            Object response = JOptionPane.showInputDialog(
              source, 
              "Where would you like to go to lunch?",
              "Select a Destination", 
              JOptionPane.QUESTION_MESSAGE,
              null,
              new String[] {"Burger King", "McDonalds", "Pizza Hut", "Taco Bell", "Wendy's"},
              "McDonalds");
            System.out.println ("Response: " + response);
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
