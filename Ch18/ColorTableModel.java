import java.awt.*;
import javax.swing.table.*;

public class ColorTableModel extends AbstractTableModel {

  Object rowData[][] = {
    {"1", "ichi - \u4E00", Boolean.TRUE, Color.RED},
    {"2", "ni - \u4E8C", Boolean.TRUE, Color.BLUE},
    {"3", "san - \u4E09", Boolean.FALSE, Color.GREEN},
    {"4", "shi - \u56DB", Boolean.TRUE, Color.MAGENTA},
    {"5", "go - \u4E94", Boolean.FALSE, Color.PINK},
  };
  String columnNames[] = {"English", "Japanese", "Boolean", "Color"};
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
  public void setValueAt(Object value, int row, int column) {
    rowData[row][column]=value;
  }
  public boolean isCellEditable(int row, int column) {
    return (column != 0);
  }
}
