import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CaretSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Caret Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        final JTextField dot = new JTextField();
        dot.setEditable(false);
        JPanel dotPanel = new JPanel(new BorderLayout());
        dotPanel.add(new JLabel("Dot: "), BorderLayout.WEST);
        dotPanel.add(dot, BorderLayout.CENTER);
        frame.add(dotPanel, BorderLayout.NORTH);

        final JTextField mark = new JTextField();
        mark.setEditable(false);
        JPanel markPanel = new JPanel(new BorderLayout());
        markPanel.add(new JLabel("Mark: "), BorderLayout.WEST);
        markPanel.add(mark, BorderLayout.CENTER);
        frame.add(markPanel, BorderLayout.SOUTH);

        CaretListener listener = new CaretListener() {
          public void caretUpdate(CaretEvent caretEvent) {
            dot.setText(Integer.toString(caretEvent.getDot()));
            mark.setText(Integer.toString(caretEvent.getMark()));
          }
        };

        textArea.addCaretListener(listener);

        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
