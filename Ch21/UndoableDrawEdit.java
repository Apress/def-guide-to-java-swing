import javax.swing.undo.*;
import java.awt.*;

public class UndoableDrawEdit extends AbstractUndoableEdit {
  UndoableDrawingPanel panel;
  Polygon polygon, savedPolygon;

  public UndoableDrawEdit(UndoableDrawingPanel panel) {
    this.panel = panel;
    polygon = panel.getPolygon();
  }

  public String getPresentationName() {
    return "Polygon of size " + polygon.npoints;
  }

  public void redo() throws CannotRedoException {
    super.redo();
    if (savedPolygon == null) {
      // Should never get here, as super() doesn't permit redoing
      throw new CannotRedoException();
    } else {
      panel.setPolygon(savedPolygon);
      savedPolygon = null;
    }
  }

  public void undo() throws CannotUndoException {
    super.undo();
    savedPolygon = panel.getPolygon();
    panel.setPolygon(polygon);
  }
}

