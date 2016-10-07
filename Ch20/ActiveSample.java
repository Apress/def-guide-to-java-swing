import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActiveSample {

  private static final String LABEL_FACTORY = "LabelFactory";

  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Active Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIManager.put(LABEL_FACTORY, new ActiveLabel());

        final JPanel panel = new JPanel();

        JButton button = new JButton("Get");

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            JLabel label = (JLabel)UIManager.get(LABEL_FACTORY);
            panel.add(label);
            panel.revalidate();
          }
        };
        button.addActionListener(actionListener);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(200, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
