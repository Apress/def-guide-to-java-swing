import javax.swing.*;
import java.awt.*;	
import java.util.Hashtable;

public class SampleSliders {
  public static void main(final String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        String title = (args.length==0 ? "Sample Slider" : args[0]);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSlider js1 = new JSlider();
        js1.putClientProperty("JSlider.isFilled", Boolean.TRUE);
        JSlider js2 = new JSlider();
        js2.setMajorTickSpacing(25);
        js2.setPaintTicks(true);
        js2.setSnapToTicks(true);
        JSlider js3 = new JSlider(JSlider.VERTICAL);
        js3.setPaintTrack(false);
        js3.setMinorTickSpacing(5);
        js3.setMajorTickSpacing(10);
        js3.setPaintTicks(true);
        js3.setPaintLabels(true);
        js3.setSnapToTicks(true);
        JSlider js4 = new JSlider(JSlider.VERTICAL);
        Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
        table.put(0, new JLabel(new DiamondIcon(Color.RED)));
        table.put(10, new JLabel("Ten"));
        table.put(25, new JLabel("Twenty-Five"));
        table.put(34, new JLabel("Thirty-Four"));
        table.put(52, new JLabel("Fifty-Two"));
        table.put(70, new JLabel("Seventy"));
        table.put(82, new JLabel("Eighty-Two"));
        table.put(100, new JLabel(new DiamondIcon(Color.BLACK)));
        js4.setLabelTable(table);
        js4.setPaintLabels(true);
        js4.setSnapToTicks(true);
        frame.add(js1, BorderLayout.NORTH);
        frame.add(js2, BorderLayout.SOUTH);
        frame.add(js3, BorderLayout.WEST);
        frame.add(js4, BorderLayout.EAST);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
