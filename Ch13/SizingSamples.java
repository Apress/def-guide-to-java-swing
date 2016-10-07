import javax.swing.*;
import java.awt.*;
public class SizingSamples {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};

        JFrame frame = new JFrame("Sizing Samples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JList jlist1 = new JList(labels);
        jlist1.setVisibleRowCount(4);
        DefaultListModel model = new DefaultListModel();
        model.ensureCapacity(1000);
        for (int i=0;i<100;i++) {
          for (int j=0;j<10;j++) {
            model.addElement(labels[j]);
          }
        }
        JScrollPane scrollPane1 = new JScrollPane(jlist1);
        frame.add(scrollPane1, BorderLayout.NORTH);

        JList jlist2 = new JList(model);
        jlist2.setVisibleRowCount(4);
        jlist2.setFixedCellHeight(12);
        jlist2.setFixedCellWidth(200);
        JScrollPane scrollPane2 = new JScrollPane(jlist2);
        frame.add(scrollPane2, BorderLayout.CENTER);

        JList jlist3 = new JList(labels);
        jlist3.setVisibleRowCount(4);
        frame.add(jlist3, BorderLayout.SOUTH);

        frame.setSize(300, 350);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

