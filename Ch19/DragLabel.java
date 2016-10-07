import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragLabel {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Drag Label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, World");
        label.setTransferHandler(new TransferHandler("foreground"));
        MouseListener listener = new MouseAdapter() {
          public void mousePressed(MouseEvent me) {
            JComponent comp = (JComponent)me.getSource();
            TransferHandler handler = comp.getTransferHandler();
            handler.exportAsDrag(comp, me, TransferHandler.COPY);
          }
        };
        label.addMouseListener(listener);
        frame.add(label, BorderLayout.SOUTH);

        JTextField text = new JTextField();
        frame.add(text, BorderLayout.NORTH);

        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
