import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class BorderButtons {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        final JFrame frame = new JFrame("BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(new JButton("North"), BorderLayout.NORTH);
	frame.add(new JButton("South"), BorderLayout.SOUTH);
	frame.add(new JButton("East"), BorderLayout.EAST);
	frame.add(new JButton("West"), BorderLayout.WEST);
	frame.add(new JButton("Center"), BorderLayout.CENTER);
        frame.setSize(200, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
