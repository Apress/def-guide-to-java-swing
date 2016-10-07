import java.awt.*;
import javax.swing.*;

public class TableSample {
  public static void main (String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame f = new JFrame("JTable Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object rows[][] = {
          {"AMZN", "Amazon", "38.94"},
          {"DCLK", "DoubleClick", "7.70"},
          {"EBAY", "eBay", "112.65"},
          {"GOOG", "Google", "181.05"},
          {"MKTW", "MarketWatch", "18.08"},
          {"SAP", "SAP AG", "45.35"},
          {"SUNW", "Sun Microsystems", "5.51"},
          {"TWX",  "Time Warner", "17.82"},
          {"VOD",  "Vodafone Group", "27.39"},
          {"YHOO", "Yahoo!", "38.12"}
        };
        Object columns[] = {"Symbol", "Name", "Price"};
        JTable table = new JTable(rows, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        f.add(scrollPane, BorderLayout.CENTER);
        f.setSize (300, 200);
        f.setVisible (true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
