import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ListProperties {
  static class CustomTableModel extends AbstractTableModel {
    Vector<Object> keys = new Vector<Object>();
    Vector<Object> values = new Vector<Object>();
    private static final String columnNames[] = {"Property String", "Value"};

    public int getColumnCount() {
      return columnNames.length;
    }

    public String getColumnName(int column) {
      return columnNames[column];
    }

    public int getRowCount() {
      return keys.size();
    }

    public Object getValueAt(int row, int column) {
      Object returnValue = null;
      if (column == 0) {
        returnValue = keys.elementAt(row);
      } else if (column == 1) {
        returnValue = values.elementAt(row);

      }
      return returnValue;
    }

    public synchronized void uiDefaultsUpdate(UIDefaults defaults) {
      Enumeration newKeys = defaults.keys();
      keys.removeAllElements();
      while (newKeys.hasMoreElements()) {
        keys.addElement(newKeys.nextElement());
      }

      Enumeration newValues = defaults.elements();
      values.removeAllElements();
      while (newValues.hasMoreElements()) {
        values.addElement(newValues.nextElement());
      }

      fireTableDataChanged();
    }
  }

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final JFrame frame = new JFrame("List Properties");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final CustomTableModel model = new CustomTableModel();
        model.uiDefaultsUpdate(UIManager.getDefaults());
        TableSorter sorter = new TableSorter(model);
    
        JTable table = new JTable(sorter);
        TableHeaderSorter.install(sorter, table);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        UIManager.LookAndFeelInfo looks[] =
          UIManager.getInstalledLookAndFeels();

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            final String lafClassName = actionEvent.getActionCommand();
            Runnable runnable = new Runnable() {
              public void run() {
                try {
                  UIManager.setLookAndFeel(lafClassName);
                  SwingUtilities.updateComponentTreeUI(frame);
                  model.uiDefaultsUpdate(UIManager.getDefaults());
                } catch (Exception exception) {
                  JOptionPane.showMessageDialog (
                    frame, "Can't change look and feel",
                    "Invalid PLAF", JOptionPane.ERROR_MESSAGE);
                }
              }
            };
            EventQueue.invokeLater(runnable);
          }
        };

        JToolBar toolbar = new JToolBar();
        for (int i=0, n=looks.length; i<n; i++) {
          JButton button = new JButton(looks[i].getName());
          button.setActionCommand(looks[i].getClassName());
          button.addActionListener(actionListener);
          toolbar.add(button);
        }

        frame.add(toolbar, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
