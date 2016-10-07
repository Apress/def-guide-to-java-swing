import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Examples {
  public static void main(String args[]) {

    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Example Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));

        JFrame frame2 = new JFrame("Desktop");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JDesktopPane desktop = new JDesktopPane();
        frame2.add(desktop);
        JButton pick = new JButton("Pick");
        pick.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            System.out.println ("Hi");
          }
        });
        frame2.add(pick, BorderLayout.SOUTH);

        JButton messagePopup = new JButton ("Message");
        frame.add(messagePopup);
        messagePopup.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();
            JOptionPane.showMessageDialog(source, "Printing complete");
            JOptionPane.showInternalMessageDialog(desktop, "Printing complete");
          }
        });

        JButton confirmPopup = new JButton ("Confirm");
        frame.add(confirmPopup);
        confirmPopup.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();
            JOptionPane.showConfirmDialog(source, "Continue printing?");
            JOptionPane.showInternalConfirmDialog(desktop, "Continue printing?");
          }
        });

        JButton inputPopup = new JButton ("Input");
        frame.add(inputPopup);
        inputPopup.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();
            JOptionPane.showInputDialog(source, "Enter printer name:");
            // Moons of Neptune
            String smallList[] = {"Naiad", "Thalassa", "Despina", "Galatea", "Larissa", "Proteus", "Triton", "Nereid"};
            JOptionPane.showInternalInputDialog(desktop, "Pick a printer", "Input", JOptionPane.QUESTION_MESSAGE, null, smallList, "Triton");
            // Some of the Moons of Saturn
            String bigList[] = {"Pan", "Atlas", "Prometheus", "Pandora", "Epimetheus", "Janus", "Mimas", "Enceladus", "Telesto", "Tethys", "Calypso", "Dione", "Helene", "Rhea", "Titan", "Hyperion", "Iapetus", "Phoebe", "Skadi", "Mundilfari"};
    //        Object saturnMoon = JOptionPane.showInputDialog(source, "Pick a printer", "Input", JOptionPane.QUESTION_MESSAGE, null, bigList, "Titan");
            Object saturnMoon = JOptionPane.showInputDialog(source, "Pick a printer", "Input", JOptionPane.QUESTION_MESSAGE, null, bigList, null);
            System.out.println ("Saturn Moon: " + saturnMoon);
          }
        });

        JButton optionPopup = new JButton ("Option");
        frame.add(optionPopup);
        optionPopup.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();

            Icon greenIcon = new DiamondIcon(Color.GREEN);
            Icon redIcon = new DiamondIcon(Color.RED);
            Object iconArray[] = {greenIcon, redIcon};
            JOptionPane.showOptionDialog(source, "Continue printing?", "Select an Option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, iconArray, iconArray[1]);

            Icon blueIcon = new DiamondIcon(Color.BLUE);
            Object stringArray[] = {"Do It", "No Way"};
            JOptionPane.showInternalOptionDialog(desktop, "Continue printing?", "Select an Option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, blueIcon, stringArray, stringArray[0]);
          }
        });

        frame.setSize(300, 200);
        frame.setVisible(true);
        frame2.setSize(300, 200);
        frame2.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
