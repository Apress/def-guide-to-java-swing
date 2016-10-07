import javax.swing.*;
import java.beans.*;

public class AbstractButtonPropertyChangeListener
    implements PropertyChangeListener { 

  public void propertyChange(PropertyChangeEvent e) { 
    String propertyName = e.getPropertyName();
    if (e.getPropertyName().equals(AbstractButton.TEXT_CHANGED_PROPERTY)) { 
      String newText = (String) e.getNewValue();
      String oldText = (String) e.getOldValue();
      System.out.println(oldText + " changed to " + newText);
    }  else if (e.getPropertyName().equals(
			    AbstractButton.ICON_CHANGED_PROPERTY)) { 
      Icon icon = (Icon) e.getNewValue();
      if (icon instanceof ImageIcon) { 
        System.out.println("New icon is an image");
      } 
    } 
  } 
} 
