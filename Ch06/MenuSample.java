import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import javax.swing.plaf.basic.DefaultMenuLayout;

public class MenuSample {
  static class MenuActionListener implements ActionListener {
    public void actionPerformed (ActionEvent actionEvent) {
      System.out.println ("Selected: " + actionEvent.getActionCommand());
    }
  }
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        ActionListener menuListener = new MenuActionListener();
        String title = (args.length==0 ? "MenuSample Example" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JMenuBar menuBar = new JMenuBar();
        JMenuBar menuBar = new VerticalMenuBar();

        // File Menu, F - Mnemonic
        JMenu fileMenu = new JMenu("File");
        fileMenu.setLayout(new GridLayout(3,3));
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        // File->New, N - Mnemonic
        JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
        newMenuItem.addActionListener(menuListener);
        fileMenu.add(newMenuItem);

        // File->Open, O - Mnemonic
        JMenuItem openMenuItem = new JMenuItem("Open", KeyEvent.VK_O);
        openMenuItem.addActionListener(menuListener);
        fileMenu.add(openMenuItem);

        // File->Close, C - Mnemonic
        JMenuItem closeMenuItem = new JMenuItem("Close", KeyEvent.VK_C);
        closeMenuItem.addActionListener(menuListener);
        fileMenu.add(closeMenuItem);

        // Separator
        fileMenu.addSeparator();

        // File->Save, S - Mnemonic
        JMenuItem saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        saveMenuItem.addActionListener(menuListener);
        fileMenu.add(saveMenuItem);

        // Separator
        fileMenu.addSeparator();

        // File->Exit, X - Mnemonic
        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitMenuItem.addActionListener(menuListener);
        fileMenu.add(exitMenuItem);

        // Edit Menu, E - Mnemonic
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(editMenu);

        // Edit->Cut, T - Mnemonic, CTRL-X - Accelerator
        JMenuItem cutMenuItem = new JMenuItem("Cut", KeyEvent.VK_T);
        cutMenuItem.addActionListener(menuListener);
        KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke("control X");
        cutMenuItem.setAccelerator(ctrlXKeyStroke);
        editMenu.add(cutMenuItem);

        // Edit->Copy, C - Mnemonic, CTRL-C - Accelerator
        JMenuItem copyMenuItem = new JMenuItem("Copy", KeyEvent.VK_C);
        copyMenuItem.addActionListener(menuListener);
        KeyStroke ctrlCKeyStroke = KeyStroke.getKeyStroke("control C");
        copyMenuItem.setAccelerator(ctrlCKeyStroke);
        editMenu.add(copyMenuItem);

        // Edit->Paste, P - Mnemonic, CTRL-V - Accelerator, Disabled
        JMenuItem pasteMenuItem = new JMenuItem("Paste", KeyEvent.VK_P);
        pasteMenuItem.addActionListener(menuListener);
        KeyStroke ctrlVKeyStroke = KeyStroke.getKeyStroke("control V");
        pasteMenuItem.setAccelerator(ctrlVKeyStroke);
        pasteMenuItem.setEnabled(false);
        editMenu.add(pasteMenuItem);

        // Separator
        editMenu.addSeparator();

        // Edit->Find, F - Mnemonic, F3 - Accelerator
        JMenuItem findMenuItem = new JMenuItem("Find", KeyEvent.VK_F);
        findMenuItem.addActionListener(menuListener);
        KeyStroke f3KeyStroke = KeyStroke.getKeyStroke("F3");
        findMenuItem.setAccelerator(f3KeyStroke);
        editMenu.add(findMenuItem);

        // Edit->Options Submenu, O - Mnemonic, at.gif - Icon Image File
        JMenu findOptionsMenu = new JMenu("Options");
        Icon atIcon = new ImageIcon ("at.gif");
        findOptionsMenu.setIcon(atIcon);
        findOptionsMenu.setMnemonic(KeyEvent.VK_O);

        // ButtonGroup for radio buttons
        ButtonGroup directionGroup = new ButtonGroup();

        // Edit->Options->Forward, F - Mnemonic, in group
        JRadioButtonMenuItem forwardMenuItem = new JRadioButtonMenuItem("Forward", true);
        forwardMenuItem.addActionListener(menuListener);
        forwardMenuItem.setMnemonic(KeyEvent.VK_F);
        findOptionsMenu.add(forwardMenuItem);
        directionGroup.add(forwardMenuItem);

        // Edit->Options->Backward, B - Mnemonic, in group
        JRadioButtonMenuItem backwardMenuItem = new JRadioButtonMenuItem("Backward");
        backwardMenuItem.addActionListener(menuListener);
        backwardMenuItem.setMnemonic(KeyEvent.VK_B);
        findOptionsMenu.add(backwardMenuItem);
        directionGroup.add(backwardMenuItem);

        // Separator
        findOptionsMenu.addSeparator();

        // Edit->Options->Case Sensitive, C - Mnemonic
        JCheckBoxMenuItem caseMenuItem = new JCheckBoxMenuItem("Case Sensitive");
        caseMenuItem.addActionListener(menuListener);
        caseMenuItem.setMnemonic(KeyEvent.VK_C);
        findOptionsMenu.add(caseMenuItem);
        editMenu.add(findOptionsMenu);

// JToggleButtonMenuItem toggleItem = new JToggleButtonMenuItem("Balloon Help");
// editMenu.add(toggleItem);

        // frame.setJMenuBar(menuBar);
        frame.add(menuBar, BorderLayout.EAST);
        frame.setSize(350, 250);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

