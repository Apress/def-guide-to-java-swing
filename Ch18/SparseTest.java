import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SparseTest {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Sparse Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String headers[] = {"English", "Japanese"};
        TableModel model = new SparseTableModel(10, headers);
        JTable table = new JTable(model);

        model.setValueAt("one", 0, 0);
        model.setValueAt("ten", 9, 0);
        model.setValueAt("roku - \u516D", 5, 1);
        model.setValueAt("hachi - \u516B", 8, 1);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
