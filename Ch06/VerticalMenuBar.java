import java.awt.*;
import javax.swing.*;
public class VerticalMenuBar extends JMenuBar {
  private static final LayoutManager grid = new GridLayout(0,1);
  public VerticalMenuBar() {
    setLayout(grid);
  }
}

