import java.awt.*;
import javax.swing.*;
import java.util.Collection;
import java.util.ArrayList;

public class ArrayListComboBoxModel
    extends AbstractListModel implements ComboBoxModel {
  private Object selectedItem;
  private ArrayList anArrayList;
  public ArrayListComboBoxModel(ArrayList arrayList) {
    anArrayList = arrayList;
  }
  public Object getSelectedItem() {
    return selectedItem;
  }
  public void setSelectedItem(Object newValue) {
    selectedItem = newValue;
  }
  public int getSize() { 
    return anArrayList.size();
  }
  public Object getElementAt(int i) {
    return anArrayList.get(i);
  }

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("ArrayListComboBoxModel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Collection<Object> col = System.getProperties().values();
        ArrayList<Object> arrayList = new ArrayList<Object>(col);
        ArrayListComboBoxModel model = new ArrayListComboBoxModel(arrayList);

        JComboBox comboBox = new JComboBox (model);

        frame.add(comboBox, BorderLayout.NORTH);
        frame.setSize(300, 225);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}

