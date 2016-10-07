import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyTextComponent extends JComponent {
  private ActionListener actionListenerList = null;

  public KeyTextComponent() {
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
          actionListenerList.actionPerformed(actionEvent);
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
    actionListenerList = AWTEventMulticaster.add(
      actionListenerList, actionListener);
  }
  public void removeActionListener(ActionListener actionListener) {
    actionListenerList = AWTEventMulticaster.remove(
      actionListenerList, actionListener);
  }

  public boolean isFocusable() {
    return true;
  }
}
