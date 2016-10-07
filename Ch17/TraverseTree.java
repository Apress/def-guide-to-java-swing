import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class TraverseTree {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Traverse Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object footballNodes[] = {"Giants", "Jets", "Bills"};
        Vector<Object> footballVector = new NamedVector<Object>("Football", footballNodes);
        Object newYorkNodes[] = {"Mets", "Yankees", "Rangers", footballVector};
        Vector<Object> newYorkVector = new NamedVector<Object>("New York", newYorkNodes);
        Object bostonNodes[] = {"Red Sox", "Celtics", "Bruins"};
        Vector<Object> bostonVector = new NamedVector<Object>("Boston", bostonNodes);
        Object denverNodes[] = {"Rockies", "Avalanche", "Broncos"};
        Vector<Object> denverVector = new NamedVector<Object>("Denver", denverNodes);
        Object rootNodes[] = {newYorkVector, bostonVector, denverVector};
        Vector<Object> rootVector = new NamedVector<Object>("Root", rootNodes);
        JTree tree = new JTree(rootVector);
        tree.setRootVisible(true);
        TreeModel model = tree.getModel();
        Object rootObject = model.getRoot();
        if ((rootObject != null) && (rootObject instanceof DefaultMutableTreeNode)) {
          DefaultMutableTreeNode root = (DefaultMutableTreeNode)rootObject;
//        printDescendents(root);
          Enumeration breadth = root.breadthFirstEnumeration();
          Enumeration depth = root.depthFirstEnumeration();
          Enumeration preOrder = root.preorderEnumeration();
          printEnumeration(breadth, "Breadth");
//        printEnumeration(depth, "Depth");
//        printEnumeration(preOrder, "Pre");
        }

        TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
          public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
            JTree treeSource = (JTree)treeSelectionEvent.getSource();
            TreePath path = treeSource.getSelectionPath();
            System.out.println(path);
            System.out.println(path.getPath());
            System.out.println(path.getParentPath());
            System.out.println(((DefaultMutableTreeNode)path.getLastPathComponent()).getUserObject());
            System.out.println(path.getPathCount());
          }
        };
        tree.addTreeSelectionListener(treeSelectionListener);

        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 400);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
  private static void printEnumeration(Enumeration e, String label) {
    System.out.println("-----" + label + "-----");
    while(e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
  }
  public static void printDescendents(TreeNode root) {
    System.out.println(root);
    Enumeration children = root.children();
    if (children != null) {
      while(children.hasMoreElements()) {
       printDescendents((TreeNode)children.nextElement());
      }
    }
  }
}
