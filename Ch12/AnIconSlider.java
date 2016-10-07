import javax.swing.*;
import java.awt.*;

public class AnIconSlider {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Icon Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon icon = new ImageIcon("logo.gif");
        UIDefaults defaults = UIManager.getDefaults();
        defaults.put("Slider.horizontalThumbIcon", icon);
        JSlider aJSlider = new JSlider();
        aJSlider.setPaintTicks(true);
        frame.add(aJSlider, BorderLayout.NORTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
