import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

public class SparseTableModel extends AbstractTableModel {

  static final long serialVersionUID = 5774430402629969511L;

  private Map<Point, Object> lookup;
  private final int rows;
  private final int columns;
  private final String headers[];

  public SparseTableModel(int rows, String columnHeaders[]) {
    if ((rows < 0) || (columnHeaders == null)) {
      throw new IllegalArgumentException("Invalid row count/columnHeaders");
    }
    this.rows = rows;
    this.columns = columnHeaders.length;
    headers = columnHeaders;
    lookup = new HashMap<Point, Object>();
  }

  public int getColumnCount() {
    return columns;
  }

  public int getRowCount() {
    return rows;
  }

  public String getColumnName(int column) {
    return headers[column];
  }

  public Object getValueAt(int row, int column) {
    return lookup.get(new Point(row, column));
  }

  public void setValueAt(Object value, int row, int column) {
    if ((rows < 0) || (columns < 0)) {
      throw new IllegalArgumentException("Invalid row/column setting");
    }
    if ((row < rows) && (column < columns)) {
      lookup.put(new Point(row, column), value);
    }
  }
}
