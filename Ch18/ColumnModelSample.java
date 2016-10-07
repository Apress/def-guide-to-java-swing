import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class ColumnModelSample {
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

        TableColumnModelListener tableColumnModelListener =
            new TableColumnModelListener() {
          public void columnAdded(TableColumnModelEvent e) {
            System.out.println("Added");
          }
          public void columnMarginChanged(ChangeEvent e) {
            System.out.println("Margin");
          }
          public void columnMoved(TableColumnModelEvent e) {
            System.out.println("Moved");
          }
          public void columnRemoved(TableColumnModelEvent e) {
            System.out.println("Removed");
          }
          public void columnSelectionChanged(ListSelectionEvent e) {
            System.out.println("Selection Changed");
          }
        };

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.addColumnModelListener(tableColumnModelListener);

        columnModel.setColumnMargin(12);

        TableColumn column = new TableColumn(1);
        columnModel.addColumn(column);

	JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
