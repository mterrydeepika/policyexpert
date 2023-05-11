package kata.supermarket;

import java.math.BigDecimal;


public class ItemByUnitDiscount {

    public BigDecimal applyBuyOneGetOneFree(BigDecimal pricePerUnit, long productId, Basket basket, Item item) {
        final int[] count = {0};
        basket.getItems().forEach(i-> {
            if(i instanceof ItemByUnit
                    && ((ItemByUnit) i).getProduct().getProductId() == productId) {
                count[0]++;
            }
        });

        if(count[0]%2!=0) {
            basket.setItemToBeAddedFlag(true);
            basket.setItemToBeAdded(item);
            return BigDecimal.ZERO;
        }
        return pricePerUnit;

    }

    public BigDecimal applyBuyThreeItemsForThePriceOfTwo(BigDecimal pricePerUnit, Basket basket, Item item) {
        return pricePerUnit;
    }
}
