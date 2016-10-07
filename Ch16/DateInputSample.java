import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class DateInputSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Date/Time Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label;
        JFormattedTextField input;
        JPanel panel;

        BoxLayout layout =
          new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);

        Format shortDate =
          DateFormat.getDateInstance(DateFormat.SHORT);
        label = new JLabel("Short date:");
        input = new JFormattedTextField(shortDate);
        input.setValue(new Date());
        input.setColumns(20);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);
 
        Format fullUSDate =
          DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        label = new JLabel("Full US date:");
        input = new JFormattedTextField(fullUSDate);
        input.setValue(new Date());
        input.setColumns(20);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);
 
        Format mediumItalian =
          DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ITALIAN);
        label = new JLabel("Medium Italian date:");
        input = new JFormattedTextField(mediumItalian);
        input.setValue(new Date());
        input.setColumns(20);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);
 
        Format dayOfWeek = new SimpleDateFormat("E", Locale.FRENCH);
        label = new JLabel("French day of week:");
        input = new JFormattedTextField(dayOfWeek);
        input.setValue(new Date());
        input.setColumns(20);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);
 
        Format shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);
        label = new JLabel("Short time:");
        input = new JFormattedTextField(shortTime);
        input.setValue(new Date());
        input.setColumns(20);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);
 
        frame.pack();
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
