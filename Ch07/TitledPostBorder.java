import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class TitledPostBorder {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Positioned Titled Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TitledBorder aboveTopBorder = BorderFactory.createTitledBorder("AboveTop");
        aboveTopBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
        JButton aboveTopButton = new JButton();
        aboveTopButton.setBorder(aboveTopBorder);
        TitledBorder topBorder = BorderFactory.createTitledBorder("Top");
        topBorder.setTitlePosition(TitledBorder.TOP);
        JButton topButton = new JButton();
        topButton.setBorder(topBorder);
        TitledBorder belowTopBorder = BorderFactory.createTitledBorder("BelowTop");
        belowTopBorder.setTitlePosition(TitledBorder.BELOW_TOP);
        JButton belowTopButton = new JButton();
        belowTopButton.setBorder(belowTopBorder);
        TitledBorder aboveBottomBorder = BorderFactory.createTitledBorder("AboveBottom");
        aboveBottomBorder.setTitlePosition(TitledBorder.ABOVE_BOTTOM);
        JButton aboveBottomButton = new JButton();
        aboveBottomButton.setBorder(aboveBottomBorder);
        TitledBorder bottomBorder = BorderFactory.createTitledBorder("Bottom");
        bottomBorder.setTitlePosition(TitledBorder.BOTTOM);
        JButton bottomButton = new JButton();
        bottomButton.setBorder(bottomBorder);
        TitledBorder belowBottomBorder = BorderFactory.createTitledBorder("BelowBottom");
        belowBottomBorder.setTitlePosition(TitledBorder.BELOW_BOTTOM);
        JButton belowBottomButton = new JButton();
        belowBottomButton.setBorder(belowBottomBorder);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(3, 2));
        contentPane.add(aboveTopButton);
        contentPane.add(aboveBottomButton);
        contentPane.add(topButton);
        contentPane.add(bottomButton);
        contentPane.add(belowTopButton);
        contentPane.add(belowBottomButton);
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
