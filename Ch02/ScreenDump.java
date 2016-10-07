import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScreenDump {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Mnemonic/Accelerator Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Action printAction = new PrintHelloAction();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Print");
        KeyStroke ctrlP = KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK);
        menuItem.setAccelerator(ctrlP);
        menuItem.addActionListener(printAction);
        menu.add(menuItem);

        JButton fileButton = new JButton("About");
        fileButton.setMnemonic(KeyEvent.VK_A);
        fileButton.addActionListener(printAction);

        frame.setJMenuBar(menuBar);

        frame.add(fileButton, BorderLayout.SOUTH);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
