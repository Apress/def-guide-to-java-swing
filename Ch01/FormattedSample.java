import java.awt.*;
import java.text.*; 
import javax.swing.*;
import javax.swing.text.*; 

public class FormattedSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JFormattedTextField Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box rowOne = Box.createHorizontalBox();
        rowOne.add(new JLabel("SSN:"));
	try {
          MaskFormatter mf1 = new MaskFormatter("###-##-####");
          rowOne.add(new JFormattedTextField(mf1));
	} catch (ParseException e) {
	}
        Box rowTwo = Box.createHorizontalBox();
        rowTwo.add(new JLabel("Telephone #: "));
	try {
          MaskFormatter mf2 = new MaskFormatter("(###) ###-####");
          rowTwo.add(new JFormattedTextField(mf2));
	} catch (ParseException e) {
	}
        f.add(rowOne, BorderLayout.NORTH);
        f.add(rowTwo, BorderLayout.SOUTH);
        f.setSize (300, 100);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
