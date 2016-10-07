import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class LookHier {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Look & Feel Hierarchy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Vector windowsVector = new NamedVector("WindowsLookAndFeel", 
          new Object[] {"WindowsClassicLookAndFeel"});

        Vector basicVector = new NamedVector("BasicLookAndFeel", 
          new Object[] {"MetalLookAndFeel", "MotifLookAndFeel",
            "SynthLookAndFeel", windowsVector});

        Object lookNodes[] = {basicVector, "MultiLookAndFeel"};

        Vector lookVector = new NamedVector("LookAndFeel", lookNodes);

        Object rootNodes[] = {lookVector};
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

