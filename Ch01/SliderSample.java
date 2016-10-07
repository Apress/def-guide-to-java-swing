import java.awt.*;
import javax.swing.*;

public class SliderSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JSlider Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSlider slider = new JSlider ();
        slider.setMinorTickSpacing (5);
        slider.setMajorTickSpacing (10);
        slider.setPaintTicks (true);
        slider.setSnapToTicks(true);
        slider.setPaintTrack (false);
        slider.setPaintLabels (true);
        f.add(slider, BorderLayout.CENTER);
        f.setSize (300, 100);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
