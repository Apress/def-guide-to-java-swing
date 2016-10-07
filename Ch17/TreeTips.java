import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class TreeTips {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Tree Tips");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Properties props = System.getProperties();
        JTree tree = new JTree(props);
        ToolTipManager.sharedInstance().registerComponent(tree);
        TreeCellRenderer renderer = new ToolTipTreeCellRenderer(props);
        tree.setCellRenderer(renderer);
        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

