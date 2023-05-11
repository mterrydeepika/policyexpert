package kata.supermarket;

import java.math.BigDecimal;

public interface Item {
    BigDecimal price();

    BigDecimal calculateDiscount(Basket basket);

    void belongsToBasket(Basket basket);
}
