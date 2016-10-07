import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

public class UndoableDrawingPanel2 extends JPanel implements StateEditable {
  private static String POLYGON_KEY = "Polygon";
  UndoableEditSupport undoableEditSupport = new UndoableEditSupport(this);
  Polygon polygon = new Polygon();

  public UndoableDrawingPanel2() {
    MouseListener mouseListener = new MouseAdapter() {
      public void mouseReleased(MouseEvent mouseEvent) {
        StateEdit stateEdit = new StateEdit(UndoableDrawingPanel2.this);
        polygon.addPoint(mouseEvent.getX(), mouseEvent.getY());
        stateEdit.end();
        undoableEditSupport.postEdit(stateEdit);
        repaint();
      }
    };
    addMouseListener(mouseListener);
  }
  public void addUndoableEditListener(
      UndoableEditListener undoableEditListener) {
    undoableEditSupport.addUndoableEditListener(undoableEditListener);
  }

  public void removeUndoableEditListener(
      UndoableEditListener undoableEditListener) {
    undoableEditSupport.removeUndoableEditListener(undoableEditListener);
  }

  public void storeState(Hashtable state) {
    state.put(POLYGON_KEY, getPolygon());
  }

  public void restoreState(Hashtable state) {
    Polygon polygon = (Polygon)state.get(POLYGON_KEY);
    if (polygon != null) {
      setPolygon(polygon);
    }
  }

  public void setPolygon(Polygon newValue) {
    polygon = newValue;
    repaint();
  }

  public Polygon getPolygon() {
    Polygon returnValue;
    if (polygon.npoints == 0) {
      returnValue = new Polygon();
    } else {
      returnValue = new Polygon(
        polygon.xpoints, polygon.ypoints, polygon.npoints);
    }
    return returnValue;
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawPolygon(polygon);
  }

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Drawing Sample2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UndoableDrawingPanel2 drawingPanel = new UndoableDrawingPanel2();

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
