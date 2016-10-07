import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SampleProgress {
  static ProgressMonitor monitor;
  static int progress;
  static Timer timer;

  static class ProgressMonitorHandler implements ActionListener {
    // Called by Timer
    public void actionPerformed(ActionEvent actionEvent) {
      if (monitor == null)
        return;
      if (monitor.isCanceled()) {
        System.out.println("Monitor canceled");
        timer.stop();
      } else {
        progress += 3;
        monitor.setProgress(progress);
        monitor.setNote("Loaded " + progress + " files");
      }
    }
  }

  public static void main(String args[]) {

    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("ProgressMonitor Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout (0, 1));

        // Define Start Button
        JButton startButton = new JButton ("Start");
        ActionListener startActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component parent = (Component)actionEvent.getSource();
            monitor = new ProgressMonitor(parent, "Loading Progress", "Getting Started...", 0, 200);
            progress = 0;
          }
        };
        startButton.addActionListener(startActionListener);
        frame.add(startButton);

        // Define Manual Increase Button
        // Pressing this button increases progress by 5
        JButton increaseButton = new JButton ("Manual Increase");
        ActionListener increaseActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            if (monitor == null)
              return;
            if (monitor.isCanceled()) {
              System.out.println("Monitor canceled");
            } else {
              progress += 5;
              monitor.setProgress(progress);
              monitor.setNote("Loaded " + progress + " files");
            }
          }
        };
        increaseButton.addActionListener(increaseActionListener);
        frame.add(increaseButton);

        // Define Automatic Increase Button
        // Start Timer to increase progress by 3 every 250 ms
        JButton autoIncreaseButton = new JButton ("Automatic Increase");
        ActionListener autoIncreaseActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            if (monitor != null) {
              if (timer == null) {
                timer = new Timer(250, new ProgressMonitorHandler());
              }
              timer.start();
            }
          }
        };
        autoIncreaseButton.addActionListener(autoIncreaseActionListener);
        frame.add(autoIncreaseButton);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
