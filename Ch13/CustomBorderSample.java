import javax.swing.*;
import java.awt.*;
public class CustomBorderSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};
        JFrame frame = new JFrame("Custom Border");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList jlist = new JList(labels);
        ListCellRenderer renderer = new FocusedTitleListCellRenderer();
        jlist.setCellRenderer(renderer);
        JScrollPane sp = new JScrollPane(jlist);
        frame.add(sp, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
