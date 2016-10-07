import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class RangeSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Range Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        frame.add(new JLabel("Range: 0-255"));
        JTextField textFieldOne = new JTextField();
        Document textDocOne = textFieldOne.getDocument();
        DocumentFilter filterOne = new IntegerRangeDocumentFilter(0, 255);
        ((AbstractDocument)textDocOne).setDocumentFilter(filterOne);
        frame.add(textFieldOne);

        frame.add(new JLabel("Range: -100-100"));
        JTextField textFieldTwo = new JTextField();
        Document textDocTwo = textFieldTwo.getDocument();
        DocumentFilter filterTwo = new IntegerRangeDocumentFilter(-100, 100);
        ((AbstractDocument)textDocTwo).setDocumentFilter(filterTwo);
        frame.add(textFieldTwo);

        frame.add(new JLabel("Range: 1000-2000"));
        JTextField textFieldThree = new JTextField();
        Document textDocThree = textFieldThree.getDocument();
        DocumentFilter filterThree = new IntegerRangeDocumentFilter(1000, 2000);
        ((AbstractDocument)textDocThree).setDocumentFilter(filterThree);
        frame.add(textFieldThree);

        frame.setSize(250, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
