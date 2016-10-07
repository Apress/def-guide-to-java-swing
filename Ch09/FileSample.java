import java.io.File;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class FileSample {

  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("JFileChooser Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel directoryLabel = new JLabel();
        frame.add(directoryLabel, BorderLayout.NORTH);

        final JLabel filenameLabel = new JLabel();
        frame.add(filenameLabel, BorderLayout.SOUTH);

        final JButton button = new JButton("Open FileChooser");
        ActionListener actionListener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Component parent = (Component)actionEvent.getSource();
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setAccessory(new LabelAccessory(fileChooser));
            FileView view = new JavaFileView();
            fileChooser.setFileView (view);
            int status = fileChooser.showOpenDialog(parent);
            if (status == JFileChooser.APPROVE_OPTION) {
              File selectedFile = fileChooser.getSelectedFile();
              directoryLabel.setText(selectedFile.getParent());
              filenameLabel.setText(selectedFile.getName());
             } else if (status == JFileChooser.CANCEL_OPTION) {
              directoryLabel.setText(" ");
              filenameLabel.setText(" ");
             }
          }
        };
        button.addActionListener(actionListener);
        frame.add(button, BorderLayout.CENTER);

        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
