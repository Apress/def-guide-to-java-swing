import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

public class CutPasteSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Cut/Paste Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(textField, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        Action actions[] = textField.getActions();

        Action cutAction =
          TextUtilities.findAction(actions, DefaultEditorKit.cutAction);
        Action copyAction =
          TextUtilities.findAction(actions, DefaultEditorKit.copyAction);
        Action pasteAction =
          TextUtilities.findAction(actions, DefaultEditorKit.pasteAction);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.SOUTH);

        JButton cutButton = new JButton(cutAction);
        cutButton.setText("Cut");
        panel.add(cutButton);

        JButton copyButton = new JButton(copyAction);
        copyButton.setText("Copy");
        panel.add(copyButton);

        JButton pasteButton = new JButton(pasteAction);
        pasteButton.setText("Paste");
        panel.add(pasteButton);

        frame.setSize(250, 250);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
