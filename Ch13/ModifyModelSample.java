import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Enumeration;

public class ModifyModelSample {
  static String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
    "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
    "Gewürztraminer"};

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Modifying Model");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fill model
        final DefaultListModel model = new DefaultListModel();
        for (int i=0, n=labels.length; i<n; i++) {
          model.addElement(labels[i]);
        }
        JList jlist = new JList(model);
        JScrollPane scrollPane1 = new JScrollPane(jlist);
        frame.add(scrollPane1, BorderLayout.WEST);

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(textArea);
        frame.add(scrollPane2, BorderLayout.CENTER);

        ListDataListener listDataListener = new ListDataListener() {
          public void contentsChanged(ListDataEvent listDataEvent) {
            appendEvent(listDataEvent);
          }
          public void intervalAdded(ListDataEvent listDataEvent) {
            appendEvent(listDataEvent);
          }
          public void intervalRemoved(ListDataEvent listDataEvent) {
            appendEvent(listDataEvent);
          }
          private void appendEvent(ListDataEvent listDataEvent) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            switch (listDataEvent.getType()) {
              case ListDataEvent.CONTENTS_CHANGED:
                pw.print("Type: Contents Changed");
                break;
              case ListDataEvent.INTERVAL_ADDED:
                pw.print("Type: Interval Added");
                break;
              case ListDataEvent.INTERVAL_REMOVED:
                pw.print("Type: Interval Removed");
                break;
            }
            pw.print(", Index0: " + listDataEvent.getIndex0());
            pw.print(", Index1: " + listDataEvent.getIndex1());
            DefaultListModel theModel =
              (DefaultListModel)listDataEvent.getSource();
	    pw.println(theModel);
            textArea.append(sw.toString());
          }
        };

        model.addListDataListener(listDataListener);

        // Setup buttons
        JPanel jp = new JPanel(new GridLayout(2, 1));
        JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 1));
        JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 1));
        jp.add(jp1);
        jp.add(jp2);
        JButton jb = new JButton("add F");
        jp1.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            model.add(0, "First");
          }
        });
        jb = new JButton("addElement L");
        jp1.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            model.addElement("Last");
          }
        });
        jb = new JButton("insertElementAt M");
        jp1.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            int size = model.getSize();
            model.insertElementAt("Middle", size/2);
          }
        });
        jb = new JButton("set F");
        jp1.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            int size = model.getSize();
            if (size != 0)
              model.set(0, "New First");
          }
        });
        jb = new JButton("setElementAt L");
        jp1.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            int size = model.getSize();
            if (size != 0)
              model.setElementAt("New Last", size-1);
          }
        });
        jb = new JButton("load 10");
        jp1.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            for (int i=0, n=labels.length; i<n ;i++) {
              model.addElement(labels[i]);
            }
          }
        });
        jb = new JButton("clear");
        jp2.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            model.clear();
          }
        });
        jb = new JButton("remove F");
        jp2.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            int size = model.getSize();
            if (size != 0)
              model.remove(0);
          }
        });
        jb = new JButton("removeAllElements");
        jp2.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            model.removeAllElements();
          }
        });
        jb = new JButton("removeElement 'Last'");
        jp2.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            model.removeElement("Last");
          }
        });
        jb = new JButton("removeElementAt M");
        jp2.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            int size = model.getSize();
            if (size != 0)
              model.removeElementAt(size/2);
          }
        });
        jb = new JButton("removeRange FM");
        jp2.add(jb);
        jb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            int size = model.getSize();
            if (size != 0)
              model.removeRange(0,size/2);
          }
        });
        frame.add(jp, BorderLayout.SOUTH);
        frame.setSize(640, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
