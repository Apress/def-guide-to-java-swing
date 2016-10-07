import javax.swing.*;
import java.beans.*;
import java.awt.*;
import java.io.*;

public class LabelAccessory extends JLabel implements PropertyChangeListener {
  private static final int PREFERRED_WIDTH = 125;
  private static final int PREFERRED_HEIGHT = 100;

  public LabelAccessory(JFileChooser chooser) {
    setVerticalAlignment(JLabel.CENTER);
    setHorizontalAlignment(JLabel.CENTER);
    chooser.addPropertyChangeListener(this);
    setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
  }
  public void propertyChange(PropertyChangeEvent changeEvent) {
    String changeName = changeEvent.getPropertyName();
    if (changeName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
      File file = (File)changeEvent.getNewValue();
      if (file != null) {
        ImageIcon icon = new ImageIcon(file.getPath());
        if (icon.getIconWidth() > PREFERRED_WIDTH) {
          icon = new ImageIcon(icon.getImage().getScaledInstance(
            PREFERRED_WIDTH, -1, Image.SCALE_DEFAULT));
          if (icon.getIconHeight() > PREFERRED_HEIGHT) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(
            -1, PREFERRED_HEIGHT, Image.SCALE_DEFAULT));
          }
        }
        setIcon(icon);
      }
    }
  }
}

