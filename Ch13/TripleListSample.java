import javax.swing.*;
import java.awt.*;

public class TripleListSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};
        JFrame frame = new JFrame("Selection Modes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList list1 = new JList(labels);
        JList list2 = new JList(labels);
        JList list3 = new JList(labels);
        JScrollPane sp1 = new JScrollPane(list1);
        sp1.setColumnHeaderView(new JLabel("Single Selection"));
        JScrollPane sp2 = new JScrollPane(list2);
        sp2.setColumnHeaderView(new JLabel("Single Interval"));
        JScrollPane sp3 = new JScrollPane(list3);
        sp3.setColumnHeaderView(new JLabel("Multi Interval"));
        Box box = Box.createHorizontalBox();
        box.add(sp1);
        box.add(sp2);
        box.add(sp3);
        frame.add(box, BorderLayout.CENTER);
        frame.setSize (300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
