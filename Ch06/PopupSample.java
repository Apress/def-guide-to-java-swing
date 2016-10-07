import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PopupSample {

  // Define ActionListener
  static class PopupActionListener implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
      System.out.println("Selected: " + actionEvent.getActionCommand());
    }
  }

  // Define PopupMenuListener
  static class MyPopupMenuListener implements PopupMenuListener {
    public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
      System.out.println("Canceled");
    }
    public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
      System.out.println("Becoming Invisible");
    }
    public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
      System.out.println("Becoming Visible");
    }
  }

  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "PopupSample Example" : args[0]);
        // Create frame
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener actionListener = new PopupActionListener();
        PopupMenuListener popupMenuListener = new MyPopupMenuListener();

        // Create popup menu, attach popup menu listener
        JPopupMenu popupMenu = new JPopupMenu("Title");
        popupMenu.addPopupMenuListener(popupMenuListener);

         // Cut
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(actionListener);
        popupMenu.add(cutMenuItem);

        // Copy
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(actionListener);
        popupMenu.add(copyMenuItem);

        // Paste
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(actionListener);
        pasteMenuItem.setEnabled(false);
        popupMenu.add(pasteMenuItem);

        // Separator
        popupMenu.addSeparator();

        // Find
        JMenuItem findMenuItem = new JMenuItem("Find");
        findMenuItem.addActionListener(actionListener);
        popupMenu.add(findMenuItem);
	JButton label = new JButton();
	frame.add(label);
	label.setComponentPopupMenu(popupMenu);

        frame.setSize(350, 250);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

