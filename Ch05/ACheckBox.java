import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class ACheckBox {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "CheckBox Sample" : args[0]);
        JFrame frame = new JFrame(title);
//        JFrame frame = new JFrame("CheckBox Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        Border border = BorderFactory.createTitledBorder("Pizza Toppings");
        panel.setBorder(border);
        JCheckBox check = new JCheckBox("Anchovies");
        panel.add(check);
        check = new JCheckBox("Garlic");
        panel.add(check);
        check = new JCheckBox("Onions");
        panel.add(check);
        check = new JCheckBox("Pepperoni");
        panel.add(check);
        check = new JCheckBox("Spinach");
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

