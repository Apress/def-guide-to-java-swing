import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;	
import java.awt.event.*;	

public class ScrollBarSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        AdjustmentListener adjustmentListener = new AdjustmentListener() {
          public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
            System.out.println("Adjusted: " + adjustmentEvent.getValue());
          }
        };
        JScrollBar oneJScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        oneJScrollBar.addAdjustmentListener(adjustmentListener);

        ChangeListener changeListener = new BoundedChangeListener();
        JScrollBar anotherJScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        BoundedRangeModel model = anotherJScrollBar.getModel();
        model.addChangeListener(changeListener);

        JFrame frame = new JFrame("ScrollBars R Us");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(oneJScrollBar, BorderLayout.NORTH);
        frame.add(anotherJScrollBar, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

