import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.EventListener;

public class KeyTextComponent2 extends JComponent {
  private EventListenerList actionListenerList = new EventListenerList();

  public KeyTextComponent2() {
    setBackground(Color.CYAN);
    KeyListener internalKeyListener = new KeyAdapter() {
      public void keyPressed(KeyEvent keyEvent) {
        if (actionListenerList != null) {
          int keyCode = keyEvent.getKeyCode();
          String keyText = KeyEvent.getKeyText(keyCode);
          ActionEvent actionEvent = new ActionEvent(
            this,
            ActionEvent.ACTION_PERFORMED,
            keyText);
          fireActionPerformed(actionEvent);
        }
      }
    };

    MouseListener internalMouseListener = new MouseAdapter() {
      public void mousePressed(MouseEvent mouseEvent) {
        requestFocusInWindow();
      }
    };

    addKeyListener(internalKeyListener);
    addMouseListener(internalMouseListener);
  }

  public void addActionListener(ActionListener actionListener) {
    actionListenerList.add(ActionListener.class, actionListener);
  }
  public void removeActionListener(ActionListener actionListener) {
    actionListenerList.remove(ActionListener.class, actionListener);
  }

  protected void fireActionPerformed(ActionEvent actionEvent) {
    EventListener listenerList[] = 
      actionListenerList.getListeners(ActionListener.class);
    for (int i=0, n=listenerList.length; i<n; i++) {
      ((ActionListener)listenerList[i]).actionPerformed(actionEvent);
    }
  }

  public boolean isFocusable() {
    return true;
  }
}
