import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ColorComboBox {
  static class ColorCellRenderer implements ListCellRenderer {
    protected DefaultListCellRenderer defaultRenderer =
      new DefaultListCellRenderer();
    // width doesn't matter as combobox will size
    private final static Dimension preferredSize = new Dimension(0, 20);
    public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {
      JLabel renderer = (JLabel)defaultRenderer.getListCellRendererComponent(
        list, value, index, isSelected, cellHasFocus);
      if (value instanceof Color) {
        renderer.setBackground((Color)value);
      }
      renderer.setPreferredSize(preferredSize);
      return renderer;
    }
  }
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        Color colors[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
          Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
          Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
        JFrame frame = new JFrame("Color JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JComboBox comboBox = new JComboBox(colors);
        comboBox.setMaximumRowCount(5);
        comboBox.setEditable(true);
        comboBox.setRenderer(new ColorCellRenderer());
        Color color = (Color)comboBox.getSelectedItem();
        ComboBoxEditor editor = new ColorComboBoxEditor(color);
        comboBox.setEditor(editor);
        frame.add(comboBox, BorderLayout.NORTH);

        final JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground((Color)comboBox.getSelectedItem());
        frame.add(label, BorderLayout.CENTER);

        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Color selectedColor = (Color)comboBox.getSelectedItem();
            label.setBackground(selectedColor);
          }
        };
        comboBox.addActionListener(actionListener);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
