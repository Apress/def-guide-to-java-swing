import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

public class ElementSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Element Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton button = new JButton("Show Elements");
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Document document = textArea.getDocument();
            ElementIterator iterator = new ElementIterator(document);
            Element element = iterator.first();
            while (element != null) {
              System.out.println(element.getStartOffset());
              element = iterator.next();
            }
          }
        };
        button.addActionListener(actionListener);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.setSize(250, 250);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
