import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;

public class SimpleAttributeSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Simple Attributes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StyledDocument document = new DefaultStyledDocument();

        SimpleAttributeSet attributes = new SimpleAttributeSet();
        attributes.addAttribute(StyleConstants.CharacterConstants.Bold,
          Boolean.TRUE);
        attributes.addAttribute(StyleConstants.CharacterConstants.Italic,
          Boolean.TRUE);

        // Insert content
        try {
          document.insertString(document.getLength(), "Hello, Java",
            attributes);
        } catch (BadLocationException badLocationException) {
          System.err.println("Bad insert");
        }

        attributes = new SimpleAttributeSet();
        attributes.addAttribute(StyleConstants.CharacterConstants.Bold,
          Boolean.FALSE);
        attributes.addAttribute(StyleConstants.CharacterConstants.Italic,
          Boolean.FALSE);
        attributes.addAttribute(StyleConstants.CharacterConstants.Foreground,
          Color.LIGHT_GRAY);

        // Insert content
        try {
          document.insertString(document.getLength(),
            " - Good-bye Visual Basic", attributes);
        } catch (BadLocationException badLocationException) {
          System.err.println("Bad insert");
        }

       JTextPane textPane = new JTextPane(document);
        textPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textPane);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
