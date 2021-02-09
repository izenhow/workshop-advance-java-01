package shop.models;

public class BookBuilder {
    private Book book;

    public BookBuilder() {
        book = new Book();
    }

    public BookBuilder chooseBook(String name) {
        book.setName(name);
        book.setPrice(8);
        return this;
    }

    public Book build() {
        return book;
    }
}