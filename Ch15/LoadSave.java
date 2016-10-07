import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.io.*;

public class LoadSave {

  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final String filename = "text.out";
        JFrame frame = new JFrame("Loading/Saving Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();

        // Setup actions
        Action loadAction = new AbstractAction() {
          {
            putValue(Action.NAME, "Load");
          }
          public void actionPerformed(ActionEvent e) {
            doLoadCommand(textField, filename);
          }
        };
        JButton loadButton = new JButton (loadAction);
        panel.add(loadButton);

        Action saveAction = new AbstractAction() {
          {
            putValue(Action.NAME, "Save");
          }
          public void actionPerformed(ActionEvent e) {
            doSaveCommand(textField, filename);
          }
        };
        JButton saveButton = new JButton (saveAction);
        panel.add(saveButton);

        Action clearAction = new AbstractAction() {
          {
            putValue(Action.NAME, "Clear");
          }
          public void actionPerformed(ActionEvent e) {
            textField.setText("");
          }
        };
        JButton clearButton = new JButton (clearAction);
        panel.add(clearButton);

        frame.add(panel, BorderLayout.SOUTH);

        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }

  public static void doSaveCommand(JTextComponent textComponent,
      String filename) {
    FileWriter writer = null;
    try {
      writer = new FileWriter(filename);
      textComponent.write(writer);
    } catch (IOException exception) {
      System.err.println("Save oops");
      exception.printStackTrace();
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException exception) {
          System.err.println("Error closing writer");
          exception.printStackTrace();
        }
      }
    }
  }

  public static void doLoadCommand(JTextComponent textComponent,
      String filename) {
    FileReader reader = null;
    try {
      reader = new FileReader(filename);
      textComponent.read(reader, filename);
    } catch (IOException exception) {
      System.err.println("Load oops");
      exception.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException exception) {
          System.err.println("Error closing reader");
          exception.printStackTrace();
        }
      }
    }
  }
}
