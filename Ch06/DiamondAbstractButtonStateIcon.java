import java.awt.*;
import javax.swing.*;

public class DiamondAbstractButtonStateIcon implements Icon {
  private final int width = 10;
  private final int height = 10;
  private Color color;
  private Polygon polygon;
  public DiamondAbstractButtonStateIcon(Color color) {
    this.color = color;
    initPolygon();
  }
  private void initPolygon() {
    polygon = new Polygon();
    int halfWidth = width/2;
    int halfHeight = height/2;
    polygon.addPoint (0, halfHeight);
    polygon.addPoint (halfWidth, 0);
    polygon.addPoint (width, halfHeight);
    polygon.addPoint (halfWidth, height);
  }
  public int getIconHeight() {
    return width;
  }
  public int getIconWidth() {
    return height;
  }
  public void paintIcon(Component component, Graphics g, int x, int y) {
    boolean selected = false;
    g.setColor (color);
    g.translate (x, y);
    if (component instanceof AbstractButton) {
      AbstractButton abstractButton = (AbstractButton)component;
      selected = abstractButton.isSelected();
    }
    if (selected) {
      g.fillPolygon (polygon);
    } else {
      g.drawPolygon (polygon);
    }
    g.translate (-x, -y);
  }
}

