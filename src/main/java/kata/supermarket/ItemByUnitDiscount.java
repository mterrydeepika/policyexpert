package kata.supermarket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class ItemByUnitDiscount {

    Map<Long, Integer> countOfProducts = new HashMap<>();

    public BigDecimal applyBuyOneGetOneFree(BigDecimal pricePerUnit, long productId, Basket basket, Item item) {
        int count = 0;
        countOfProducts.put(productId, count++);
        countOfProducts.entrySet().stream().map(e-> {
            if(e.getKey().equals(productId)) {
                if(e.getValue()%2!=0)
            }
        });
        basket.add(item);
        return pricePerUnit;
    }

    public BigDecimal applyBuyThreeItemsForThePriceOfTwo(BigDecimal pricePerUnit, Basket basket, Item item) {
        return pricePerUnit;
    }
}
