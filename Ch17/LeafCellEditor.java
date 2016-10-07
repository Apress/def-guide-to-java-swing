import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.EventObject;

public class LeafCellEditor extends DefaultTreeCellEditor {

  public LeafCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
    super(tree, renderer);
  }

  public LeafCellEditor(JTree tree, DefaultTreeCellRenderer renderer, TreeCellEditor editor) {
    super(tree, renderer, editor);
  }

  public boolean isCellEditable(EventObject event) {
    // Get initial setting
    boolean returnValue = super.isCellEditable(event);
    // If still possible, check if current tree node is a leaf
    if (returnValue) {
      Object node = tree.getLastSelectedPathComponent();
      if ((node != null) &&  (node instanceof TreeNode)) {
        TreeNode treeNode = (TreeNode)node;
        returnValue = treeNode.isLeaf();
      }
    }
    return returnValue;
  }
}
