import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TextSlider extends JPanel {
  private JTextField textField;
  private JScrollBar scrollBar;
  public TextSlider() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    textField = new JTextField();
    scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
    BoundedRangeModel brm = textField.getHorizontalVisibility();
    scrollBar.setModel(brm);
    add(textField);
    add(scrollBar);
  }
  public JTextField getTextField() {
    return textField;
  }
  public String getText() {
    return textField.getText();
  }
  public void addActionListener(ActionListener l) {
    textField.addActionListener(l);
  }
  public void removeActionListener(ActionListener l) {
    textField.removeActionListener(l);
  }
  public JScrollBar getScrollBar() {
    return scrollBar;
  }
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Text Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final TextSlider ts = new TextSlider();
        ts.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            System.out.println("Text: " + ts.getText());
          }
        });
        frame.add(ts, BorderLayout.NORTH);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
