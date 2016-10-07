import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ButtonPopupSample {

  static final Random random = new Random();

  // Define ActionListener
  static class ButtonActionListener implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
      System.out.println("Selected: " + actionEvent.getActionCommand());
    }
  }

  // Define Show Popup ActionListener
  static class ShowPopupActionListener implements ActionListener {
    private Component component;
    ShowPopupActionListener(Component component) {
      this.component = component;
    }
    public synchronized void actionPerformed(ActionEvent actionEvent) {
      JButton button = new JButton("Hello, World");
      ActionListener listener = new ButtonActionListener();
      button.addActionListener(listener);
      PopupFactory factory = PopupFactory.getSharedInstance();
      int x = random.nextInt(200);
      int y = random.nextInt(200);
      final Popup popup = factory.getPopup(component, button, x, y);
      popup.show();
      ActionListener hider = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          popup.hide();
        }
      };
      // Hide popup in 3 seconds
      Timer timer = new Timer(3000, hider);
      timer.start();
    }
  }

  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        // Create frame
        JFrame frame = new JFrame("Button Popup Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener actionListener = new ShowPopupActionListener(frame);

        JButton start = new JButton("Pick Me for Popup");
        start.addActionListener(actionListener);
        frame.add(start);

        frame.setSize(350, 250);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

