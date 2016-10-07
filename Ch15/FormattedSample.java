import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class FormattedSample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Formatted Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel datePanel = new JPanel(new BorderLayout());
        JLabel dateLabel = new JLabel("Date: ");
        dateLabel.setDisplayedMnemonic(KeyEvent.VK_D);
        DateFormat format = new SimpleDateFormat("yyyy--MMMM--dd");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        dateLabel.setLabelFor(dateTextField);
        datePanel.add(dateLabel, BorderLayout.WEST);
        datePanel.add(dateTextField, BorderLayout.CENTER);
        frame.add(datePanel, BorderLayout.NORTH);

        JPanel date2Panel = new JPanel(new BorderLayout());
        JLabel date2Label = new JLabel("Date 2: ");
        date2Label.setDisplayedMnemonic(KeyEvent.VK_C);
        DateFormat displayFormat = new SimpleDateFormat("yyyy--MMMM--dd");
        DateFormatter displayFormatter = new DateFormatter(displayFormat);
        DateFormat editFormat = new SimpleDateFormat("MM/dd/yy");
        DateFormatter editFormatter = new DateFormatter(editFormat);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(
          displayFormatter, displayFormatter, editFormatter);
        JFormattedTextField date2TextField = new JFormattedTextField(factory,
          new Date());
        date2Label.setLabelFor(date2TextField);
        date2Panel.add(date2Label, BorderLayout.WEST);
        date2Panel.add(date2TextField, BorderLayout.CENTER);
        frame.add(date2Panel, BorderLayout.SOUTH);

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            JFormattedTextField source =
              (JFormattedTextField)actionEvent.getSource();
            Object value = source.getValue();
	    System.out.println("Class: " + value.getClass());
	    System.out.println("Value: " + value);
          }
        };
        dateTextField.addActionListener(actionListener);
        date2TextField.addActionListener(actionListener);

        frame.setSize(250, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
