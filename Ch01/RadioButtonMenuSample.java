import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonMenuSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JRadioButtonMenuItem Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_O);

        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem("North");
        group.add(menuItem);
        menu.add(menuItem);

        menuItem = new JRadioButtonMenuItem("East");
        group.add(menuItem);
        menu.add(menuItem);

        menuItem = new JRadioButtonMenuItem("West");
        group.add(menuItem);
        menu.add(menuItem);

        menuItem = new JRadioButtonMenuItem("South");
        group.add(menuItem);
        menu.add(menuItem);

        menuItem = new JRadioButtonMenuItem("Center");
        group.add(menuItem);
        menu.add(menuItem);

        bar.add(menu);
        f.setJMenuBar(bar);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
