import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class TabSample {
  static Color colors[] = {Color.RED, Color.ORANGE, Color.YELLOW,
    Color.GREEN, Color.BLUE, Color.MAGENTA};
  static void add(JTabbedPane tabbedPane, String label, int mnemonic) {
    int count = tabbedPane.getTabCount();
    JButton button = new JButton(label);
    button.setBackground(colors[count]);
    tabbedPane.addTab(label, new DiamondIcon(colors[count]), button, label);
    tabbedPane.setMnemonicAt(count, mnemonic);
  }

  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "Tabbed Pane Sample" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        String titles[] = {"General", "Security", "Content", "Connection", "Programs", "Advanced"};
        int mnemonic[] = {KeyEvent.VK_G, KeyEvent.VK_S, KeyEvent.VK_C, KeyEvent.VK_O, KeyEvent.VK_P, KeyEvent.VK_A};
        for (int i=0, n=titles.length; i<n; i++) {
          add(tabbedPane, titles[i], mnemonic[i]);
        }

        ChangeListener changeListener = new ChangeListener() {
          public void stateChanged(ChangeEvent changeEvent) {
            JTabbedPane sourceTabbedPane = (JTabbedPane)changeEvent.getSource();
            int index = sourceTabbedPane.getSelectedIndex();
            System.out.println ("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
          }
        };
        tabbedPane.addChangeListener(changeListener);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
