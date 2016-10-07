import javax.swing.*;
import java.awt.*;  

public class GroupRadio {
  private static final String sliceOptions[] = 
    {"4 slices", "8 slices", "12 slices", "16 slices"};
  private static final String crustOptions[] = 
    {"Sicilian", "Thin Crust", "Thick Crust", "Stuffed Crust"};
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Grouping Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container sliceContainer = 
          RadioButtonUtils.createRadioButtonGrouping(
          sliceOptions, "Slice Count");
        Container crustContainer = 
          RadioButtonUtils.createRadioButtonGrouping(
          crustOptions, "Crust Type");
        frame.add(sliceContainer, BorderLayout.WEST);
        frame.add(crustContainer, BorderLayout.EAST);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
