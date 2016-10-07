import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class SpinnerSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JSpinner Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	DateFormatSymbols symbols = new DateFormatSymbols(Locale.FRENCH);
	String days[] = symbols.getWeekdays();
	SpinnerModel model1 = new SpinnerListModel(days);
	SpinnerModel model2 = new SpinnerDateModel();
	JSpinner spinner1 = new JSpinner(model1);
	JSpinner spinner2 = new JSpinner(model2);
        f.add(spinner1, BorderLayout.NORTH);
        f.add(spinner2, BorderLayout.SOUTH);
        f.setSize (300, 100);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
