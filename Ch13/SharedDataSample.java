import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SharedDataSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final String labels[] = {"Chardonnay", "Sauvignon", "Riesling",
          "Cabernet", "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc",
          "Syrah", "Gewürztraminer"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);

        JFrame frame = new JFrame("Shared Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JComboBox comboBox1 = new JComboBox(model);
        comboBox1.setMaximumRowCount(5);
        comboBox1.setEditable(true);

        JComboBox comboBox2 = new JComboBox(model);
        comboBox2.setMaximumRowCount(5);
        comboBox2.setEditable(true);
        panel.add(comboBox1);
        panel.add(comboBox2);
        frame.add(panel, BorderLayout.NORTH);

        JList jlist = new JList(model);
        JScrollPane scrollPane = new JScrollPane(jlist);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton button = new JButton("Add");
        frame.add(button, BorderLayout.SOUTH);
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            int index = (int)(Math.random()*labels.length);
            model.addElement(labels[index]);
          }
        };
        button.addActionListener(actionListener);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
