import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class ActionsMenuBar {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final JFrame frame = new JFrame("TextAction Usage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JScrollPane scrollPane = new JScrollPane();
        frame.add(scrollPane, BorderLayout.CENTER);

        final JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        ActionListener actionListener = new ActionListener() {
          JTextComponent component;
          public void actionPerformed(ActionEvent actionEvent) {
            // Determine which component selected
            String command = actionEvent.getActionCommand();
            if (command.equals("JTextField")) {
              component = new JTextField();
            } else if (command.equals("JFormattedTextField")) {
              component = new JFormattedTextField();
            } else if (command.equals("JPasswordField")) {
              component = new JPasswordField();
            } else if (command.equals("JTextArea")) {
              component = new JTextArea();
            } else if (command.equals("JTextPane")) {
              component = new JTextPane();
            } else {
              component = new JEditorPane();
            }
            scrollPane.setViewportView(component);
            // Process action list
            Action actions[] = component.getActions();
            menuBar.removeAll();
            menuBar.revalidate();
            JMenu menu = null;
            for (int i=0, n=actions.length; i<n; i++) {
              if ((i % 10) == 0) {
                menu = new JMenu("From " + i);
                menuBar.add(menu);
              }
              menu.add(actions[i]);
            }
            menuBar.revalidate();
          }
        };

        String components[] = {
          "JTextField", "JFormattedTextField", "JPasswordField",
          "JTextArea", "JTextPane", "JEditorPane"};
        final Container componentsContainer = 
          RadioButtonUtils.createRadioButtonGrouping(components,
            "Pick to List Actions", actionListener);
        frame.add(componentsContainer, BorderLayout.WEST);

        frame.setSize(400, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
