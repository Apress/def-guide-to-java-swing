import javax.swing.*;
import java.awt.*;
public class ListSample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};

        String title = (args.length==0 ? "JList Sample" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList list = new JList(labels);
        JScrollPane scrollPane = new JScrollPane(list);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(200, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
