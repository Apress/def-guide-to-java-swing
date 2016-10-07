import javax.swing.UIDefaults;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
public class MyWindows extends WindowsLookAndFeel { 
  public String getID() { 
    return "MyWindows";
  } 
  public String getName() { 
    return "MyWindows Look and Feel";
  } 
  public String getDescription() { 
    return "The MyWindows Look and Feel";
  } 
  public boolean isNativeLookAndFeel() { 
    return false;
  } 
  public boolean isSupportedLookAndFeel() { 
    return true;
  } 
} 
