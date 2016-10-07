import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IconCheckBoxSample {
  private static class CheckBoxIcon implements Icon {
    private ImageIcon checkedIcon = new ImageIcon("Plus.gif");
    private ImageIcon uncheckedIcon = new ImageIcon("Minus.gif");

    public void paintIcon(Component component, Graphics g, int x, int y) {
      AbstractButton abstractButton = (AbstractButton)component;
      ButtonModel buttonModel = abstractButton.getModel();
      g.translate(x,y);
      ImageIcon imageIcon = buttonModel.isSelected() ?
        checkedIcon : uncheckedIcon;
      Image image = imageIcon.getImage();
      g.drawImage(image, 0, 0, component);
      g.translate(-x,-y);
    }
    public int getIconWidth() {
      return 20;
    }
    public int getIconHeight() {
      return 20;
    }
  }
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Iconizing CheckBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon checked = new DiamondIcon (Color.BLACK, true);
        Icon unchecked = new DiamondIcon (Color.BLACK, false);
        JCheckBox aCheckBox1 = new JCheckBox("Pizza", unchecked);
        aCheckBox1.setSelectedIcon(checked);
        JCheckBox aCheckBox2 = new JCheckBox("Calzone");
        aCheckBox2.setIcon(unchecked);
        aCheckBox2.setSelectedIcon(checked);
        Icon checkBoxIcon = new CheckBoxIcon();
        JCheckBox aCheckBox3 = new JCheckBox("Anchovies", checkBoxIcon);
        JCheckBox aCheckBox4 = new JCheckBox("Stuffed Crust", checked);
        frame.setLayout(new GridLayout(0,1));
        frame.add(aCheckBox1);
        frame.add(aCheckBox2);
        frame.add(aCheckBox3);
        frame.add(aCheckBox4);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
   }
}
