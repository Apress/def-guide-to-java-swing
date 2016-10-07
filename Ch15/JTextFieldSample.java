import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JTextFieldSample {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "TextField Listener Example" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        JTextField nameTextField = new JTextField();
        nameLabel.setLabelFor(nameTextField);
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameTextField, BorderLayout.CENTER);
        frame.add(namePanel, BorderLayout.NORTH);

        JPanel cityPanel = new JPanel(new BorderLayout());
        JLabel cityLabel = new JLabel("City: ");
        cityLabel.setDisplayedMnemonic(KeyEvent.VK_C);
        JTextField cityTextField = new JTextField();
        cityLabel.setLabelFor(cityTextField);
        cityPanel.add(cityLabel, BorderLayout.WEST);
        cityPanel.add(cityTextField, BorderLayout.CENTER);
        frame.add(cityPanel, BorderLayout.SOUTH);

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Command: " + actionEvent.getActionCommand());
          }
        };
        nameTextField.setActionCommand("Yo");
        nameTextField.addActionListener(actionListener);
        cityTextField.addActionListener(actionListener);

        KeyListener keyListener = new KeyListener() {
          public void keyPressed(KeyEvent keyEvent) {
            printIt("Pressed", keyEvent);
          }
          public void keyReleased(KeyEvent keyEvent) {
            printIt("Released", keyEvent);
          }
          public void keyTyped(KeyEvent keyEvent) {
            printIt("Typed", keyEvent);
          }
          private void printIt(String title, KeyEvent keyEvent) {
            int keyCode = keyEvent.getKeyCode();
            String keyText = KeyEvent.getKeyText(keyCode);
            System.out.println(title + " : " + keyText + " / " +
              keyEvent.getKeyChar());
          }
        };
        nameTextField.addKeyListener(keyListener);
        cityTextField.addKeyListener(keyListener);

        InputVerifier verifier = new InputVerifier() {
          public boolean verify(JComponent input) {
            final JTextComponent source = (JTextComponent)input;
            String text = source.getText();
            if ((text.length() != 0) && !(text.equals("Exit"))) {
              JOptionPane.showMessageDialog(source, "Can't leave.",
                "Error Dialog", JOptionPane.ERROR_MESSAGE);
              return false;
            } else {
              return true;
            }
          }
        };
        nameTextField.setInputVerifier(verifier);
        cityTextField.setInputVerifier(verifier);

        DocumentListener documentListener = new DocumentListener() {
          public void changedUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
          }
          public void insertUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
          }
          public void removeUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
          }
          private void printIt(DocumentEvent documentEvent) {
            DocumentEvent.EventType type = documentEvent.getType();
            String typeString = null;
            if (type.equals(DocumentEvent.EventType.CHANGE)) {
              typeString = "Change";
            } else if (type.equals(DocumentEvent.EventType.INSERT)) {
              typeString = "Insert";
            } else if (type.equals(DocumentEvent.EventType.REMOVE)) {
              typeString = "Remove";
            }
            System.out.print("Type  :   " + typeString + " / ");
            Document source = documentEvent.getDocument();
            int length = source.getLength();
            try {
              System.out.println("Contents: " + source.getText(0, length));
            } catch (BadLocationException badLocationException) {
              System.out.println("Contents: Unknown");
            }
          }
        };
        nameTextField.getDocument().addDocumentListener(documentListener);
        cityTextField.getDocument().addDocumentListener(documentListener);

        frame.setSize(250, 100);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
