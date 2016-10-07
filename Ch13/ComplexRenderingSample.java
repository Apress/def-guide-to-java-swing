import javax.swing.*;
import java.awt.*;
public class ComplexRenderingSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {

        Object elements[][] = {
          {new Font("Helvetica", Font.PLAIN, 20), Color.RED,
            new DiamondIcon(Color.BLUE), "Help"},
          {new Font("TimesRoman", Font.BOLD, 14), Color.BLUE,
            new DiamondIcon(Color.GREEN), "Me"},
          {new Font("Courier", Font.ITALIC, 18), Color.GREEN,
            new DiamondIcon(Color.BLACK), "I'm"},
          {new Font("Helvetica", Font.BOLD | Font.ITALIC, 12), Color.GRAY,
            new DiamondIcon(Color.MAGENTA), "Trapped"},
          {new Font("TimesRoman", Font.PLAIN, 32), Color.PINK,
            new DiamondIcon(Color.YELLOW), "Inside"},
          {new Font("Courier", Font.BOLD, 16), Color.YELLOW,
            new DiamondIcon(Color.RED), "This"},
          {new Font("Helvetica", Font.ITALIC, 8), Color.DARK_GRAY,
            new DiamondIcon(Color.PINK), "Computer"}
        };

        JFrame frame = new JFrame("Complex Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JList jlist = new JList(elements);
        ListCellRenderer renderer = new ComplexCellRenderer();
        jlist.setCellRenderer(renderer);
        JScrollPane scrollPane = new JScrollPane(jlist);
        frame.add(scrollPane, BorderLayout.CENTER);

        JComboBox comboBox = new JComboBox(elements);
        comboBox.setRenderer(renderer);
        frame.add(comboBox, BorderLayout.NORTH);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
