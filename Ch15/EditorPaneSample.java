import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;

public class EditorPaneSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("EditorPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
          JEditorPane editorPane = new JEditorPane("http://www.google.com");
          editorPane.setEditable(false);

          HyperlinkListener hyperlinkListener =
            new ActivatedHyperlinkListener(frame, editorPane);  
          editorPane.addHyperlinkListener(hyperlinkListener);

          JScrollPane scrollPane = new JScrollPane(editorPane);
          frame.add(scrollPane);
        } catch (IOException e) {
          System.err.println("Unable to load: " + e);
        }

        frame.setSize(640, 480);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
