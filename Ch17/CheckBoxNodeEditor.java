import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

public class CheckBoxNodeEditor extends AbstractCellEditor implements 
  TreeCellEditor { 

  CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();

  ChangeEvent changeEvent = null;

  JTree tree;

  public CheckBoxNodeEditor(JTree tree) { 
    this.tree = tree;
  } 

  public Object getCellEditorValue() { 
    JCheckBox checkbox = renderer.getLeafRenderer();
    CheckBoxNode checkBoxNode = 
      new CheckBoxNode(checkbox.getText(), checkbox.isSelected());
    return checkBoxNode;
  } 

  public boolean isCellEditable(EventObject event) { 
    boolean returnValue = false;
    if (event instanceof MouseEvent) { 
      MouseEvent mouseEvent = (MouseEvent)event;
      TreePath path = tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
      if (path != null) { 
        Object node = path.getLastPathComponent();
        if ((node != null) &&  (node instanceof DefaultMutableTreeNode)) { 
          DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)node;
          Object userObject = treeNode.getUserObject();
          returnValue = ((treeNode.isLeaf()) && (userObject instanceof CheckBoxNode));
        } 
      } 
    } 
    return returnValue;
  } 

  public Component getTreeCellEditorComponent(JTree tree, Object value,
      boolean selected, boolean expanded, boolean leaf, int row) { 

    Component editor =
      renderer.getTreeCellRendererComponent(tree, value, true, expanded, leaf, row, true);

    // editor always selected / focused
    ItemListener itemListener = new ItemListener() { 
      public void itemStateChanged(ItemEvent itemEvent) { 
        if (stopCellEditing()) { 
          fireEditingStopped();
        } 
      } 
    } ;
    if (editor instanceof JCheckBox) { 
      ((JCheckBox)editor).addItemListener(itemListener);
    } 

    return editor;
  } 
} 
