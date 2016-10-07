import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class PopupComboSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};
        JFrame frame = new JFrame("Popup JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

UIManager.put("ComboBoxUI", "MyComboBoxUI");
        JComboBox comboBox = new JComboBox(labels);
        comboBox.setMaximumRowCount(5);
//        comboBox.setUI((ComboBoxUI)MyComboBoxUI.createUI(comboBox));
        frame.add(comboBox, BorderLayout.NORTH);

        JComboBox comboBox2 = new JComboBox(labels);
        frame.add(comboBox2, BorderLayout.SOUTH);

        frame.setSize (300, 100);
        frame.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
