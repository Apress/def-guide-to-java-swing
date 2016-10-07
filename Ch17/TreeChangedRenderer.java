import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class TreeChangedRenderer {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Changed Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTree tree = new JTree();
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)tree.getCellRenderer();

         renderer.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 32));
         int rowHeight = tree.getRowHeight();
         if (rowHeight <= 0) {
           tree.setRowHeight(rowHeight - 1);
         }

        // Swap background colors
        Color backgroundSelection = renderer.getBackgroundSelectionColor();
        renderer.setBackgroundSelectionColor(renderer.getBackgroundNonSelectionColor());
        renderer.setBackgroundNonSelectionColor(backgroundSelection);

        // Swap text colors
        Color textSelection = renderer.getTextSelectionColor();
        renderer.setTextSelectionColor(renderer.getTextNonSelectionColor());
        renderer.setTextNonSelectionColor(textSelection);

        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
