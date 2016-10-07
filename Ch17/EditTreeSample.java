import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class EditTreeSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Editable Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTree tree = new JTree();
        tree.setEditable(true);

/*
Object array[] = {Boolean.TRUE, Boolean.FALSE, "Hello"};
JTree tree = new JTree(array);
tree.setEditable(true);
tree.setRootVisible(true);
JCheckBox checkBox = new JCheckBox();
TreeCellEditor editor = new DefaultCellEditor(checkBox);
tree.setCellEditor(editor);
*/
/*
String elements[] = {"Root", "chartreuse", "rugby", "sushi"};
JComboBox comboBox = new JComboBox(elements);
comboBox.setEditable(true);
TreeCellEditor editor = new DefaultCellEditor(comboBox);
tree.setCellEditor(editor);
*/

DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)tree.getCellRenderer();
String elements[] = {"Root", "chartreuse", "rugby", "sushi"};
JComboBox comboBox = new JComboBox(elements);
comboBox.setEditable(true);
TreeCellEditor comboEditor = new DefaultCellEditor(comboBox);
TreeCellEditor editor = new DefaultTreeCellEditor(tree, renderer, comboEditor);
tree.setCellEditor(editor);

        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

