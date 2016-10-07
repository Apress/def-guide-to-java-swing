import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class BookTree {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Book Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Book javaBooks[] = {
          new Book("Core Java 2", "Horstmann/Cornell", 49.99f),
          new Book("Effective Java", "Bloch", 34.99f),
          new Book("Java Collections", "Zukowski", 49.95f)
        };
        Book netBooks[] = {
          new Book("Beginning VB .NET 1.1 Databases", "Maharry", 49.99f),
          new Book("Beginning VB.NET Databases", "Willis", 39.99f)
        };
        Vector<Book> javaVector = new NamedVector<Book>("Java Books", javaBooks);
        Vector<Book> netVector = new NamedVector<Book>(".NET Books", netBooks);
        Object rootNodes[] = {javaVector, netVector};
        Vector<Object> rootVector = new NamedVector<Object>("Root", rootNodes);
        JTree tree = new JTree(rootVector);
        TreeCellRenderer renderer = new BookCellRenderer();
        tree.setCellRenderer(renderer);
        JScrollPane scrollPane = new JScrollPane(tree);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
