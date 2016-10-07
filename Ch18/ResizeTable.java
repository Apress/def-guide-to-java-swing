import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class ResizeTable {
  public static void main(String args[]) {

    final Object rowData[][] = {
      {"1",  "one",   "ichi - \u4E00",   "un",     "I"},
      {"2",  "two",   "ni - \u4E8C",     "deux",   "II"},
      {"3",  "three", "san - \u4E09",    "trois",  "III"},
      {"4",  "four",  "shi - \u56DB",    "quatre", "IV"},
      {"5",  "five",  "go - \u4E94",     "cinq",   "V"},
      {"6",  "six",   "roku - \u516D",   "treiza", "VI"},
      {"7",  "seven", "shichi - \u4E03", "sept",   "VII"},
      {"8",  "eight", "hachi - \u516B",  "huit",   "VIII"},
      {"9",  "nine",  "kyu - \u4E5D",    "neur",   "IX"},
      {"10", "ten",   "ju - \u5341",     "dix",    "X"}
    };

    final String columnNames[] = {"#", "English", "Japanese", "French", "Roman"};

    Runnable runner = new Runnable() {
      public void run() {
        final JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        String modes[] = {"Resize All Columns", "Resize Last Column", "Resize Next Column",
          "Resize Off", "Resize Subsequent Columns"};
        final int modeKey[] = {
          JTable.AUTO_RESIZE_ALL_COLUMNS,
          JTable.AUTO_RESIZE_LAST_COLUMN,
          JTable.AUTO_RESIZE_NEXT_COLUMN,
          JTable.AUTO_RESIZE_OFF,
          JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS};
        JComboBox resizeModeComboBox = new JComboBox(modes);
        int defaultMode = 4;
        table.setAutoResizeMode(modeKey[defaultMode]);
        resizeModeComboBox.setSelectedIndex(defaultMode);
        ItemListener itemListener = new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            JComboBox source = (JComboBox)e.getSource();
            int index = source.getSelectedIndex();
            table.setAutoResizeMode(modeKey[index]);
          }
        };
        resizeModeComboBox.addItemListener(itemListener);

        JFrame frame = new JFrame("Resizing Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(resizeModeComboBox, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
