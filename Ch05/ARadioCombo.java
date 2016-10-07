import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class ARadioCombo {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Radio/Combo Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        Border border = BorderFactory.createTitledBorder("Radio Buttons");
        panel.setBorder(border);
        ButtonGroup group = new ButtonGroup();
        JRadioButton aRadioButton = new JRadioButton("4 slices");
        panel.add(aRadioButton);
        group.add(aRadioButton);
        aRadioButton = new JRadioButton("8 slices", true);
        panel.add(aRadioButton);
        group.add(aRadioButton);
        aRadioButton = new JRadioButton("12 slices");
        panel.add(aRadioButton);
        group.add(aRadioButton);
        aRadioButton = new JRadioButton("16 slices");
        panel.add(aRadioButton);
        group.add(aRadioButton);
        frame.add(panel, BorderLayout.WEST);
        panel = new JPanel(new GridLayout(0, 1));
        border = BorderFactory.createTitledBorder("Check Boxes");
        panel.setBorder(border);
        JCheckBox aCheckBox = new JCheckBox("Anchovies");
        panel.add(aCheckBox);
        aCheckBox = new JCheckBox("Garlic", true);
        panel.add(aCheckBox);
        aCheckBox = new JCheckBox("Onions");
        panel.add(aCheckBox);
        aCheckBox = new JCheckBox("Spinach");
        panel.add(aCheckBox);
        frame.add(panel, BorderLayout.EAST);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
