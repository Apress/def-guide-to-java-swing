public class CheckBoxNode {
  String text;
  boolean selected;
  public CheckBoxNode(String text, boolean selected) {
    this.text = text;
    this.selected = selected;
  }
  public boolean isSelected() {
    return selected;
  }
  public void setSelected(boolean newValue) {
    selected = newValue;
  }
  public String getText() {
    return text;
  }
  public void setText(String newValue) {
    text = newValue;
  }
  public String toString() {
    return getClass().getName() + "[" + text + "/" + selected + "]";
  }
}
