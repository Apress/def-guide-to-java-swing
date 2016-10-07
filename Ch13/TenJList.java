import javax.swing.*;
import java.awt.*;

public class TenJList {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};
        JFrame frame = new JFrame("Example JList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList jlistNoScroll = new JList(labels);
        JList jlistScroll   = new JList(labels);
        frame.add(jlistNoScroll, BorderLayout.WEST);
        JScrollPane sp = new JScrollPane(jlistScroll);
        frame.add(sp, BorderLayout.EAST);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
