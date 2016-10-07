import javax.swing.JFrame;

public class ExitableJFrame extends JFrame { 
  public ExitableJFrame () { 
  } 
  public ExitableJFrame (String title) { 
    super (title);
  } 
  protected void frameInit() { 
    super.frameInit();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  } 
} 
