import javax.swing.*;
import java.awt.*;	

public class AFilledSlider {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Filled Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JSlider js1 = new JSlider();
	js1.putClientProperty("JSlider.isFilled", Boolean.TRUE);
	JSlider js2 = new JSlider();
	js2.putClientProperty("JSlider.isFilled", Boolean.FALSE);
	frame.getContentPane().add(js1, BorderLayout.NORTH);
	frame.getContentPane().add(js2, BorderLayout.SOUTH);
	frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
