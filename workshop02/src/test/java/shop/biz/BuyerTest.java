package shop.biz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import shop.models.Basket;
import shop.models.Book;
import shop.models.BookBuilder;

public class BuyerTest {

    @Test
    public void buy_a_book() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book = new Book("Potter 1", 8);
        basket.addBook(book);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 8, discountPrice 8 - 0%
        assertEquals(800, basket.getNetPrice()); // 8.00
        assertEquals(800, basket.getDiscountPrice()); // 8.00
    }

    @Test
    public void buy_2_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 16, discountPrice 16 - 5%
        assertEquals(1600, basket.getNetPrice()); // 16.00
        assertEquals(1520, basket.getDiscountPrice()); // 15.20
    }

    @Test
    public void buy_3_books() {
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
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 24, discountPrice 24 - 10%
        assertEquals(2400, basket.getNetPrice()); // 24.00
        assertEquals(2160, basket.getDiscountPrice()); // 21.60
    }

    @Test
    public void buy_2_same_books_should_consider_as_a_book() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        basket.addBook(book1);
        basket.addBook(book2);

        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        int expectedBookNumber = 1;
        assertEquals(expectedBookNumber, basket.getBookListSize());

        int expectedQty = 2;
        assertEquals(expectedQty, basket.getBookQty(book1));
        assertEquals(expectedQty, basket.getBookQty(book2));

        // Check netPrice = 16, discountPrice 16 - 0%
        assertEquals(1600, basket.getNetPrice()); // 16.00
        assertEquals(1600, basket.getDiscountPrice()); // 16.00
    }

    @Test
    public void buy_3_books_but_2_are_same_books_should_consider_as_2_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        Book book3 = new BookBuilder().chooseBook("Potter 2").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);

        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        int expectedBookNumber = 2;
        assertEquals(expectedBookNumber, basket.getBookListSize());

        int expectedPotter1Qty = 2;
        assertEquals(expectedPotter1Qty, basket.getBookQty(book1));
        assertEquals(expectedPotter1Qty, basket.getBookQty(book2));

        int expectedPotter2Qty = 1;
        assertEquals(expectedPotter2Qty, basket.getBookQty(book3));

        // Check netPrice = 24, discountPrice 24 - 5%
        assertEquals(2400, basket.getNetPrice()); // 24.00
        assertEquals(2280, basket.getDiscountPrice()); // 22.80
    }

}
