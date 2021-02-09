package shop.models;

public class BasketItem {
    private static int MIN_BOOK_QTY_ADD = 1;

    private Book book;
    private int qty;

    public BasketItem(Book book) {
        this.book = book;
        this.qty = MIN_BOOK_QTY_ADD;
    }

    public BasketItem(Book book, int qty) {
        this.book = book;
        this.qty = qty;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void increaseQty() {
        ++qty;
    }

    public void decreaseQty() {
        qty = qty == 0 ? qty - 1 : 0;
    }

    public int getSumPrice() {
        return book.getPrice() * qty;
    }

    public boolean isBook(Book book) {
        return this.book.equals(book);
    }
}
