package shop.biz;

import shop.models.Basket;
import shop.models.Book;
import shop.models.BookBuilder;

public class Buyer {
    private String firstName;
    private String lastName;

    public void requestToBuy() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        Book book3 = new BookBuilder().chooseBook("Potter 3").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        // 3. Checkout
        // TODO :: checkout process
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 24, discountPrice 24 - 10%
    }
}
