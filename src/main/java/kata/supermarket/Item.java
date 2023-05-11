package kata.supermarket;

import java.math.BigDecimal;

public interface Item {
    BigDecimal price();

    BigDecimal calculateDiscount(Basket basket);

    OffersAvailable getOffersAvailable();

    void belongsToBasket(Basket basket);
}
