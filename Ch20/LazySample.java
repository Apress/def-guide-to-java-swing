import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class LazySample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Lazy Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object iconObject =
          LookAndFeel.makeIcon(LazySample.class, "World.gif");
        UIManager.put("Tree.leafIcon", iconObject);

        Integer fifteen = new Integer(15);
        Object lazyArgs[] =
          new Object[] {Color.GREEN, Boolean.TRUE, fifteen, fifteen};
        Object lazyDiamond =
          new UIDefaults.ProxyLazyValue("DiamondIcon", lazyArgs);
        UIManager.put("Tree.openIcon", lazyDiamond);

        JTree tree = new JTree();
        JScrollPane scrollPane = new JScrollPane(tree);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(200, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
