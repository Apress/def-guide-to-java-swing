import javax.swing.text.*;
import java.awt.Toolkit;

public class IntegerRangeDocumentFilter extends DocumentFilter {

  int minimum, maximum;
  int currentValue = 0;

  public IntegerRangeDocumentFilter(int minimum, int maximum) {
    this.minimum = minimum;
    this.maximum = maximum;
  }

  public void insertString(DocumentFilter.FilterBypass fb, int offset,
      String string, AttributeSet attr) throws BadLocationException {

    if (string == null) {
      return;
    } else {
      String newValue;
      Document doc = fb.getDocument();
      int length = doc.getLength();
      if (length == 0) {
        newValue = string;
      } else {
        String currentContent = doc.getText(0, length);
        StringBuffer currentBuffer = new StringBuffer(currentContent);
        currentBuffer.insert(offset, string);
        newValue = currentBuffer.toString();
      }
      currentValue = checkInput(newValue, offset);
      fb.insertString(offset, string, attr);
    }
  }

  public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
      throws BadLocationException {

    Document doc = fb.getDocument();
    int currentLength = doc.getLength();
    String currentContent = doc.getText(0, currentLength);
    String before = currentContent.substring(0, offset);
    String after = currentContent.substring(length+offset, currentLength);
    String newValue = before + after;
    currentValue = checkInput(newValue, offset);
    fb.remove(offset, length);
  }

  public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
      String text, AttributeSet attrs) throws BadLocationException {

    Document doc = fb.getDocument();
    int currentLength = doc.getLength();
    String currentContent = doc.getText(0, currentLength);
    String before = currentContent.substring(0, offset);
    String after = currentContent.substring(length+offset, currentLength);
    String newValue = before + (text == null ? "" : text) + after;
    currentValue = checkInput(newValue, offset);
    fb.replace(offset, length, text, attrs);
  }

  private int checkInput(String proposedValue, int offset)
      throws BadLocationException {
    int newValue = 0;
    if (proposedValue.length() > 0) {
      try {
        newValue = Integer.parseInt(proposedValue);
      } catch (NumberFormatException e) {
        throw new BadLocationException(proposedValue, offset);
      }
    }
    if ((minimum <= newValue) && (newValue <= maximum)) {
      return newValue;
    } else {
      throw new BadLocationException(proposedValue, offset);
    }
  }
}
