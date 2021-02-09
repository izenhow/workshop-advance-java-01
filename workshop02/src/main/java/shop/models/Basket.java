package shop.models;

import java.util.Optional;

public class Basket {
    private BasketItemList books = new BasketItemList();
    private int netPrice;
    private int discountPrice;

    public void addBook(Book book) {
        books.addBook(book);
    }

    public int getBookListSize() {
        return books.getSize();
    }

    public BasketItemList getItemList() {
        return books;
    }

    public int getBookQty(Book book) {
        return Optional.of(books.findItem(book)).map(BasketItem::getQty).orElse(0);
    }

    // left-shift to avoid dealing with decimal number
    public int getNetPrice() {
        return netPrice * 100;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}
