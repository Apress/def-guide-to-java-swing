import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class NodeTreeSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Manual Nodes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode mercury = new DefaultMutableTreeNode("Mercury");
        root.add(mercury);
        DefaultMutableTreeNode venus = new DefaultMutableTreeNode("Venus");
        root.add(venus);
        DefaultMutableTreeNode mars = new DefaultMutableTreeNode("Mars");
        root.add(mars);
        JTree tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
