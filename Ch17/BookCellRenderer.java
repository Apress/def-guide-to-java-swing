import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class BookCellRenderer implements TreeCellRenderer {
  JLabel titleLabel;
  JLabel authorsLabel;
  JLabel priceLabel;
  JPanel renderer;
  DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
  Color backgroundSelectionColor;
  Color backgroundNonSelectionColor;
  public BookCellRenderer() {
    renderer = new JPanel(new GridLayout(0, 1));
    titleLabel = new JLabel(" ");
    titleLabel.setForeground(Color.BLUE);
    renderer.add(titleLabel);
    authorsLabel = new JLabel(" ");
    authorsLabel.setForeground(Color.BLUE);
    renderer.add(authorsLabel);
    priceLabel = new JLabel(" ");
    priceLabel.setHorizontalAlignment(JLabel.RIGHT);
    priceLabel.setForeground(Color.RED);
    renderer.add(priceLabel);
    renderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    backgroundSelectionColor = defaultRenderer.getBackgroundSelectionColor();
    backgroundNonSelectionColor = defaultRenderer.getBackgroundNonSelectionColor();
  }
  public Component getTreeCellRendererComponent(JTree tree, Object value,
      boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    Component returnValue = null;
    if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
      Object userObject = ((DefaultMutableTreeNode)value).getUserObject();
      if (userObject instanceof Book) {
        Book book = (Book)userObject;
        titleLabel.setText(book.getTitle());
        authorsLabel.setText(book.getAuthors());
        priceLabel.setText("" + book.getPrice());
        if (selected) {
          renderer.setBackground(backgroundSelectionColor);
        } else {
          renderer.setBackground(backgroundNonSelectionColor);
        }
        renderer.setEnabled(tree.isEnabled());
        returnValue = renderer;
      }
    }
    if (returnValue == null) {
      returnValue = defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
    }
    return returnValue;
  }
}

