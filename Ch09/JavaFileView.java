import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class JavaFileView extends FileView {
  Icon javaIcon = new DiamondIcon(Color.BLUE);
  Icon classIcon = new DiamondIcon(Color.GREEN);
  Icon htmlIcon = new DiamondIcon(Color.RED);
  Icon jarIcon = new DiamondIcon(Color.PINK);

  public String getName(File file) {
    String filename = file.getName();
    if (filename.endsWith(".java")) {
      String name = filename + " : " + file.length(); 
      return name;
    }
    return null;
  }

  public String getTypeDescription(File file) {
    String typeDescription = null;
    String filename = file.getName().toLowerCase();

    if (filename.endsWith(".java")) {
      typeDescription = "Java Source";
    } else if (filename.endsWith(".class")){
      typeDescription = "Java Class File";
    } else if (filename.endsWith(".jar")){
      typeDescription = "Java Archive";
    } else if (filename.endsWith(".html") || filename.endsWith(".htm")) {
      typeDescription = "Applet Loader";
    }
    return typeDescription;
  }

  public Icon getIcon(File file) {
    if (file.isDirectory()) {
      return null;
    }
    Icon icon = null;
    String filename = file.getName().toLowerCase();
    if (filename.endsWith(".java")) {
      icon = javaIcon;
    } else if (filename.endsWith(".class")){
      icon = classIcon;
    } else if (filename.endsWith(".jar")){
      icon = jarIcon;
    } else if (filename.endsWith(".html") || filename.endsWith(".htm")) {
      icon = htmlIcon;
    } 
    return icon;
  }
}
