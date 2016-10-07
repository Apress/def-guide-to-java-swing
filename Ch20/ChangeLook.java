import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class ChangeLook {

  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {

        final JFrame frame = new JFrame("Change Look");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();
            String lafClassName = null;
            if (source instanceof JComboBox) {
              JComboBox comboBox = (JComboBox)source;
              lafClassName = (String)comboBox.getSelectedItem();
            } else if (source instanceof JButton) {
              lafClassName = actionEvent.getActionCommand();
            }
            if (lafClassName != null) {
              final String finalLafClassName = lafClassName;
              Runnable runnable = new Runnable() {
                public void run() {
                  try {
                    UIManager.setLookAndFeel(finalLafClassName);
                    SwingUtilities.updateComponentTreeUI(frame);
                  } catch (Exception exception) {
                    JOptionPane.showMessageDialog (
                      frame, "Can't change look and feel",
                      "Invalid PLAF", JOptionPane.ERROR_MESSAGE);
                  }
                }
              };
              EventQueue.invokeLater(runnable);
            }
          }
        };

        //Object newSettings[] = {"Button.background", Color.PINK,
                                //"Button.foreground", Color.MAGENTA};
        //UIDefaults defaults = UIManager.getDefaults();
        //defaults.putDefaults(newSettings);

        UIManager.LookAndFeelInfo looks[] =
          UIManager.getInstalledLookAndFeels();

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox comboBox = new JComboBox(model);

        JPanel panel = new JPanel();

        for (int i=0, n=looks.length; i<n; i++) {
          JButton button = new JButton(looks[i].getName());
          model.addElement(looks[i].getClassName());
          button.setActionCommand(looks[i].getClassName());
          button.addActionListener(actionListener);
          panel.add(button);
        }

        comboBox.addActionListener(actionListener);

        frame.add(comboBox, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setSize(350, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
