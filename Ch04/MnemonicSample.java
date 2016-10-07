import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MnemonicSample {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Mnemonics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setLayout(new GridLayout(1, 0));

	JButton button1 = new JButton("Warning");
	button1.setMnemonic(KeyEvent.VK_W);
	frame.add(button1);

	JButton button2 = new JButton("Warning");
	button2.setMnemonic(KeyEvent.VK_H);
	button2.setToolTipText("Hello");
	frame.add(button2);

	frame.setSize(300, 200);
	frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
