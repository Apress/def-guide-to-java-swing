import java.util.Vector;
public class NamedVector extends Vector {
  String name;
  NamedVector(String name) {
    this.name = name;
  }
  NamedVector(String name, Object elements[]) {
    this.name = name;
    for (int i=0, n=elements.length; i<n; i++) {
      add(elements[i]);
    }
  }
  public String toString() {
    return name;
  }
}

