import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;	

public class AButtonGroup {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Button Group");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        Border border =
          BorderFactory.createTitledBorder("Examples");
        panel.setBorder(border);
        ButtonGroup group = new ButtonGroup();
        AbstractButton abstract1 =
          new JToggleButton("Toggle Button");
        panel.add(abstract1);
        group.add(abstract1);
        AbstractButton abstract2 =
          new JRadioButton("Radio Button");
        panel.add(abstract2);
        group.add(abstract2);
        AbstractButton abstract3 =
          new JCheckBox("Check Box");
        panel.add(abstract3);
        group.add(abstract3);
        AbstractButton abstract4 =
          new JRadioButtonMenuItem("Radio Button Menu Item");
        panel.add(abstract4);
        group.add(abstract4);
        AbstractButton abstract5 =
          new JCheckBoxMenuItem("Check Box Menu Item");
        panel.add(abstract5);
        group.add(abstract5);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
