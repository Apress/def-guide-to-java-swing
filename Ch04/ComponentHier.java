import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class ComponentHier {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("JComponent Hierarchy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = (Font)UIManager.get("Tree.font");
        font = new Font(font.getFontName(), Font.BOLD, font.getSize()-3);
        UIManager.put("Tree.font", font);

        Vector jEditorPaneVector = new NamedVector("JEditorPane", 
          new Object[] {"JTextPane"});

        Vector jTextFieldVector = new NamedVector("JTextField", 
          new Object[] {"JFormattedTextField", "JPasswordField"});

        Vector jTextComponentVector = new NamedVector("JTextComponent", 
          new Object[] {jEditorPaneVector, "JTextArea", jTextFieldVector});

        Vector jLayeredPaneVector = new NamedVector("JLayeredPane", 
          new Object[] {"JDesktopPane"});

        Vector jToggleButtonVector = new NamedVector("JToggleButton", 
          new Object[] {"JCheckBox", "JRadioButton"});

        Vector jMenuItemVector = new NamedVector("JMenuItem", 
          new Object[] {"JCheckBoxMenuItem", "JMenu", "JRadioButtonMenuItem"});

        Vector abstractButtonVector = new NamedVector("Abstract Button", 
          new Object[] {"JButton", jMenuItemVector, jToggleButtonVector});

        Object jComponentNodes[] = {abstractButtonVector, "Box", "JColorChooser",
            "JComboBox", "JFileChooser", "JInternalFrame", "JLabel", jLayeredPaneVector,
            "JList", "JMenuBar", "JOptionPane", "JPanel", "JPopupMenu", "JProgressBar", 
            "JRootPane", "JScrollBar", "JScrollPane", "JSeparator", "JSlider", "JSpinner",
            "JSplitPane", "JTabbedPane", "JTable", jTextComponentVector, "JToolBar", "JTree",
            "JViewPort"};
        Vector jComponentVector = new NamedVector("JComponent", jComponentNodes);

        Object rootNodes[] = {jComponentVector};
        Vector rootVector = new NamedVector("Root", rootNodes);

        JTree tree = new JTree(rootVector);
        tree.putClientProperty("JTree.lineStyle", "Angled");

        frame.add(tree, BorderLayout.CENTER);
        frame.setSize(250, 480);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
