import javax.swing.*;
import java.awt.*;
import java.beans.*;

public class PropertySplit {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Property Split");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create/configure split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setContinuousLayout(true);
        splitPane.setOneTouchExpandable(true);

        // Create top component
        JComponent topComponent = new OvalPanel();
        splitPane.setTopComponent(topComponent);

        // Create bottom component
        JComponent bottomComponent = new OvalPanel();
        splitPane.setBottomComponent(bottomComponent);

        // Create PropertyChangeListener
        PropertyChangeListener propertyChangeListener =
            new PropertyChangeListener() {
          public void propertyChange (PropertyChangeEvent changeEvent) {
            JSplitPane sourceSplitPane = (JSplitPane)changeEvent.getSource();
            String propertyName = changeEvent.getPropertyName();
            if (propertyName.equals(
                JSplitPane.LAST_DIVIDER_LOCATION_PROPERTY)) {
              int current = sourceSplitPane.getDividerLocation();
              System.out.println ("Current: " + current);
              Integer last = (Integer)changeEvent.getNewValue();
              System.out.println ("Last: " + last);
              Integer priorLast = (Integer)changeEvent.getOldValue();
              System.out.println ("Prior last: " + priorLast);
            }
          }
        };

        // Attach listener
        splitPane.addPropertyChangeListener(propertyChangeListener);

        frame.add(splitPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
