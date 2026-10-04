package library.core;

import java.util.UUID;

public class Book {
    private final String title;
    private final String author;
    private final int pages;
    private final String id;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.id = UUID.randomUUID().toString();
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

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Книга. Название = " + title + ", автор = " + author + ", кол-во страниц = " + pages + ", ID = " + id;
    }
}