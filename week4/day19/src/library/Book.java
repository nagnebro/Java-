package library;

public class Book implements Comparable<Book> { // BookController에서 TreeSet을 사용하기 위한 인터페이스 구현.
    private String title;
    private String author;
    private String category;
    private int price;

    Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(String title, String author, String category, int price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("(%s/%s/%s/%d)",title,author,category,price);
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }


}
