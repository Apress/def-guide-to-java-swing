import javax.swing.*;
import java.awt.*;	
import java.util.Hashtable;

public class InvertedSliders {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Inverted Sliders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSlider js1 = new JSlider();
        js1.setMajorTickSpacing(10);
        js1.setPaintTicks(true);
        js1.setPaintLabels(true);
        JSlider js2 = new JSlider();
        js2.setInverted(true);
        js2.setMajorTickSpacing(10);
        js2.setPaintTicks(true);
        js2.setPaintLabels(true);
        JSlider js3 = new JSlider(JSlider.VERTICAL);
        js3.setPaintTrack(false);
        js3.setMajorTickSpacing(10);
        js3.setPaintTicks(true);
        js3.setPaintLabels(true);
        JSlider js4 = new JSlider(JSlider.VERTICAL);
        js4.setInverted(true);
        js4.setMajorTickSpacing(10);
        js4.setPaintTicks(true);
        js4.setPaintLabels(true);
        frame.add(js1, BorderLayout.NORTH);
        frame.add(js2, BorderLayout.SOUTH);
        frame.add(js3, BorderLayout.EAST);
        frame.add(js4, BorderLayout.WEST);
        frame.setSize(300, 250);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
