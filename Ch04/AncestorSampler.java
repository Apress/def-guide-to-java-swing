import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class AncestorSampler {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Ancestor Sampler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AncestorListener ancestorListener = new AncestorListener() {
          public void ancestorAdded(AncestorEvent ancestorEvent) {
            System.out.println ("Added");
          }
          public void ancestorMoved(AncestorEvent ancestorEvent) {
            System.out.println ("Moved");
          }
          public void ancestorRemoved(AncestorEvent ancestorEvent) {
            System.out.println ("Removed");
          }
        };
        frame.getRootPane().addAncestorListener(ancestorListener);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.getRootPane().setVisible(false);
        frame.getRootPane().setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
