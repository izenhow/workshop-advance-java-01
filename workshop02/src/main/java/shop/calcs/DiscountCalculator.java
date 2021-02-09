package shop.calcs;

import shop.models.Basket;

public class DiscountCalculator {
    private static int BOOK_QTY_GET_5_PERCENT_DISCOUNT = 2;
    private static int BOOK_QTY_GET_10_PERCENT_DISCOUNT = 3;

    public static int get(Basket basket) {
        int bookQty = basket.getBookQty();

        double netPrice = basket.getNetPrice();
        int percentage = getDiscountPercentage(bookQty);
        double discountedPrice = calcDiscount(netPrice, percentage);

        return (int) discountedPrice;
    }

    private static double calcDiscount(double price, int percentage) {
        return price - (price * percentage / 100);
    }

    private static int getDiscountPercentage(int bookQty) {
        return bookQty == BOOK_QTY_GET_5_PERCENT_DISCOUNT ? 5 : bookQty == BOOK_QTY_GET_10_PERCENT_DISCOUNT ? 10 : 0;
    }
}