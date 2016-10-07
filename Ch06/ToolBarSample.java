import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolBarSample {

  private static final int COLOR_POSITION = 0;
  private static final int STRING_POSITION = 1;
  static Object buttonColors[][] = {
    {Color.RED, "RED"}, 
    {Color.BLUE, "BLUE"},
    {Color.GREEN, "GREEN"},
    {Color.BLACK, "BLACK"},
    null, // separator
    {Color.CYAN, "CYAN"}
  };

  public static class TheActionListener implements ActionListener {
      public void actionPerformed (ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
      }
  };

  public static void main(final String args[]) {

    Runnable runner = new Runnable() {
      public void run() {

        String title = (args.length==0 ? "JToolBar Example" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ActionListener actionListener = new TheActionListener();

        JToolBar toolbar = new JToolBar();
	toolbar.setRollover(true);

        for (Object[] color: buttonColors) {
          if (color == null) {
            toolbar.addSeparator();
          } else {
            Icon icon = new DiamondIcon((Color)color[COLOR_POSITION], true, 20, 20);
            JButton button = new JButton(icon);
            button.setActionCommand((String)color[STRING_POSITION]);
            button.addActionListener(actionListener);
            toolbar.add(button);
          }
        }

        Action action = new ShowAction(frame);
	JButton button = new JButton(action);
//        toolbar.add(button);

        Container contentPane = frame.getContentPane();
        contentPane.add(toolbar, BorderLayout.NORTH);
        JTextArea textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        contentPane.add(pane, BorderLayout.CENTER);
        frame.setSize(350, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

