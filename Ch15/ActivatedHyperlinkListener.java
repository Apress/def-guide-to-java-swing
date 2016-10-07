import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;

public class ActivatedHyperlinkListener implements HyperlinkListener {

  Frame frame;
  JEditorPane editorPane;

  public ActivatedHyperlinkListener(Frame frame, JEditorPane editorPane) {
    this.frame = frame;
    this.editorPane = editorPane;
  }

  public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
    HyperlinkEvent.EventType type = hyperlinkEvent.getEventType();
    final URL url = hyperlinkEvent.getURL();
    if (type == HyperlinkEvent.EventType.ENTERED) {
      System.out.println("URL: " + url);
    } else if (type == HyperlinkEvent.EventType.ACTIVATED) {
      System.out.println("Activated");
      Runnable runner = new Runnable() {
        public void run() {
          // Retain reference to original
          Document doc = editorPane.getDocument();
          try {
            editorPane.setPage(url);
          } catch (IOException ioException) {
            JOptionPane.showMessageDialog(frame, "Error following link", "Invalid link", JOptionPane.ERROR_MESSAGE);
            editorPane.setDocument(doc);
          }
        }
      };
      EventQueue.invokeLater(runner);
    }
  }
}
