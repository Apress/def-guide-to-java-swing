import javax.swing.*;
import javax.swing.text.*;
import java.util.Hashtable;

public final class TextUtilities {
  private TextUtilities() {
  }

  public static Action findAction(Action actions[], String key) {
    Hashtable<Object, Action> commands = new Hashtable<Object, Action>();
    for (int i = 0; i < actions.length; i++) {
      Action action = actions[i];
      commands.put(action.getValue(Action.NAME), action);
    }
    return commands.get(key);
  }
}
