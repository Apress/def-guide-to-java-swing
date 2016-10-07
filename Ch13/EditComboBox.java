import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class EditComboBox {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};
        JFrame frame = new JFrame("Editable JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JComboBox comboBox = new JComboBox(labels);
        comboBox.setMaximumRowCount(5);
        comboBox.setEditable(true);
        frame.add(comboBox, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            textArea.append("Selected: " + comboBox.getSelectedItem());
            textArea.append(", Position: " + comboBox.getSelectedIndex());
            textArea.append(System.getProperty("line.separator"));
          }
        };
        comboBox.addActionListener(actionListener);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
