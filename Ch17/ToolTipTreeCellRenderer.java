import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class ToolTipTreeCellRenderer implements TreeCellRenderer {
  DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
  Dictionary tipTable;

  public ToolTipTreeCellRenderer (Dictionary tipTable) {
    this.tipTable = tipTable;
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value,
      boolean selected, boolean expanded, boolean leaf, int row,
      boolean hasFocus) {
    renderer.getTreeCellRendererComponent(tree, value, selected, expanded,
      leaf, row, hasFocus);
    if (value != null) {
      Object tipKey;
      if (value instanceof DefaultMutableTreeNode) {
        tipKey = ((DefaultMutableTreeNode)value).getUserObject();
      } else {
        tipKey = tree.convertValueToText(value, selected, expanded, leaf,
          row, hasFocus);
      }
      renderer.setToolTipText((String)tipTable.get(tipKey));
    }
    return renderer;
  }
}
