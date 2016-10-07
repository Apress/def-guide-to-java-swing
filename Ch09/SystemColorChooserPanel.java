import javax.swing.*;
import javax.swing.colorchooser.*;
import java.awt.*;
import java.awt.event.*;

public class SystemColorChooserPanel
    extends AbstractColorChooserPanel
    implements ItemListener {

  private static int NOT_FOUND = -1;

  JComboBox comboBox;
  String labels[] = {
    "BLACK",
    "BLUE",
    "CYAN",
    "DARK_GRAY",
    "GRAY",
    "GREEN",
    "LIGHT_GRAY",
    "MAGENTA",
    "ORANGE",
    "PINK",
    "RED",
    "WHITE",
    "YELLOW",
    "activeCaption",
    "activeCaptionBorder",
    "activeCaptionText",
    "control",
    "controlDkShadow",
    "controlHighlight",
    "controlLtHighlight",
    "controlShadow",
    "controlText",
    "desktop",
    "inactiveCaption",
    "inactiveCaptionBorder",
    "inactiveCaptionText",
    "info",
    "infoText",
    "menu",
    "menuText",
    "scrollbar",
    "text",
    "textHighlight",
    "textHighlightText",
    "textInactiveText",
    "textText",
    "window",
    "windowBorder",
    "windowText",
    "<Custom>"};

  Color colors[] = {
    Color.BLACK,
    Color.BLUE,
    Color.CYAN,
    Color.DARK_GRAY,
    Color.GRAY,
    Color.GREEN,
    Color.LIGHT_GRAY,
    Color.MAGENTA,
    Color.ORANGE,
    Color.PINK,
    Color.RED,
    Color.WHITE,
    Color.YELLOW,
    SystemColor.activeCaption,
    SystemColor.activeCaptionBorder,
    SystemColor.activeCaptionText,
    SystemColor.control,
    SystemColor.controlDkShadow,
    SystemColor.controlHighlight,
    SystemColor.controlLtHighlight,
    SystemColor.controlShadow,
    SystemColor.controlText,
    SystemColor.desktop,
    SystemColor.inactiveCaption,
    SystemColor.inactiveCaptionBorder,
    SystemColor.inactiveCaptionText,
    SystemColor.info,
    SystemColor.infoText,
    SystemColor.menu,
    SystemColor.menuText,
    SystemColor.scrollbar,
    SystemColor.text,
    SystemColor.textHighlight,
    SystemColor.textHighlightText,
    SystemColor.textInactiveText,
    SystemColor.textText,
    SystemColor.window,
    SystemColor.windowBorder,
    SystemColor.windowText,
    null};
 
  // Change combo box to match color, if possible
  private void setColor(Color newColor) {
    int position = findColorPosition(newColor);
    comboBox.setSelectedIndex(position);
  }

  // Given a label, find the position of the label in the list
  private int findColorLabel(Object label) {
    String stringLabel = label.toString();
    int position = NOT_FOUND;
    for (int i=0,n=labels.length; i<n; i++) {
      if (stringLabel.equals(labels[i])) {
        position=i;
        break;
      }
    }
    return position;
  }

  // Given a color, find the position whose color matches
  // This could result in a position different from original if two are equal
  // Since actually color is same, this is considered to be okay
  private int findColorPosition(Color color) {
    int position = colors.length-1;
    // Cannot use equals() to compare Color and SystemColor
    int colorRGB = color.getRGB();
    for (int i=0,n=colors.length; i<n; i++) {
      if ((colors[i] != null) && (colorRGB == colors[i].getRGB())) {
        position=i;
        break;
      }
    }
    return position;
  }

  public void itemStateChanged(ItemEvent itemEvent) {
    int state = itemEvent.getStateChange();
    if (state == ItemEvent.SELECTED) {
      int position = findColorLabel(itemEvent.getItem());
      // last position is bad (not selectable)
      if ((position != NOT_FOUND) && (position != labels.length-1)) {
        ColorSelectionModel selectionModel = getColorSelectionModel();
        selectionModel.setSelectedColor(colors[position]);
      }
    }
  }

  public String getDisplayName() {
    return "SystemColor";
  }

  public Icon getSmallDisplayIcon() {
    return new DiamondIcon(Color.BLUE);
  }

  public Icon getLargeDisplayIcon() {
    return new DiamondIcon(Color.GREEN);
  }
       
  protected void buildChooser() {
    comboBox = new JComboBox(labels);
    comboBox.addItemListener(this);
    add(comboBox);
  }

  public void updateChooser() {
    Color color = getColorFromModel();
    setColor(color);
  }
}
