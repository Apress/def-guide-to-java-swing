import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.*;
import java.util.*;

public class SpinnerSample {
  public static void main (final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = ((args.length >= 1) ? args[0] : "JSpinner Sample");
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.FRENCH);
        ChangeListener listener = new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            System.out.println("Source: " + e.getSource());
          }
        };

        String days[] = symbols.getWeekdays();
        SpinnerModel model1 = new SpinnerListModel(days);
        JSpinner spinner1 = new JSpinner(model1);
        spinner1.addChangeListener(listener);
        JLabel label1 = new JLabel("French Days/List");
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(label1, BorderLayout.WEST);
        panel1.add(spinner1, BorderLayout.CENTER);
        frame.add(panel1, BorderLayout.NORTH);

        SpinnerModel model2 = new SpinnerDateModel();
        JSpinner spinner2 = new JSpinner(model2);
        spinner2.addChangeListener(listener);
        JLabel label2 = new JLabel("Dates/Date");
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(label2, BorderLayout.WEST);
        panel2.add(spinner2, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.CENTER);

        SpinnerModel model3 = new SpinnerNumberModel();
        JSpinner spinner3 = new JSpinner(model3);
        spinner3.addChangeListener(listener);
        JLabel label3 = new JLabel("Numbers");
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(label3, BorderLayout.WEST);
        panel3.add(spinner3, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        frame.setSize(200, 90);
        frame.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
