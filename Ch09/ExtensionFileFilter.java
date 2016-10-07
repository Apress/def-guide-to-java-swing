import javax.swing.filechooser.*;
import java.io.File; // avoid FileFilter name conflict

public class ExtensionFileFilter extends FileFilter { 
  String description;
  String extensions[];

  public ExtensionFileFilter(String description, String extension) { 
    this(description, new String[] { extension} );
  } 

  public ExtensionFileFilter(String description, String extensions[]) { 
    if (description == null) { 
// Since no description, use first extension and # of extensions as description
      this.description = extensions[0]+"{ "+extensions.length+"} " ;
    }  else { 
      this.description = description;
    } 
    // Convert array to lowercase
    // Don't alter original entries
    this.extensions = (String[])extensions.clone();
    toLower(this.extensions);
  } 
  private void toLower(String array[]) { 
    for (int i=0, n=array.length; i<n; i++) { 
      array[i] = array[i].toLowerCase();
    } 
  }  

  public String getDescription() { 
    return description;
  } 

  // ignore case, always accept directories
  // character before extension must be a period
  public boolean accept(File file) { 
    if (file.isDirectory()) { 
      return true;
    }  else { 
      String path = file.getAbsolutePath().toLowerCase();
      for (int i=0, n=extensions.length; i<n; i++) { 
        String extension = extensions[i];
        if ((path.endsWith(extension)  &&
            (path.charAt(path.length()-extension.length()-1)) == '.')) { 
          return true;
        } 
      } 
    } 
    return false;
  } 
} 
