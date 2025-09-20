public class Book {
    private final String title;
    private final String author;
    private final int pages;
    private final int id;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.id = Shelf.idCount++;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Книга. Название = " + title + ", автор = " + author + ", кол-во страниц = " + pages + ", ID = " + id;
    }
}
