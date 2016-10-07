import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;

public class TabSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Tab Attributes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StyledDocument document = new DefaultStyledDocument();

        int positions[] = {TabStop.ALIGN_BAR, TabStop.ALIGN_CENTER,
          TabStop.ALIGN_DECIMAL, TabStop.ALIGN_LEFT, TabStop.ALIGN_RIGHT};
        String strings[] = {"\tBAR\n", "\tCENTER\n", "\t3.14159265\n",
          "\tLEFT\n", "\tRIGHT\n"};

        SimpleAttributeSet attributes = new SimpleAttributeSet();

        for (int i=0, n=positions.length; i<n; i++) {
          TabStop tabstop = new TabStop(150, positions[i], TabStop.LEAD_DOTS);
          try {
            int position = document.getLength();
            document.insertString(position, strings[i], null);
            TabSet tabset = new TabSet(new TabStop[] {tabstop});
            StyleConstants.setTabSet(attributes, tabset);
            document.setParagraphAttributes(position, 1, attributes, false);
          } catch (BadLocationException badLocationException) {
            System.err.println("Bad Location");
          }
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
