import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class FixedTable {
  public static void main(String args[]) {

    final Object rowData[][] = {
      {"1",  "one",   "ichi",   "un",     "I", "\u4E00"},
      {"2",  "two",   "ni",     "deux",   "II", "\u4E8C"},
      {"3",  "three", "san",    "trois",  "III", "\u4E09"},
      {"4",  "four",  "shi",    "quatre", "IV", "\u56DB"},
      {"5",  "five",  "go",     "cinq",   "V", "\u4E94"},
      {"6",  "six",   "roku",   "treiza", "VI", "\u516D"},
      {"7",  "seven", "shichi", "sept",   "VII", "\u4E03"},
      {"8",  "eight", "hachi",  "huit",   "VIII", "\u516B"},
      {"9",  "nine",  "kyu",    "neur",   "IX", "\u4E5D"},
      {"10", "ten",   "ju",     "dix",    "X", "\u5341"}
    };

    final String columnNames[] = {"#", "English", "Japanese", "French", "Roman", "Kanji"};

    final TableModel fixedColumnModel = new AbstractTableModel() {
      public int getColumnCount() {
        return 1;
      }
      public String getColumnName(int column) {
        return columnNames[column];
      }
      public int getRowCount() {
        return rowData.length;
      }
      public Object getValueAt(int row, int column) {
        return rowData[row][column];
      }
    };

    final TableModel mainModel = new AbstractTableModel() {
      public int getColumnCount() {
        return columnNames.length-1;
      }
      public String getColumnName(int column) {
        return columnNames[column+1];
      }
      public int getRowCount() {
        return rowData.length;
      }
      public Object getValueAt(int row, int column) {
        return rowData[row][column+1];
      }
    };

    Runnable runner = new Runnable() {
      public void run() {
        JTable fixedTable = new JTable(fixedColumnModel);
        fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        fixedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTable mainTable = new JTable(mainModel);
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel model = fixedTable.getSelectionModel();
        mainTable.setSelectionModel(model);

        JScrollPane scrollPane = new JScrollPane(mainTable);
        Dimension fixedSize = fixedTable.getPreferredSize();
        JViewport viewport = new JViewport();
        viewport.setView(fixedTable);
        viewport.setPreferredSize(fixedSize);
        viewport.setMaximumSize(fixedSize);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedTable.getTableHeader());
        scrollPane.setRowHeaderView(viewport);

        JFrame frame = new JFrame("Fixed Column Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
