import java.awt.*;
import javax.swing.*;

public class EditorSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JEditorPane Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JEditorPane editor = new JEditorPane("text/html", "<H3>Help</H3><center><IMG src=file:///c:/swing3/code/Ch01/logo.jpg></center><li>One<li><i>Two</i><li><u>Three</u>");
        editor.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editor);
        f.add(scrollPane, BorderLayout.CENTER);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
