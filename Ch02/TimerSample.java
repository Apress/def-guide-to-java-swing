import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Hello World Timer");
          }
        };
        Timer timer = new Timer(500, actionListener);
        timer.start();
      }
    };
    EventQueue.invokeLater(runner);
  }
}
