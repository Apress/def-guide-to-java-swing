import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SelectingToggle {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "Selecting Toggle" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JToggleButton toggleButton = new JToggleButton("Toggle Button");
        JToggleButton toggleButton = new JToggleButton("Selected");
        // Define ActionListener
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton = (AbstractButton)actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            System.out.println("Action - selected=" + selected + "\n");
          }
        };
        // Define ChangeListener
        ChangeListener changeListener = new ChangeListener() {
          public void stateChanged(ChangeEvent changeEvent) {
            AbstractButton abstractButton = (AbstractButton)changeEvent.getSource();
            ButtonModel buttonModel = abstractButton.getModel();
            boolean armed = buttonModel.isArmed();
            boolean pressed = buttonModel.isPressed();
            boolean selected = buttonModel.isSelected();
            System.out.println("Changed: " + armed + "/" + pressed + "/" + selected);
          }
        };
        // Define ItemListener
        ItemListener itemListener = new ItemListener() {
          public void itemStateChanged(ItemEvent itemEvent) {
            int state = itemEvent.getStateChange();
            if (state == ItemEvent.SELECTED) {
              System.out.println("Selected");
            } else {
              System.out.println("Deselected");
            }
          }
        };
        // Attach Listeners
        toggleButton.addActionListener(actionListener);
        toggleButton.addChangeListener(changeListener);
        toggleButton.addItemListener(itemListener);
        frame.add(toggleButton, BorderLayout.NORTH);

        JToggleButton toggleButton2 = new JToggleButton("Focused");
        frame.add(toggleButton2, BorderLayout.CENTER);

        JToggleButton toggleButton3 = new JToggleButton("Not Selected");
        frame.add(toggleButton3, BorderLayout.SOUTH);

        frame.setSize(300, 125);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
