import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class ComplexCellRenderer implements ListCellRenderer { 
  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

  public Component getListCellRendererComponent(JList list, Object value, int index,
      boolean isSelected, boolean cellHasFocus) { 
    Font theFont        = null;
    Color theForeground = null;
    Icon theIcon        = null;
    String theText      = null;

    JLabel renderer = (JLabel)defaultRenderer.getListCellRendererComponent(
      list, value, index, isSelected, cellHasFocus);

    if (value instanceof Object[]) { 
      Object values[] = (Object[])value;
      theFont         = (Font)values[0];
      theForeground   = (Color)values[1];
      theIcon         = (Icon)values[2];
      theText         = (String)values[3];
    }  else { 
      theFont       = list.getFont();
      theForeground = list.getForeground();
      theText       = "";
    } 
    if (!isSelected) { 
      renderer.setForeground(theForeground);
    } 
    if (theIcon != null) { 
      renderer.setIcon(theIcon);
    } 
    renderer.setText(theText);
    renderer.setFont(theFont);
    return renderer;
  } 
} 
