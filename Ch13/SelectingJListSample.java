import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SelectingJListSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};
        JFrame frame = new JFrame("Selecting JList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JList jlist = new JList(labels);
        JScrollPane scrollPane1 = new JScrollPane(jlist);
        frame.add(scrollPane1, BorderLayout.WEST);

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(textArea);
        frame.add(scrollPane2, BorderLayout.CENTER);

        ListSelectionListener listSelectionListener =
            new ListSelectionListener() {
          public void valueChanged(ListSelectionEvent listSelectionEvent) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            pw.print("First index: " + listSelectionEvent.getFirstIndex());
            pw.print(", Last index: " + listSelectionEvent.getLastIndex());
            boolean adjust = listSelectionEvent.getValueIsAdjusting();
            pw.println(", Adjusting? " + adjust);
            if (!adjust) {
              JList list = (JList)listSelectionEvent.getSource();
              int selections[] = list.getSelectedIndices();
              Object selectionValues[] = list.getSelectedValues();
              for (int i=0, n=selections.length; i<n; i++) {
                if (i==0) {
                  pw.print("  Selections: ");
                }
                pw.print(selections[i] + "/" + selectionValues[i] + " ");
              }
              pw.println();
            }
            textArea.append(sw.toString());
          }
        };
        jlist.addListSelectionListener(listSelectionListener);

        MouseListener mouseListener = new MouseAdapter() {
          public void mouseClicked(MouseEvent mouseEvent) {
            JList theList = (JList)mouseEvent.getSource();
            if (mouseEvent.getClickCount() == 2) {
              int index = theList.locationToIndex(mouseEvent.getPoint());
              if (index >= 0) {
                Object o = theList.getModel().getElementAt(index);
                textArea.append("Double-clicked on: " + o.toString());
                textArea.append(System.getProperty("line.separator"));
              }
            }
          }
        };
        jlist.addMouseListener(mouseListener);

        frame.setSize(350, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
