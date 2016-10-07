import javax.swing.*;
import java.awt.*;

public class HeaderlessSample {
  public static void main(String args[]) {
    final Object rowData[][] = {{"Row1-Column1", "Row1-Column2", "Row1-Column3"}, {"Row2-Column1", "Row2-Column2", "Row2-Column3"}};
    final Object columnNames[] = {"Column 1", "Column 2", "Column 3"};
    Runnable runner = new Runnable() {
      public void run() {
//        JTable table = new HeaderlessTable(rowData, columnNames);
        JTable table = new JTable(rowData, columnNames);
        table.setTableHeader(null);
        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setColumnHeaderView(null);
        JFrame frame = new JFrame("Headerless Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }

  static class HeaderlessTable extends JTable {
    public HeaderlessTable(Object rowData[][], Object columnNames[]) {
      super(rowData, columnNames);
    }
    protected void configureEnclosingScrollPane() {
      Container container = getParent();
      if (container instanceof JViewport) {
        Container viewParent = container.getParent();
        if (viewParent instanceof JScrollPane) {
          JScrollPane scrollPane = (JScrollPane)viewParent;
          JViewport viewport = scrollPane.getViewport();
          if (viewport == null || viewport.getView() != this) {
            return;
          }
          // scrollPane.setColumnHeaderView(getTableHeader());
          scrollPane.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        }
      }
    }
  }
}
