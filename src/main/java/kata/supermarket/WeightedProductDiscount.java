package kata.supermarket;

import java.math.BigDecimal;

import static java.math.RoundingMode.FLOOR;

public class WeightedProductDiscount {
    public BigDecimal applyKiloAtHalfPrice(BigDecimal weight, BigDecimal pricePerKilo) {
        return pricePerKilo.multiply(weight.setScale(0, FLOOR)).divide(BigDecimal.valueOf(2));
    }
}
