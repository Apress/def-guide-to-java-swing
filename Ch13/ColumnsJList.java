import javax.swing.*;
import java.awt.*;

public class ColumnsJList {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Zero", "One", "Two", "Three",
          "Four", "Five", "Six", "Seven", "Eight"};
        JFrame frame = new JFrame("Multi-Columns");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList columns   = new JList(labels);
	columns.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	columns.setVisibleRowCount(3);
        JScrollPane sp = new JScrollPane(columns);
        frame.add(sp, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
