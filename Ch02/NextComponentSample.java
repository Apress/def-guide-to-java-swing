import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class NextComponentSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Reverse Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(3,3));
        // for (int i=1; i<10; i++) {
        for (int i=9; i>0; i--) {
          JButton button = new JButton(Integer.toString(i));
          frame.add(button, 0);
        }

        final Container contentPane = frame.getContentPane();
        Comparator<Component> comp = new Comparator<Component>() {
          public int compare(Component c1, Component c2) {
            Component comps[] = contentPane.getComponents();
            List list = Arrays.asList(comps);
            int first = list.indexOf(c1);
            int second = list.indexOf(c2);
            return second - first;
          }
        };

        FocusTraversalPolicy policy = new SortingFocusTraversalPolicy(comp);
        frame.setFocusTraversalPolicy(policy);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
