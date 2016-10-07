import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EscapeDialog extends JDialog { 
  public EscapeDialog() { 
    this((Frame)null, false);
  } 
  public EscapeDialog(Frame owner) { 
    this(owner, false);
  } 
  public EscapeDialog(Frame owner, boolean modal) { 
    this(owner, null, modal);
  } 
  public EscapeDialog(Frame owner, String title) { 
    this(owner, title, false);     
  } 
  public EscapeDialog(Frame owner, String title, boolean modal) { 
    super(owner, title, modal);
  } 
  public EscapeDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
    super(owner, title, modal, gc);
  }
  public EscapeDialog(Dialog owner) { 
    this(owner, false);
  } 
  public EscapeDialog(Dialog owner, boolean modal) { 
    this(owner, null, modal);
  } 
  public EscapeDialog(Dialog owner, String title) { 
    this(owner, title, false);     
  } 
  public EscapeDialog(Dialog owner, String title, boolean modal) { 
    super(owner, title, modal);
  } 
  public EscapeDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
    super(owner, title, modal, gc);
  }
  protected JRootPane createRootPane() { 
    JRootPane rootPane = new JRootPane();
    KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
    Action actionListener = new AbstractAction() { 
      public void actionPerformed(ActionEvent actionEvent) { 
        setVisible(false);
      } 
    } ;
    InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    inputMap.put(stroke, "ESCAPE");
    rootPane.getActionMap().put("ESCAPE", actionListener);

    return rootPane;
  } 
} 

