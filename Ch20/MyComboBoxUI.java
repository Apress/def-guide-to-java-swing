import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

public class MyComboBoxUI extends BasicComboBoxUI {
  public static ComponentUI createUI(JComponent c) {
    return new MyComboBoxUI();
  }
  protected JButton createArrowButton() {
    JButton button = new BasicArrowButton(BasicArrowButton.EAST);
    return button;
  }
}
