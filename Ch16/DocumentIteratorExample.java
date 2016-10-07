import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class DocumentIteratorExample {

  public static void main(String args[]) throws Exception {

    if (args.length != 1) {
      System.err.println("Usage: java DocumentIteratorExample input-URL");
    }

    // Load HTML file synchronously
    URL url = new URL(args[0]);
    URLConnection connection = url.openConnection();
    InputStream is = connection.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);

    HTMLEditorKit htmlKit = new HTMLEditorKit();
    HTMLDocument htmlDoc = (HTMLDocument)htmlKit.createDefaultDocument();
    HTMLEditorKit.Parser parser = new ParserDelegator();
    HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
    parser.parse(br, callback, true);

    // Parse
    for (HTMLDocument.Iterator iterator = 
           htmlDoc.getIterator(HTML.Tag.A);
         iterator.isValid();
         iterator.next()) {

      AttributeSet attributes = iterator.getAttributes();
      String srcString = (String)
        attributes.getAttribute(HTML.Attribute.HREF);
      System.out.print(srcString);
      int startOffset = iterator.getStartOffset();
      int endOffset = iterator.getEndOffset();
      int length = endOffset - startOffset;
      String text = htmlDoc.getText(startOffset, length);
      System.out.println(" - " + text);
    }
    System.exit(0);
  }
}
