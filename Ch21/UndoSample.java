import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;

public class UndoSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Undo Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        UndoManager manager = new UndoManager();
        textArea.getDocument().addUndoableEditListener(manager);

        JToolBar toolbar = new JToolBar();
        JButton undoButton = new JButton(UndoManagerHelper.getUndoAction(manager));
        toolbar.add(undoButton);
        JButton redoButton = new JButton(UndoManagerHelper.getRedoAction(manager));
        toolbar.add(redoButton);

        Container content = frame.getContentPane();
        content.add(toolbar, BorderLayout.NORTH);
        content.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
