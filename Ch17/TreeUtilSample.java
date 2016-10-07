import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class TreeUtilSample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("DynamicUtilTreeNode Hashtable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>();
        hashtable.put("One", args);
        hashtable.put("Two", new String[]{"Mercury", "Venus", "Mars"});
        Hashtable<Object, Object> innerHashtable = new Hashtable<Object, Object>();
        Properties props = System.getProperties();
        innerHashtable.put(props, props);
        innerHashtable.put("Two", new String[]{"Mercury", "Venus", "Mars"});
        hashtable.put("Three", innerHashtable);

        JTree.DynamicUtilTreeNode.createChildren(root, hashtable);

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

