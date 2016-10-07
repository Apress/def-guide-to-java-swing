import javax.swing.*;

public class ListPlafs {
  public static void main (String args[]) {
    UIManager.LookAndFeelInfo plaf[] = UIManager.getInstalledLookAndFeels();
    for (int i=0, n=plaf.length; i<n; i++) {
      System.out.println("Name: " + plaf[i].getName());
      System.out.println("  Class name: " + plaf[i].getClassName());
    }
  }
}
