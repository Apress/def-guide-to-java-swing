import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ShowAction extends AbstractAction {
  Component parentComponent;
  public ShowAction(Component parentComponent) {
    super("About");
    putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_A));
    this.parentComponent = parentComponent;
  }
  public void actionPerformed(ActionEvent actionEvent) {
    Runnable runnable = new Runnable() {
      public void run() {
        JOptionPane.showMessageDialog(
          parentComponent, "About Swing", 
          "About Box V2.0", JOptionPane.INFORMATION_MESSAGE);
      }
    };
    EventQueue.invokeLater(runnable);
  }
}
