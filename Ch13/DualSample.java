import javax.swing.*;
import java.awt.*;
public class DualSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};

        JFrame frame = new JFrame("Sample Components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList list = new JList(labels);
        JScrollPane scrollPane = new JScrollPane(list);

        JComboBox comboBox = new JComboBox(labels);
        comboBox.setMaximumRowCount(4);

        frame.add(comboBox, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize (300, 200);
        frame.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
