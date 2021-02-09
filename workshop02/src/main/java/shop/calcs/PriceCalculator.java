package shop.calcs;

import shop.models.Basket;

public class PriceCalculator {
    public static int get(Basket basket) {
        return basket.getItemList().getSumPrice();
    }
}