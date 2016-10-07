import javax.swing.*;
import java.awt.*;

public class ScrollSample {
  public static void main(String args[]) {
    final Object rows[][] = {
      {"one",   "ichi - \u4E00"},
      {"two",   "ni - \u4E8C"},
      {"three", "san - \u4E09"},
      {"four",  "shi - \u56DB"},
      {"five",  "go - \u4E94"},
      {"six",   "roku - \u516D"},
      {"seven", "shichi - \u4E03"},
      {"eight", "hachi - \u516B"},
      {"nine",  "kyu - \u4E5D"},
      {"ten",   "ju - \u5341"}
    };
    final Object headers[] = {"English", "Japanese"};
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Scrollless Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = new JTable(rows, headers);
        frame.add(table, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

