import javax.swing.undo.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class AnUndoableComponent {
  UndoableEditSupport undoableEditSupport = new UndoableEditSupport(this);
  ActionListener actionListenerList = null;

  public void addActionListener(ActionListener actionListener) {
    actionListenerList = AWTEventMulticaster.add(actionListener, actionListenerList);
  }

  public void removeActionListener(ActionListener actionListener) {
    actionListenerList = AWTEventMulticaster.remove(actionListener, actionListenerList);
  }

  public void addUndoableEditListener(UndoableEditListener undoableEditListener) {
    undoableEditSupport.addUndoableEditListener(undoableEditListener);
  }

  public void removeUndoableEditListener(UndoableEditListener undoableEditListener) {
    undoableEditSupport.removeUndoableEditListener(undoableEditListener);
  }

  protected void fireActionPerformed(ActionEvent actionEvent) {
    if (actionListenerList != null) {
      actionListenerList.actionPerformed(actionEvent);
    }
    // Need to create your custom type of undoable operation
    undoableEditSupport.postEdit(new AbstractUndoableEdit());
  } 
}

