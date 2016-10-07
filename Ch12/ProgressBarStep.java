import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

public class ProgressBarStep {
  static class BarThread extends Thread {
    private static int DELAY = 500;
    JProgressBar progressBar;

    public BarThread(JProgressBar bar) {
      progressBar = bar;
    }

    public void run() {
      int minimum = progressBar.getMinimum();
      int maximum = progressBar.getMaximum();
      Runnable runner = new Runnable() {
        public void run() {
          int value = progressBar.getValue();
          progressBar.setValue(value+1);
        }
      };
      for (int i=minimum; i<maximum; i++) {
        try {
          EventQueue.invokeAndWait(runner);
          // our job for each step is to just sleep
          Thread.sleep(DELAY);
        } catch (InterruptedException ignoredException) {
        } catch (InvocationTargetException ignoredException) {
        }
      }
    }
  }
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "Stepping Progress" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JProgressBar aJProgressBar = new JProgressBar(0, 50);
        aJProgressBar.setStringPainted(true);

        final JButton aJButton = new JButton("Start");

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            aJButton.setEnabled(false);
            Thread stepper = new BarThread(aJProgressBar);
            stepper.start();
          }
        };

        aJButton.addActionListener(actionListener);

        frame.add(aJProgressBar, BorderLayout.NORTH);
        frame.add(aJButton, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
