package shop.biz;

import shop.calcs.DiscountCalculator;
import shop.calcs.PriceCalculator;
import shop.models.Basket;

public class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        basket.setNetPrice(netPrice);
        int maxDiscount = DiscountCalculator.get(basket);
        basket.setDiscountPrice(maxDiscount);
        int totalPrice = netPrice - maxDiscount;
        // TODO
    }
}