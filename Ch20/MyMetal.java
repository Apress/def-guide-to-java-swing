import javax.swing.UIDefaults;
import javax.swing.plaf.metal.MetalLookAndFeel;
public class MyMetal extends MetalLookAndFeel {
  public String getID() {
    return "MyMetal";
  }
  public String getName() {
    return "MyMetal Look and Feel";
  }
  public String getDescription() {
    return "The MyMetal Look and Feel";
  }
  public boolean isNativeLookAndFeel() {
    return false;
  }
  public boolean isSupportedLookAndFeel() {
    return true;
  }
  protected void initClassDefaults(UIDefaults table) {
    super.initClassDefaults(table);
    table.put("ComboBoxUI", "MyComboBoxUI");
  }
}
