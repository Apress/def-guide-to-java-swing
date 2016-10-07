import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Action Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Action printAction = new PrintHelloAction();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        menu.add(new JMenuItem(printAction));

        JToolBar toolbar = new JToolBar();
        toolbar.add(new JButton(printAction));

        JButton enableButton = new JButton("Enable");
        ActionListener enableActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            printAction.setEnabled(true);
          }
        };
        enableButton.addActionListener(enableActionListener);

        JButton disableButton = new JButton("Disable");
        ActionListener disableActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            printAction.setEnabled(false);
          }
        };
        disableButton.addActionListener(disableActionListener);

        JButton relabelButton = new JButton("Relabel");
        ActionListener relabelActionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            printAction.putValue(Action.NAME, "Hello, World");
          }
        };
        relabelButton.addActionListener(relabelActionListener);
    
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(enableButton);
        buttonPanel.add(disableButton);
        buttonPanel.add(relabelButton);

        frame.setJMenuBar(menuBar);

        frame.add(toolbar, BorderLayout.SOUTH);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

