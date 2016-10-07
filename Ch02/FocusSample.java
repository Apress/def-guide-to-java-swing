import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Focus Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener actionListener = new ActionFocusMover();
        MouseListener  mouseListener  = new MouseEnterFocusMover();

        frame.setLayout(new GridLayout(3,3));
        for (int i=1; i<10; i++) {
          JButton button = new JButton(Integer.toString(i));
          button.addActionListener(actionListener);
          button.addMouseListener(mouseListener);
          if ((i%2) != 0) { // odd - enabled by default
            button.setFocusable(false);
          }
          frame.add(button);
        }

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

