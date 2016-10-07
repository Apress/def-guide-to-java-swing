import java.awt.*;
import java.awt.event.*;
public class ActionFocusMover implements ActionListener {
  public void actionPerformed(ActionEvent actionEvent) {
    KeyboardFocusManager manager = 
      KeyboardFocusManager.getCurrentKeyboardFocusManager();
    manager.focusNextComponent();
  }
}

