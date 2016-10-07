import javax.swing.*;
import javax.swing.event.*;

public class InternalFrameIconifyListener extends InternalFrameAdapter {
  public void internalFrameIconified(InternalFrameEvent internalFrameEvent) {
    JInternalFrame source = (JInternalFrame)internalFrameEvent.getSource();
    System.out.println ("Iconified: " + source.getTitle());
  }
  public void internalFrameDeiconified(InternalFrameEvent internalFrameEvent) {
    JInternalFrame source = (JInternalFrame)internalFrameEvent.getSource();
    System.out.println ("Deiconified: " + source.getTitle());
  }
}
