import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MessagePopup {
  public static void main(String args[]) {

    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Message Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton ("Pop it");
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component source = (Component)actionEvent.getSource();


            // String msg = "this is a really long message this is a really long message this is a really long message this is a really long message this is a really long message this is a really long message this is a really long message";
            String msg = "<html>this is a really long message<br>this is a really long message this is a really long message this is a really long message this is a really long message this is a really long message this is a really long message";
	    
            JOptionPane.showMessageDialog(source, msg);
            JOptionPane optionPane = OptionPaneUtils.getNarrowOptionPane(72);
            optionPane.setMessage(msg);
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog(source, "Width 72");
            dialog.setVisible(true);
            int selection = OptionPaneUtils.getSelection(optionPane);
            JOptionPane.showMessageDialog(source, msg);
            String multiLineMsg[] = {"Hello,", "World"};
            JOptionPane.showMessageDialog(source, multiLineMsg);
	    

            /*Object complexMsg[] = {"Above Message", new DiamondIcon(Color.RED), new JButton ("Hello,"), new JSlider(), new DiamondIcon(Color.BLUE), "Below Message"};
            JOptionPane.showInputDialog(source, complexMsg);
	    */
	    /*
            JOptionPane optionPane = new JOptionPane();
            JSlider slider = OptionPaneUtils.getSlider(optionPane);
            optionPane.setMessage(new Object[] {"Select a value: " , slider});
            optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
            optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
            JDialog dialog = optionPane.createDialog(source, "My Slider");
            dialog.setVisible(true);
            System.out.println ("Input: " + optionPane.getInputValue());
	    */
	    
	    /*
            JOptionPane optionPane = new JOptionPane();
            optionPane.setMessage("I got an icon and a text label");
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
            Icon icon = new DiamondIcon (Color.BLUE);
            JButton jButton = OptionPaneUtils.getButton(optionPane, "OK", icon);
            optionPane.setOptions(new Object[] {jButton});
            JDialog dialog = optionPane.createDialog(source, "Icon/Text Button");
            dialog.setVisible(true);
	    */
	    
          }
        };
        button.addActionListener(actionListener);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
