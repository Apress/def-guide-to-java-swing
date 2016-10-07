import javax.swing.*;
import java.awt.*;

public class TextAreaSample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "TextArea Example" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(0, 2));

        JTextArea leftTextArea = new JTextArea();
        frame.add(leftTextArea);
        leftTextArea.paste();

        JTextArea rightTextArea = new JTextArea();
        rightTextArea.paste();
        JScrollPane rightPane = new JScrollPane(rightTextArea);
        frame.add(rightPane);

        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
