import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SpinnerDateSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("JSpinner Dates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpinnerModel model1 = new SpinnerDateModel();
        JSpinner spinner1 = new JSpinner(model1);
        JLabel label1 = new JLabel("All");
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(label1, BorderLayout.WEST);
        panel1.add(spinner1, BorderLayout.CENTER);
        frame.add(panel1, BorderLayout.NORTH);

	Calendar cal = Calendar.getInstance();
	Date now = cal.getTime();
	cal.add(Calendar.YEAR, -50);
	Date startDate = cal.getTime();
	cal.add(Calendar.YEAR, 100);
	Date endDate = cal.getTime();
        SpinnerModel model2 =
          new SpinnerDateModel(now, startDate, endDate, Calendar.YEAR);
        JSpinner spinner2 = new JSpinner(model2);
        JLabel label2 = new JLabel("Range");
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(label2, BorderLayout.WEST);
        panel2.add(spinner2, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.setSize(200, 90);
        frame.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
