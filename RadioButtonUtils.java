import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Vector;

public class RadioButtonUtils {
  private RadioButtonUtils() {
    // private constructor so you can't create instances
  }

  public static Enumeration<String> getSelectedElements(Container container) {
    Vector<String> selections = new Vector<String>();
    Component components[] = container.getComponents();
    for (int i=0, n=components.length; i<n; i++) {
      if (components[i] instanceof AbstractButton) {
        AbstractButton button = (AbstractButton)components[i];
        if (button.isSelected()) {
          selections.addElement(button.getText());
        }
      }
    }
    return selections.elements();
  }

  public static Container createRadioButtonGrouping (String elements[]) {
    return createRadioButtonGrouping(elements, null, null, null, null);
  }

  public static Container createRadioButtonGrouping (String elements[],
      String title) {
    return createRadioButtonGrouping(elements, title, null, null, null);
  }

  public static Container createRadioButtonGrouping(String elements[],
      String title, ItemListener itemListener) {
    return createRadioButtonGrouping(elements, title, null, itemListener, null);
  }

  public static Container createRadioButtonGrouping(String elements[],
      String title, ActionListener actionListener) {
    return createRadioButtonGrouping(elements, title, actionListener, null,
      null);
  }

  public static Container createRadioButtonGrouping(String elements[],
      String title, ActionListener actionListener, ItemListener itemListener) {
    return createRadioButtonGrouping(elements, title, actionListener,
      itemListener, null);
    }

  public static Container createRadioButtonGrouping(String elements[],
      String title, ActionListener actionListener, ItemListener itemListener,
      ChangeListener changeListener) {
    JPanel panel = new JPanel(new GridLayout(0, 1));
    // If title set, create titled border
    if (title != null) {
      Border border = BorderFactory.createTitledBorder(title);
      panel.setBorder(border);
    }
    // Create group
    ButtonGroup group = new ButtonGroup();
    JRadioButton aRadioButton;
    // For each String passed in:
    // Create button, add to panel, and add to group
    for (int i=0, n=elements.length; i<n; i++) {
      aRadioButton = new JRadioButton (elements[i]);
      panel.add(aRadioButton);
      group.add(aRadioButton);
      if (actionListener != null) {
        aRadioButton.addActionListener(actionListener);
      }
      if (itemListener != null) {
        aRadioButton.addItemListener(itemListener);
      }
      if (changeListener != null) {
        aRadioButton.addChangeListener(changeListener);
      }
    }
    return panel;
  }
}
