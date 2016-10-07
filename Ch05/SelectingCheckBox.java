import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SelectingCheckBox {
  private static String DESELECTED_LABEL = "Deselected";
  private static String SELECTED_LABEL = "Selected";
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Selecting CheckBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JCheckBox checkBox = new JCheckBox(DESELECTED_LABEL);
        // Define ActionListener
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton =
              (AbstractButton)actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            String newLabel = (selected ? SELECTED_LABEL : DESELECTED_LABEL);
            abstractButton.setText(newLabel);
          }
        };
        // Define ChangeListener
        ChangeListener changeListener = new ChangeListener() {
          public void stateChanged(ChangeEvent changeEvent) {
            AbstractButton abstractButton =
              (AbstractButton)changeEvent.getSource();
            ButtonModel buttonModel = abstractButton.getModel();
            boolean armed = buttonModel.isArmed();
            boolean pressed = buttonModel.isPressed();
            boolean selected = buttonModel.isSelected();
            System.out.println("Changed: " + armed + "/" + pressed + "/" +
              selected);
          }
        };
        // Define ItemListener
        ItemListener itemListener = new ItemListener() {
          public void itemStateChanged(ItemEvent itemEvent) {
            AbstractButton abstractButton =
              (AbstractButton)itemEvent.getSource();
            Color foreground = abstractButton.getForeground();
            Color background = abstractButton.getBackground();
            int state = itemEvent.getStateChange();
            if (state == ItemEvent.SELECTED) {
              abstractButton.setForeground(background);
              abstractButton.setBackground(foreground);
            }
          }
        };
        // Attach Listeners
        checkBox.addActionListener(actionListener);
        checkBox.addChangeListener(changeListener);
        checkBox.addItemListener(itemListener);
        checkBox.setMnemonic(KeyEvent.VK_S);
        frame.add(checkBox, BorderLayout.NORTH);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
