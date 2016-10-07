import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class SwingTree {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Swing Package Hierarchy");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Vector htmlVector = new NamedVector("html", new String[]{"parser"});
	Vector textVector = new NamedVector("text", new Object[]{htmlVector, "rtf"});
        Vector rootVector = new NamedVector("javax.swing", new Object[]{
          "border", 
          "colorchooser", 
          "event", 
          "filechooser", 
          "plaf", 
          "table", 
          textVector,
          "tree",
          "undo"});
        JTree tree = new JTree(rootVector);
        tree.setRootVisible(true);
        TreeModel model = tree.getModel();
        model.valueForPathChanged(new TreePath(model.getRoot()), "javax.swing");
        ((DefaultTreeModel)model).reload();

        JScrollPane scrollPane = new JScrollPane(tree);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
