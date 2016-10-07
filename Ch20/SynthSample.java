import java.awt.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import javax.swing.plaf.synth.*;

public class SynthSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        SynthLookAndFeel synth = new SynthLookAndFeel();
        try {
          Class aClass = SynthSample.class;
          InputStream is = aClass.getResourceAsStream("config.xml");
          if (is == null) {
            System.err.println("Unable to find theme configuration");
            System.exit(-1);
          }
          synth.load(is, aClass);
        } catch (ParseException e) {
          System.err.println("Unable to load theme configuration");
          System.exit(-2);
        }
        try {
          UIManager.setLookAndFeel(synth);
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
          System.err.println("Unable to change look and feel");
          System.exit(-3);
        }
        JFrame frame = new JFrame("Synth Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Hello, Synth");
        frame.add(button, BorderLayout.CENTER);
        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
