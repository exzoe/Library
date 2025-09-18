import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shelf {
    private List<Book> books = new ArrayList<>();
    private final int shelfId;

    public Shelf(List<Book> books, int shelfId) {
        this.books = books;
        this.shelfId = shelfId;
    }
    public Shelf(int shelfId) {
        this.shelfId = shelfId;
    }

    public List<Book> getBooks() {
        return books;
    }
    public int getShelfId() {
        return shelfId;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (bookId == book.getId()){
                return book;
            }
        }
        throw new IllegalArgumentException("Книги с ID " + bookId + " нет на полке " + shelfId);
    }
    public Book findBookByTitle(String bookTitle) {
        for (Book book : books) {
            if (Objects.equals(bookTitle, book.getTitle())){
                return book;
            }
        }
        throw new IllegalArgumentException("Книги с названием " + bookTitle + " нет на полке " + shelfId);
    }

}
