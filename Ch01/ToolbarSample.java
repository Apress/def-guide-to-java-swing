import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;


public class ToolbarSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JToolBar Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JToolBar toolbar = new JToolBar();
        Icon icon = MetalIconFactory.getFileChooserDetailViewIcon();
        JToggleButton button = new JToggleButton(icon);
        toolbar.add(button);
        icon = MetalIconFactory.getFileChooserHomeFolderIcon();
        button = new JToggleButton(icon);
        toolbar.add(button);
        icon = MetalIconFactory.getFileChooserListViewIcon();
        button = new JToggleButton(icon);
        toolbar.add(button);
        f.add(toolbar, BorderLayout.NORTH);
        f.setSize (300, 100);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
