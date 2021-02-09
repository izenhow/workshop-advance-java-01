package shop.biz;

import shop.calcs.DiscountCalculator;
import shop.calcs.PriceCalculator;
import shop.models.Basket;

public class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        int maxDiscount = DiscountCalculator.get(basket);
        int totalPrice = netPrice - maxDiscount;
        // TODO
    }
}