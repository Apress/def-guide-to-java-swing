import java.io.*;
import java.awt.*;
import javax.swing.*;

public class ProgressInputSample {
  public static final int NORMAL   = 0;
  public static final int BAD_FILE = 1;
  public static final int CANCELED = NORMAL;
  public static final int PROBLEM = 2;
 
  public static void main(String args[]) {
    int returnValue = NORMAL;
    if (args.length != 1) {
      System.err.println("Usage:");
      System.err.println("java ProgressInputSample filename");
    } else {
      try {
        FileInputStream fis = new FileInputStream(args[0]);
        JLabel filenameLabel = new JLabel(args[0], JLabel.RIGHT);
        Object message[] = {"Reading:", filenameLabel};
        ProgressMonitorInputStream pmis =
          new ProgressMonitorInputStream(null, message, fis);
        InputStreamReader isr = new InputStreamReader(pmis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
          System.out.println(line);
        }
        br.close();
      } catch (FileNotFoundException exception) {
        System.err.println("Bad File " + exception);
        returnValue = BAD_FILE;
      } catch (InterruptedIOException exception) {
        System.err.println("Canceled");
        returnValue = CANCELED;
      } catch (IOException exception) {
        System.err.println("I/O Exception " + exception);
        returnValue = PROBLEM;
      }
    }
    // AWT Thread created - must exit
    System.exit(returnValue);
  }
}
