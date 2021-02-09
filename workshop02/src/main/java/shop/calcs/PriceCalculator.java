package shop.calcs;

import shop.models.Basket;

public class PriceCalculator {
    public static int get(Basket basket) {
        return basket.getBooks().stream().reduce(0, (subtotal, book) -> subtotal + book.getPrice(), Integer::sum);
    }
}