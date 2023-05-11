package kata.supermarket;

import java.math.BigDecimal;

public interface Item {
    BigDecimal price();

    BigDecimal calculateDiscount(Basket basket);

    OffersAvailable getOffersAvailable();

    BigDecimal getDiscountAmount();

    void belongsToBasket(Basket basket);
}
