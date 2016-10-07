import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class ListActions {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("TextAction List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String components[] = {
          "JTextField", "JFormattedTextField", "JPasswordField",
          "JTextArea", "JTextPane", "JEditorPane"};

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            // Determine which component selected
            String command = actionEvent.getActionCommand();
            JTextComponent component = null;
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

            // Process action list
            Action actions[] = component.getActions();
            // Define comparator to sort actions
            Comparator<Action> comparator = new Comparator<Action>() {
              public int compare(Action a1, Action a2) {
                String firstName = (String)a1.getValue(Action.NAME);
                String secondName = (String)a2.getValue(Action.NAME);
                return firstName.compareTo(secondName);
              }
            };
            Arrays.sort(actions, comparator);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw, true);
            int count = actions.length;
            pw.println("Count: " + count);
            for (int i=0; i<count; i++) {
              pw.print  (actions[i].getValue(Action.NAME));
              pw.print  (" : ");
              pw.println(actions[i].getClass().getName());
            }
            pw.close();
            textArea.setText(sw.toString());
            textArea.setCaretPosition(0);
          }
        };

        final Container componentsContainer = 
          RadioButtonUtils.createRadioButtonGrouping(components,
            "Pick to List Actions", actionListener);

        frame.add(componentsContainer, BorderLayout.WEST);
        frame.setSize(400, 250);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

