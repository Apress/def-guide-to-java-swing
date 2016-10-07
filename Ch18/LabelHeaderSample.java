import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;

public class LabelHeaderSample {
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
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Label Header");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String headers[] = {"English", "Japanese"};
        JTable table = new JTable(rows, headers);
        JScrollPane scrollPane = new JScrollPane(table);

        Icon redIcon = new DiamondIcon(Color.RED);
        Icon blueIcon = new DiamondIcon(Color.BLUE);

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");

        JLabel blueLabel = new JLabel(headers[0], blueIcon, JLabel.CENTER);
        blueLabel.setBorder(headerBorder);
        JLabel redLabel = new JLabel(headers[1], redIcon, JLabel.CENTER);
        redLabel.setBorder(headerBorder);

        TableCellRenderer renderer = new JComponentTableCellRenderer();

        TableColumnModel columnModel = table.getColumnModel();

        TableColumn column0 = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);

        column0.setHeaderRenderer(renderer);
        column0.setHeaderValue(blueLabel);

        column1.setHeaderRenderer(renderer);
        column1.setHeaderValue(redLabel);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
