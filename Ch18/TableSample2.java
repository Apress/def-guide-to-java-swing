import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Vector;

public class TableSample2 {
  public static void main(String args[]) {
    final Object rows[][] = {
      {"one",   "ichi - \u4E00", "un"},
      {"two",   "ni - \u4E8C", "deux"},
      {"three", "san - \u4E09", "trois"},
      {"four",  "shi - \u56DB", "quatre"},
      {"five",  "go - \u4E94", "cinq"},
      {"six",   "roku - \u516D", "treiza"},
      {"seven", "shichi - \u4E03", "sept"},
      {"eight", "hachi - \u516B", "huit"},
      {"nine",  "kyu - \u4E5D", "neuf"},
      {"ten",   "ju - \u5341", "dix"}
/*
      {"one",   "ichi", new Double (Math.PI)},
      {"two",   "ni", new Float ("30.5")},
      {"three", "san", new Float ("30.5")},
      {"four",  "shi", new Float ("30.5")},
      {"five",  "go", new Float ("30.5")},
      {"six",   "roku", new Float ("30.5")},
      {"seven", "shichi", new Float ("30.5")},
      {"eight", "hachi", new Float ("30.5")},
      {"nine",  "kyu", new Float ("30.5")},
      {"ten",   "ju", "30.5"}
*/
    };
    final Object options[] = {"un", "deux", "trois", "quatre", "cinq",
      "treiza", "sept", "huit", "neuf", "dix"};
    Runnable runner = new Runnable() {
      public void run() {
        JComboBox comboBox = new JComboBox (options);
        comboBox.setMaximumRowCount(4);
        TableCellEditor editor = new DefaultCellEditor(comboBox);

//    Object headers[] = {"<html>English<br>American", "Japanese", "French"};
        Object headers[] = {"English", "Japanese", "French"};
        JFrame frame = new JFrame("JTable Anatomy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
class CustomTableModel extends DefaultTableModel {
  public CustomTableModel(Object rowData[][], Object columnNames[]) {
    super(rowData, columnNames);
  }
  public Class getColumnClass(int col) {
    Vector v = (Vector)dataVector.elementAt(0);
    return v.elementAt(col).getClass();
  }
  public boolean isCellEditable(int row, int col) {
    return true;
  }
}
        JTable table = new JTable(new DefaultTableModel(rows, headers));

//        ColumnModelUtilities.removeHeaders(table.getColumnModel());
        table.getColumnModel().getColumn(2).setCellEditor(editor);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
