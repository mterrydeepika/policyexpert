package kata.supermarket;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;

    private Basket basket;

    private final OffersAvailable offersAvailable;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos, OffersAvailable offersAvailable) {
        this.product = product;
        this.weightInKilos = weightInKilos;
        this.offersAvailable = offersAvailable;
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, HALF_UP);
    }

    public BigDecimal calculateDiscount(Basket basket) {
       if (offersAvailable == null) return BigDecimal.ZERO;
       return offersAvailable.weightedProductDiscount(weightInKilos, product.pricePerKilo());
    }

    @Override
    public void belongsToBasket(Basket basket) {
        basket = this.basket;
    }
}
