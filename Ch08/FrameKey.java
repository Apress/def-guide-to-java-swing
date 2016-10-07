import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameKey {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final JFrame frame = new JFrame("Frame Key");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Action actionListener = new AbstractAction() {
          public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Got an M");
            JDialog dialog = new EscapeDialog(frame, "Hey");
            JButton button = new JButton ("Okay");
            ActionListener innerActionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Dialog Button Selected");
              }
            };
            button.addActionListener(innerActionListener);
            dialog.getContentPane().add(button, BorderLayout.SOUTH);
            dialog.setSize(200,200);
            dialog.setVisible(true);
          }
        };

        JPanel content = (JPanel)frame.getContentPane();
        KeyStroke stroke = KeyStroke.getKeyStroke("M");

        InputMap inputMap = 
          content.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, "OPEN");
        content.getActionMap().put("OPEN", actionListener);

        frame.setSize(300, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

