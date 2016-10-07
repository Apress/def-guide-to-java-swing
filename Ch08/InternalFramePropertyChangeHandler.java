import java.beans.*;
import javax.swing.*;

public class InternalFramePropertyChangeHandler implements PropertyChangeListener { 
  public void propertyChange(PropertyChangeEvent propertyChangeEvent) { 
    String propertyName = propertyChangeEvent.getPropertyName();
    if (propertyName.equals(JInternalFrame.IS_ICON_PROPERTY)) { 
      System.out.println("Icon property changed. React.");
    } 
  } 
} 
