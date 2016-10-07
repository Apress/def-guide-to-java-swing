import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class NumberInputSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Number Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("SansSerif", Font.BOLD, 16);

        JLabel label;
        JFormattedTextField input;
        JPanel panel;

        BoxLayout layout =
          new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);

        Format currency =
          NumberFormat.getCurrencyInstance(Locale.UK);
        label = new JLabel("UK Currency:");
        input = new JFormattedTextField(currency);
        input.setValue(2424.50);
        input.setColumns(20);
        input.setFont(font);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);

        Format general = NumberFormat.getInstance();
        label = new JLabel("General/Instance:");
        input = new JFormattedTextField(general);
        input.setValue(2424.50);
        input.setColumns(20);
        input.setFont(font);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);

        Format integer = NumberFormat.getIntegerInstance(Locale.ITALIAN);
        label = new JLabel("Italian integer:");
        input = new JFormattedTextField(integer);
        input.setValue(2424.50);
        input.setColumns(20);
        input.setFont(font);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);

        Format number = NumberFormat.getNumberInstance(Locale.FRENCH);
        label = new JLabel("French Number:");
        input = new JFormattedTextField(number);
        input.setValue(2424.50);
        input.setColumns(20);
        input.setFont(font);
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(input);
        frame.add(panel);

        label = new JLabel("Raw Number:");
        input = new JFormattedTextField(2424.50);
        input.setColumns(20);
        input.setFont(font);
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
