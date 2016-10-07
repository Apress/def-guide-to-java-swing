import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.*;

public class UndoableDrawingPanel extends JPanel {
  UndoableEditSupport undoableEditSupport = new UndoableEditSupport(this);
  Polygon polygon = new Polygon();

  public UndoableDrawingPanel() {
    MouseListener mouseListener = new MouseAdapter() {
      public void mouseReleased(MouseEvent mouseEvent) {
        undoableEditSupport.postEdit(new UndoableDrawEdit(UndoableDrawingPanel.this));
        polygon.addPoint(mouseEvent.getX(), mouseEvent.getY());
        repaint();
      }
    };
    addMouseListener(mouseListener);
  }

  public void addUndoableEditListener(UndoableEditListener undoableEditListener) {
    undoableEditSupport.addUndoableEditListener(undoableEditListener);
  }

  public void removeUndoableEditListener(UndoableEditListener undoableEditListener) {
    undoableEditSupport.removeUndoableEditListener(undoableEditListener);
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
      returnValue = new Polygon(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }
    return returnValue;
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawPolygon(polygon);
  }
}

