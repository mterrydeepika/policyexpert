package kata.supermarket;

import java.math.BigDecimal;

public class OffersAvailable {
    private WeightedProductDiscount weightedProductDiscount;
    private ItemByUnitDiscount itemByUnitDiscount;

    public OffersAvailable() {
        this.weightedProductDiscount = new WeightedProductDiscount();
        this.itemByUnitDiscount = new ItemByUnitDiscount();
    }

    public BigDecimal weightedProductDiscount(BigDecimal weight, BigDecimal pricePerKilo) {
        return weightedProductDiscount.applyKiloAtHalfPrice(weight,pricePerKilo);
    }

    public BigDecimal buyOneGetOneFree(BigDecimal pricePerUnit, long productId, Basket basket, Item item) {
        return itemByUnitDiscount.applyBuyOneGetOneFree(pricePerUnit, productId, basket, item);
    }

    public BigDecimal buyThreeItemsForThePriceOfTwo(BigDecimal pricePerUnit, Basket basket, Item item) {
        return itemByUnitDiscount.applyBuyThreeItemsForThePriceOfTwo(pricePerUnit, basket, item);
    }
}
