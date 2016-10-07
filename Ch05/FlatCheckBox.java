import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class FlatCheckBox {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Flat CheckBox Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        Border border = BorderFactory.createTitledBorder("Pizza Toppings");
        panel.setBorder(border);
        JCheckBox check = new JCheckBox("Anchovies");
        check.setBorderPaintedFlat(true);
        panel.add(check);
        check = new JCheckBox("Garlic");
        panel.add(check);
        check = new JCheckBox("Onions");
        check.setBorderPaintedFlat(true);
        panel.add(check);
        check = new JCheckBox("Pepperoni");
        panel.add(check);
        check = new JCheckBox("Spinach");
        check.setBorderPaintedFlat(true);
        panel.add(check);
        JButton button = new JButton ("Submit");
        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
