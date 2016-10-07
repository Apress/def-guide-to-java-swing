import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

public class GroupActionRadio {
  private static final String sliceOptions[] = 
    {"4 slices", "8 slices", "12 slices", "16 slices"};
  private static final String crustOptions[] = 
    {"Sicilian", "Thin Crust", "Thick Crust", "Stuffed Crust"};
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "Grouping Example" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JFrame frame = new JFrame("Grouping Example");

        // Slice Parts
        ActionListener sliceActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton aButton = (AbstractButton)actionEvent.getSource();
            System.out.println("Selected: " + aButton.getText());
          }
        };
        Container sliceContainer = 
          RadioButtonUtils.createRadioButtonGrouping(sliceOptions,
            "Slice Count", sliceActionListener);

        // Crust Parts
        ActionListener crustActionListener = new ActionListener() {
          String lastSelected;
          public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton aButton = (AbstractButton)actionEvent.getSource();
            String label = aButton.getText();
            String msgStart;
            if (label.equals(lastSelected)) {
              msgStart = "Reselected: ";
            } else {
              msgStart = "Selected: ";
            }
            lastSelected = label;
            System.out.println(msgStart + label);
          }
        };
        ItemListener itemListener = new ItemListener() {
          String lastSelected;
          public void itemStateChanged(ItemEvent itemEvent) {
            AbstractButton aButton = (AbstractButton)itemEvent.getSource();
            int state = itemEvent.getStateChange();
            String label = aButton.getText();
            String msgStart;
            if (state == ItemEvent.SELECTED) {
              if (label.equals(lastSelected)) {
                msgStart = "Reselected -> ";
              } else {
                msgStart = "Selected -> ";
              }
              lastSelected = label;
            } else {
              msgStart = "Deselected -> ";
            }
            System.out.println(msgStart + label);
          }
        };
        ChangeListener changeListener = new ChangeListener() {
          public void stateChanged(ChangeEvent changEvent) {
            AbstractButton aButton = (AbstractButton)changEvent.getSource();
            ButtonModel aModel = aButton.getModel();
            boolean armed = aModel.isArmed();
            boolean pressed = aModel.isPressed();
            boolean selected = aModel.isSelected();
            System.out.println("Changed: " + armed + "/" + pressed + "/" +
              selected);
          }
        };
        final Container crustContainer = 
          RadioButtonUtils.createRadioButtonGrouping(crustOptions,
            "Crust Type", crustActionListener, itemListener, changeListener);

        // Button Parts
        ActionListener buttonActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Enumeration<String> selected =
              RadioButtonUtils.getSelectedElements(crustContainer);
            while (selected.hasMoreElements()) {
              System.out.println ("Selected -> " + selected.nextElement());
            }
          }
        };
        JButton button = new JButton ("Order Pizza");
        button.addActionListener(buttonActionListener);
    
        frame.add(sliceContainer, BorderLayout.WEST);
        frame.add(crustContainer, BorderLayout.EAST);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
