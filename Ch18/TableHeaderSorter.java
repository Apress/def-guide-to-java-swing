import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;

public class TableHeaderSorter extends MouseAdapter {

  private TableSorter sorter;
  private JTable table;

  private TableHeaderSorter() {
  }

  public static void install(TableSorter sorter, JTable table) {
    TableHeaderSorter tableHeaderSorter = new TableHeaderSorter();
    tableHeaderSorter.sorter = sorter;
    tableHeaderSorter.table  = table;
    JTableHeader tableHeader = table.getTableHeader();
    tableHeader.addMouseListener(tableHeaderSorter);
  }

  public void mouseClicked(MouseEvent mouseEvent) {
    TableColumnModel columnModel = table.getColumnModel();
    int viewColumn = columnModel.getColumnIndexAtX(mouseEvent.getX());
    int column = table.convertColumnIndexToModel(viewColumn);
    if (mouseEvent.getClickCount() == 1 && column != -1) {
      System.out.println("Sorting ...");
      int shiftPressed = (mouseEvent.getModifiers() & InputEvent.SHIFT_MASK);
      boolean ascending = (shiftPressed == 0);
      sorter.sortByColumn(column, ascending);
    }
  }
}
