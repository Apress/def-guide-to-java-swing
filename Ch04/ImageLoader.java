import java.awt.*;
import java.io.*;

public final class ImageLoader {

  private ImageLoader() {
  }

  public static Image getImage(Class relativeClass, String filename) {
    Image returnValue = null;
    InputStream is = relativeClass.getResourceAsStream(filename);
    if (is != null) {
      BufferedInputStream bis = new BufferedInputStream(is);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try {
        int ch;
        while ((ch = bis.read()) != -1) {
          baos.write(ch);
        }
        returnValue = Toolkit.getDefaultToolkit().createImage(baos.toByteArray());
      }  catch (IOException exception) {
        System.err.println("Error loading: " + filename);
      }
    }
    return returnValue;
  }
}
