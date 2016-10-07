import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class TreeArraySample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("JTreeSample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Vector<String> oneVector = new NamedVector<String>("One", args);
        Vector<String> twoVector = new NamedVector<String>("Two",
          new String[]{"Mercury", "Venus", "Mars"});
        Vector<Object> threeVector = new NamedVector<Object>("Three");
        threeVector.add(System.getProperties());
        threeVector.add(twoVector);
        Object rootNodes[] = {oneVector, twoVector, threeVector};
        Vector<Object> rootVector = new NamedVector<Object>("Root", rootNodes);
        JTree tree = new JTree(rootVector);

        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
