public class Book {
  String title;
  String authors;
  float price;
  public Book(String title, String authors, float price) {
    this.title = title;
    this.authors = authors;
    this.price = price;
  }
  public String getTitle() {
    return title;
  }
  public String getAuthors() {
    return authors;
  }
  public float getPrice() {
    return price;
  }
}
