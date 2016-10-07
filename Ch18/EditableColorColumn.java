import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class EditableColorColumn {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        Color choices[] = {Color.RED, Color.ORANGE, Color.YELLOW,
          Color.GREEN, Color.BLUE, Color.MAGENTA};
        ComboTableCellRenderer renderer = new ComboTableCellRenderer();
        JComboBox comboBox = new JComboBox(choices);
        comboBox.setRenderer(renderer);
        TableCellEditor editor = new DefaultCellEditor(comboBox);

        JFrame frame = new JFrame("Editable Color Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TableModel model = new ColorTableModel();
        JTable table = new JTable(model);

        TableColumn column = table.getColumnModel().getColumn(3);
        column.setCellRenderer(renderer);
        column.setCellEditor(editor);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
