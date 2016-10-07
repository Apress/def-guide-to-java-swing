import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;

public class TextPaneSample {
  private static String message = 
    "In the beginning, there was COBOL, then there was FORTRAN, " +
    "then there was BASIC, ... and now there is Java.\n";

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("TextPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StyleContext context = new StyleContext();
        StyledDocument document = new DefaultStyledDocument(context);

        Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontSize(style, 14);
        StyleConstants.setSpaceAbove(style, 4);
        StyleConstants.setSpaceBelow(style, 4);

        // Insert content
        try {
          document.insertString(document.getLength(), message, style);
        } catch (BadLocationException badLocationException) {
          System.err.println("Oops");
        }

        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setBold(attributes, true);
        StyleConstants.setItalic(attributes, true);

        // Insert content
        try {
          document.insertString(document.getLength(), "Hello Java", attributes);
        } catch (BadLocationException badLocationException) {
          System.err.println("Oops");
        }

        // Third style for icon/component
        Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);

        Icon icon = new ImageIcon("Computer.gif");
        JLabel label = new JLabel(icon);
        StyleConstants.setComponent(labelStyle, label);

        // Insert content
        try {
          document.insertString(document.getLength(), "Ignored", labelStyle);
        } catch (BadLocationException badLocationException) {
          System.err.println("Oops");
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
