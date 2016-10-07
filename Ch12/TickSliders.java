import javax.swing.*;
import java.awt.*;

public class TickSliders {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Tick Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // No Ticks
        JSlider jSliderOne = new JSlider();
        // Major Tick 25 - Minor 5
        JSlider jSliderTwo = new JSlider();
        jSliderTwo.setMinorTickSpacing(5);
        jSliderTwo.setMajorTickSpacing(25);
        jSliderTwo.setPaintTicks(true);
        jSliderTwo.setSnapToTicks(true);
        // Major Tick 25 - Minor 6
        JSlider jSliderThree = new JSlider(JSlider.VERTICAL);
        jSliderThree.setMinorTickSpacing(6);
        jSliderThree.setMajorTickSpacing(25);
        jSliderThree.setPaintTicks(true);
        JSlider jSliderFour = new JSlider(JSlider.VERTICAL);
        // Major Tick 25 - Minor 1
        jSliderFour.setMinorTickSpacing(1);
        jSliderFour.setMajorTickSpacing(25);
        jSliderFour.setPaintTicks(true);

        frame.add(jSliderOne, BorderLayout.NORTH);
        frame.add(jSliderTwo, BorderLayout.SOUTH);
        frame.add(jSliderThree, BorderLayout.WEST);
        frame.add(jSliderFour, BorderLayout.EAST);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
