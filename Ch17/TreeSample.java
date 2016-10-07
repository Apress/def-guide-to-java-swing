import javax.swing.*;
import java.awt.*;

public class TreeSample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "JTree Sample" : args[0]);
        JFrame frame = new JFrame(title);
// UIManager.put("Tree.openIcon", new DiamondIcon(Color.RED, false));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// UIManager.put("Tree.line", Color.RED);
        JTree tree = new JTree();
tree.putClientProperty("JTree.lineStyle", "None");
// tree.setSelectionModel(null);
        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

