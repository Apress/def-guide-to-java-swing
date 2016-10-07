import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;
public class UndoDrawing {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Drawing Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UndoableDrawingPanel drawingPanel = new UndoableDrawingPanel();

        UndoManager manager = new UndoManager();
        drawingPanel.addUndoableEditListener(manager);

        JToolBar toolbar = new JToolBar();
        JButton undoButton =
          new JButton(UndoManagerHelper.getUndoAction(manager));
        toolbar.add(undoButton);
        JButton redoButton =
          new JButton(UndoManagerHelper.getRedoAction(manager));
        toolbar.add(redoButton);

        Container content = frame.getContentPane();
        content.add(toolbar, BorderLayout.NORTH);
        content.add(drawingPanel, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

