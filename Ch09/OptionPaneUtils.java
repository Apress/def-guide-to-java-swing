import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public final class OptionPaneUtils { 

  private OptionPaneUtils() { 
  } 

  public static int getSelection(JOptionPane optionPane) { 
    // Default return value, signals nothing selected
    int returnValue = JOptionPane.CLOSED_OPTION;

    // Get selected Value
    Object selectedValue = optionPane.getValue();
    // If none, then nothing selected
    if (selectedValue != null) { 
      Object options[] = optionPane.getOptions();
      if (options == null) { 
        // default buttons, no array specified
        if(selectedValue instanceof Integer) { 
          returnValue = ((Integer)selectedValue).intValue();
        } 
      }  else { 
        // Array of option buttons specified
        for (int i=0, n = options.length; i < n; i++) { 
          if(options[i].equals(selectedValue)) { 
            returnValue = i;
            break; // out of for loop
          } 
        } 
      } 
    } 
    return returnValue;
  } 

  public static JOptionPane getNarrowOptionPane(int maxCharactersPerLineCount) { 
    // Our inner class definition
    class NarrowOptionPane extends JOptionPane { 
      int maxCharactersPerLineCount;
      NarrowOptionPane(int maxCharactersPerLineCount) { 
        this.maxCharactersPerLineCount = maxCharactersPerLineCount;
      } 
      public int getMaxCharactersPerLineCount() { 
        return maxCharactersPerLineCount;
      } 
    } 
    return new NarrowOptionPane(maxCharactersPerLineCount);
  } 
  public static JSlider getSlider(final JOptionPane optionPane) { 
    JSlider slider = new JSlider();
    slider.setMajorTickSpacing (10);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    ChangeListener changeListener = new ChangeListener() { 
      public void stateChanged(ChangeEvent changeEvent) { 
        JSlider theSlider = (JSlider)changeEvent.getSource();
        if (!theSlider.getValueIsAdjusting()) { 
          optionPane.setInputValue(new Integer(theSlider.getValue()));
        } 
      } 
    };
    slider.addChangeListener(changeListener);
    return slider;
  } 
  public static JButton getButton(final JOptionPane optionPane, String text, Icon icon) { 
    final JButton button = new JButton (text, icon);
    ActionListener actionListener = new ActionListener() { 
      public void actionPerformed(ActionEvent actionEvent) { 
        // Return current text label, instead of argument to method
        optionPane.setValue(button.getText());
      } 
    };
    button.addActionListener(actionListener);
    return button;
  } 
} 

