import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.*;
import java.util.Locale;

public class ColumnSample {
  public static void main(String args[]) throws ParseException {
    final TableModel model = new AbstractTableModel() {
      Icon icon1 = new ImageIcon("TreeCollapsed.gif");
      Icon icon2 = new ImageIcon("TreeExpanded.gif");
      DateFormat format =
        DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
      Object rowData[][] = {
        {"1", "ichi", Boolean.TRUE, format.parse("01/01/2000"), icon1},
        {"2", "ni", Boolean.TRUE, format.parse("04/15/1999"), icon2},
        {"3", "san", Boolean.FALSE, format.parse("12/07/1941"), icon2},
        {"4", "shi", Boolean.TRUE, format.parse("02/29/2000"), icon1},
        {"5", "go", Boolean.FALSE, format.parse("05/23/1995"), icon1},
      };
      String columnNames[] =
        {"English", "Japanese", "Boolean", "Date", "ImageIcon"};
      public int getColumnCount() {
        return columnNames.length;
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
      public Class getColumnClass(int column) {
        return (getValueAt(0, column).getClass());
      }
    };

    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Column Renderer Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
