import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SpinnerListSample {
  public static void main (final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("JSpinner Lists");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpinnerModel model1 = new SpinnerListModel();
        JSpinner spinner1 = new JSpinner(model1);
        JLabel label1 = new JLabel("None");
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(label1, BorderLayout.WEST);
        panel1.add(spinner1, BorderLayout.CENTER);
        frame.add(panel1, BorderLayout.NORTH);

        SpinnerModel model2 = new SpinnerListModel(args);
        JSpinner spinner2 = new JSpinner(model2);
        JLabel label2 = new JLabel("Args");
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
