import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Iterator;

public class DualListBox extends JPanel {

  private static final Insets EMPTY_INSETS = new Insets(0,0,0,0);
  private static final String ADD_BUTTON_LABEL = "Add >>";
  private static final String REMOVE_BUTTON_LABEL = "<< Remove";
  private static final String DEFAULT_SOURCE_CHOICE_LABEL =
    "Available Choices";
  private static final String DEFAULT_DEST_CHOICE_LABEL =
    "Your Choices";
  private JLabel sourceLabel;
  private JList sourceList;
  private SortedListModel sourceListModel;
  private JList destList;
  private SortedListModel destListModel;
  private JLabel destLabel;
  private JButton addButton;
  private JButton removeButton;

  public DualListBox() {
    initScreen();
  }
  public String getSourceChoicesTitle() {
    return sourceLabel.getText();
  }
  public void setSourceChoicesTitle(String newValue) {
    sourceLabel.setText(newValue);
  }
  public String getDestinationChoicesTitle() {
    return destLabel.getText();
  }
  public void setDestinationChoicesTitle(String newValue) {
    destLabel.setText(newValue);
  }
  public void clearSourceListModel() {
    sourceListModel.clear();
  }
  public void clearDestinationListModel() {
    destListModel.clear();
  }
  public void addSourceElements(ListModel newValue) {
    fillListModel(sourceListModel, newValue);
  }
  public void setSourceElements(ListModel newValue) {
    clearSourceListModel();
    addSourceElements(newValue);
  }
  public void addDestinationElements(ListModel newValue) {
    fillListModel(destListModel, newValue);
  }
  private void fillListModel(SortedListModel model, ListModel newValues) {
    int size = newValues.getSize();
    for (int i=0; i<size; i++) {
      model.add(newValues.getElementAt(i));
    }
  }
  public void addSourceElements(Object newValue[]) {
    fillListModel(sourceListModel, newValue);
  }
  public void setSourceElements(Object newValue[]) {
    clearSourceListModel();
    addSourceElements(newValue);
  }
  public void addDestinationElements(Object newValue[]) {
    fillListModel(destListModel, newValue);
  }
  private void fillListModel(SortedListModel model, Object newValues[]) {
    model.addAll(newValues);
  }
  public Iterator sourceIterator() {
    return sourceListModel.iterator();
  }
  public Iterator destinationIterator() {
    return destListModel.iterator();
  }
  public void setSourceCellRenderer(ListCellRenderer newValue) {
    sourceList.setCellRenderer(newValue);
  }
  public ListCellRenderer getSourceCellRenderer() {
    return sourceList.getCellRenderer();
  }
  public void setDestinationCellRenderer(ListCellRenderer newValue) {
    destList.setCellRenderer(newValue);
  }
  public ListCellRenderer getDestinationCellRenderer() {
    return destList.getCellRenderer();
  }
  public void setVisibleRowCount(int newValue) {
    sourceList.setVisibleRowCount(newValue);
    destList.setVisibleRowCount(newValue);
  }
  public int getVisibleRowCount() {
    return sourceList.getVisibleRowCount();
  }
  public void setSelectionBackground(Color newValue) {
    sourceList.setSelectionBackground(newValue);
    destList.setSelectionBackground(newValue);
  }
  public Color getSelectionBackground() {
    return sourceList.getSelectionBackground();
  }
  public void setSelectionForeground(Color newValue) {
    sourceList.setSelectionForeground(newValue);
    destList.setSelectionForeground(newValue);
  }
  public Color getSelectionForeground() {
    return sourceList.getSelectionForeground();
  }
  private void clearSourceSelected() {
    Object selected[] = sourceList.getSelectedValues();
    for (int i=selected.length-1; i >= 0; --i) {
      sourceListModel.removeElement(selected[i]);
    }
    sourceList.getSelectionModel().clearSelection();
  }
  private void clearDestinationSelected() {
    Object selected[] = destList.getSelectedValues();
    for (int i=selected.length-1; i >= 0; --i) {
      destListModel.removeElement(selected[i]);
    }
    destList.getSelectionModel().clearSelection();
  }
  private void initScreen() {
    setBorder(BorderFactory.createEtchedBorder());
    setLayout(new GridBagLayout());
    sourceLabel = new JLabel(DEFAULT_SOURCE_CHOICE_LABEL);
    sourceListModel = new SortedListModel();
    sourceList = new JList(sourceListModel);
    add(sourceLabel,
      new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.NONE, EMPTY_INSETS, 0, 0));
    add(new JScrollPane(sourceList),
      new GridBagConstraints(0, 1, 1, 5, .5, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, EMPTY_INSETS, 0, 0));

    addButton = new JButton(ADD_BUTTON_LABEL);
    add(addButton,
      new GridBagConstraints(1, 2, 1, 2, 0, .25, GridBagConstraints.CENTER,
        GridBagConstraints.NONE, EMPTY_INSETS, 0, 0));
    addButton.addActionListener(new AddListener());
    removeButton = new JButton(REMOVE_BUTTON_LABEL);
    add(removeButton,
      new GridBagConstraints(1, 4, 1, 2, 0, .25, GridBagConstraints.CENTER,
        GridBagConstraints.NONE, new Insets(0,5,0,5), 0, 0));
    removeButton.addActionListener(new RemoveListener());

    destLabel = new JLabel(DEFAULT_DEST_CHOICE_LABEL);
    destListModel = new SortedListModel();
    destList = new JList(destListModel);
    add(destLabel,
      new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.NONE, EMPTY_INSETS, 0, 0));
    add(new JScrollPane(destList),
      new GridBagConstraints(2, 1, 1, 5, .5, 1.0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, EMPTY_INSETS, 0, 0));
  }

  private class AddListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Object selected[] = sourceList.getSelectedValues();
      addDestinationElements(selected);
      clearSourceSelected();
    }
  }
  private class RemoveListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Object selected[] = destList.getSelectedValues();
      addSourceElements(selected);
      clearDestinationSelected();
    }
  }

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Dual List Box Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DualListBox dual = new DualListBox();
        dual.addSourceElements(
          new String[] {"One", "Two", "Three"});
        dual.addSourceElements(
          new String[] {"Four", "Five", "Six"});
        dual.addSourceElements(
          new String[] {"Seven", "Eight", "Nine"});
        dual.addSourceElements(
          new String[] {"Ten", "Eleven", "Twelve"});
        dual.addSourceElements(
          new String[] {"Thirteen", "Fourteen", "Fifteen"});
        dual.addSourceElements(
          new String[] {"Sixteen", "Seventeen", "Eighteen"});
        dual.addSourceElements(
          new String[] {"Nineteen", "Twenty", "Thirty"});
        frame.add(dual, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
