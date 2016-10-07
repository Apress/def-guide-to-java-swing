import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
public class PopupComboSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String labels[] = {"Chardonnay", "Sauvignon", "Riesling", "Cabernet",
          "Zinfandel", "Merlot", "Pinot Noir", "Sauvignon Blanc", "Syrah",
          "Gewürztraminer"};
        JFrame frame = new JFrame("Popup JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox comboBox = new JComboBox(labels);
        comboBox.setMaximumRowCount(5);
        comboBox.setUI((ComboBoxUI)MyComboBoxUI.createUI(comboBox));
        frame.add(comboBox, BorderLayout.NORTH);

        frame.setSize (300, 200);
        frame.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
  static class MyComboBoxUI extends BasicComboBoxUI {
    public static ComponentUI createUI(JComponent c) {
      return new MyComboBoxUI();
    }
    protected JButton createArrowButton() {
      JButton button = new BasicArrowButton(BasicArrowButton.EAST);
      return button;
    }
  }
}
