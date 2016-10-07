import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class TreeLines {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Tree Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box box = Box.createHorizontalBox();

        JTree tree1 = new JTree();
        JScrollPane scrollPane1 = new JScrollPane(tree1);
        tree1.setAutoscrolls(true);

        JTree tree2 = new JTree();
        tree2.putClientProperty("JTree.lineStyle", "None");
        JScrollPane scrollPane2 = new JScrollPane(tree2);

        box.add(scrollPane1, BorderLayout.WEST);
        box.add(scrollPane2, BorderLayout.EAST);

        frame.add(box, BorderLayout.CENTER);
        frame.setSize(300, 240);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
