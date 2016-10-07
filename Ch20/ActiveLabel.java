import javax.swing.*;

public class ActiveLabel implements UIDefaults.ActiveValue {
  private int counter = 0;

  public Object createValue(UIDefaults defaults) {
    JLabel label = new JLabel(""+counter++);
    return label;
  }
}
