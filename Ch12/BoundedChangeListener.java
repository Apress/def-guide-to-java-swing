import javax.swing.*;
import javax.swing.event.*;

public class BoundedChangeListener implements ChangeListener { 
  public void stateChanged(ChangeEvent changeEvent) { 
    Object source = changeEvent.getSource();
    if (source instanceof BoundedRangeModel) { 
      BoundedRangeModel aModel = (BoundedRangeModel)source;
      if (!aModel.getValueIsAdjusting()) { 
        System.out.println ("Changed: " + aModel.getValue());
      } 
    }  else if (source instanceof JSlider) { 
      JSlider theJSlider = (JSlider)source;
      if (!theJSlider.getValueIsAdjusting()) { 
        System.out.println ("Slider changed: " + theJSlider.getValue());
      } 
    }  else if (source instanceof JProgressBar) { 
      JProgressBar theJProgressBar = (JProgressBar)source;
      System.out.println ("ProgressBar changed: " + theJProgressBar.getValue());
    }  else { 
      System.out.println ("Something changed: " + source);
    } 
  } 
} 

