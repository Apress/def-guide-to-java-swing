import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  

public class BorderSample {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Sample Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border bevelBorder = new BevelBorder(BevelBorder.RAISED, Color.RED, Color.RED.darker(), Color.PINK, Color.PINK.brighter());
        Border emptyBorder = new EmptyBorder(5, 10, 5, 10);
        Border etchedBorder = new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.PINK);
        Border lineBorder = new LineBorder (Color.RED, 5);
        Icon diamondIcon = new DiamondIcon(Color.RED);
        Border matteBorder = new MatteBorder(5, 10, 5, 10, diamondIcon);
        Border softBevelBorder = new SoftBevelBorder(BevelBorder.RAISED, Color.RED, Color.RED.darker(), Color.PINK, Color.PINK.brighter());
        Font font = new Font("Serif", Font.ITALIC, 12);
        Border titledBorder = new TitledBorder(lineBorder, "Hello", TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM, font, Color.RED);
        Border compoundBorder = new CompoundBorder(lineBorder, matteBorder);
    
        JLabel bevelLabel = new JLabel("Bevel");
        bevelLabel.setBorder(bevelBorder);
        bevelLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel emptyLabel = new JLabel("Empty");
        emptyLabel.setBorder(emptyBorder);
        emptyLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel etchedLabel = new JLabel("Etched");
        etchedLabel.setBorder(etchedBorder);
        etchedLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel lineLabel = new JLabel("Line");
        lineLabel.setBorder(lineBorder);
        lineLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel matteLabel = new JLabel("Matte");
        matteLabel.setBorder(matteBorder);
        matteLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel softBevelLabel = new JLabel("Soft Bevel");
        softBevelLabel.setBorder(softBevelBorder);
        softBevelLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel titledLabel = new JLabel("Titled");
        titledLabel.setBorder(titledBorder);
        titledLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel compoundLabel = new JLabel("Compound");
        compoundLabel.setBorder(compoundBorder);
        compoundLabel.setHorizontalAlignment(JLabel.CENTER);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(2, 4, 5, 5));
        contentPane.add(bevelLabel);
        contentPane.add(emptyLabel);
        contentPane.add(etchedLabel);
        contentPane.add(lineLabel);
        contentPane.add(matteLabel);
        contentPane.add(softBevelLabel);
        contentPane.add(titledLabel);
        contentPane.add(compoundLabel);
        frame.setSize(400, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
