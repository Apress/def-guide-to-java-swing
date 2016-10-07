import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.ParserDelegator;
import java.net.*;

public class ElementIteratorExample {

  public static void main(String args[]) throws Exception {

    if (args.length != 1) {
      System.err.println("Usage: java ElementIteratorExample input-URL");
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
    ElementIterator iterator = new ElementIterator(htmlDoc);
    Element element;
    while ((element = iterator.next()) != null) {
      AttributeSet attributes = element.getAttributes();
      Object name = attributes.getAttribute(StyleConstants.NameAttribute);
      if ((name instanceof HTML.Tag) && ((name == HTML.Tag.H1) ||
          (name == HTML.Tag.H2) || (name == HTML.Tag.H3))) {
        // Build up content text as it may be within multiple elements
        StringBuffer text = new StringBuffer();
        int count = element.getElementCount();
        for (int i=0; i<count; i++) {
          Element child = element.getElement(i);
          AttributeSet childAttributes = child.getAttributes();
          if (childAttributes.getAttribute(StyleConstants.NameAttribute) ==
              HTML.Tag.CONTENT) {
            int startOffset = child.getStartOffset();
            int endOffset = child.getEndOffset();
            int length = endOffset - startOffset;
            text.append(htmlDoc.getText(startOffset, length));
          }
        }
        System.out.println(name + ": " + text.toString());
      }
    }
    System.exit(0);
  }
}
