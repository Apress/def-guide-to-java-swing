import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.Vector;

public class CheckBoxNodeTreeSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("CheckBox Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CheckBoxNode accessibilityOptions[] = {
          new CheckBoxNode("Move system caret with focus/selection changes", false),
          new CheckBoxNode("Always expand alt text for images", true)
        };
        CheckBoxNode browsingOptions[] = {
          new CheckBoxNode("Notify when downloads complete", true),
          new CheckBoxNode("Disable script debugging", true),
          new CheckBoxNode("Use AutoComplete", true),
          new CheckBoxNode("Browse in a new process", false)
        };
        Vector<CheckBoxNode> accessVector = new NamedVector<CheckBoxNode>("Accessibility",
          accessibilityOptions);
        Vector<CheckBoxNode> browseVector = new NamedVector<CheckBoxNode>("Browsing", browsingOptions);
        Object rootNodes[] = {accessVector, browseVector};
        Vector<Object> rootVector = new NamedVector<Object>("Root", rootNodes);
        JTree tree = new JTree(rootVector);

        CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
        tree.setCellRenderer(renderer);

        tree.setCellEditor(new CheckBoxNodeEditor(tree));
        tree.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
