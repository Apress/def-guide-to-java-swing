import java.awt.*;
import javax.swing.*;

public class DesktopSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JDesktopPane Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLayeredPane desktop = new JDesktopPane();
        desktop.setOpaque(false);
        desktop.add (createLayer ("Open 1"), JLayeredPane.POPUP_LAYER); 
        desktop.add (createLayer ("Iconified"), JLayeredPane.DEFAULT_LAYER); 
        desktop.add (createLayer ("Open 2"), JLayeredPane.PALETTE_LAYER); 
        f.add(desktop, BorderLayout.CENTER);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
  public static JInternalFrame createLayer (String label) {
    return new SelfInternalFrame(label);
  }
  static class SelfInternalFrame extends JInternalFrame {
    public SelfInternalFrame(String s) {
      getContentPane().add (new JLabel (s), BorderLayout.CENTER);
      setBounds (50, 50, 100, 100);
      setResizable (true);
      setClosable (true);
      setMaximizable (true);
      setIconifiable (true);
      setTitle (s);
      setVisible (true);
    }
  }
}
