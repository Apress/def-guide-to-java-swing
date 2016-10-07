import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragImage {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Drag Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Icon icon = new ImageIcon("dog.jpg");
        JLabel label = new JLabel(icon);
        label.setTransferHandler(new ImageSelection());
        MouseListener listener = new MouseAdapter() {
          public void mousePressed(MouseEvent me) {
            JComponent comp = (JComponent)me.getSource();
            TransferHandler handler = comp.getTransferHandler();
            handler.exportAsDrag(comp, me, TransferHandler.COPY);
          }
        };
        label.addMouseListener(listener);
        frame.add(new JScrollPane(label), BorderLayout.CENTER);

        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
