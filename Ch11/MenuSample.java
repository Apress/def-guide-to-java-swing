import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Menu Glue Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();

        // File Menu, F - Mnemonic
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        bar.add(fileMenu);

        // Edit Menu, E - Mnemonic
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        bar.add(editMenu);

        // Move help menu to right side
        bar.add(Box.createHorizontalGlue());
    
        // Help Menu, H - Mnemonic
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        bar.add(helpMenu);

        frame.setJMenuBar(bar);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
