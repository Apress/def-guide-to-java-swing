import java.awt.*;
import javax.swing.*;
public class ComboBoxSample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
    String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
      "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
      "Gewürztraminer"};

    String title = (args.length==0 ? "Example JComboBox" : args[0]);
    JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComboBox comboBox1 = new JComboBox(labels);
    comboBox1.setMaximumRowCount(5);
    frame.add(comboBox1, BorderLayout.NORTH);

    JComboBox comboBox2 = new JComboBox(labels);
    comboBox2.setEditable(true);
    frame.add(comboBox2, BorderLayout.SOUTH);

    frame.setSize(300, 200);
    frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
