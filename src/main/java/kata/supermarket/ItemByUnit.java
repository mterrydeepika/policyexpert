package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {
    private final OffersAvailable offersAvailable;
    private final Product product;
    private final String offerName;
    private Basket basket;

    public ItemByUnit(final Product product, OffersAvailable offersAvailable, String offerName) {
        this.product = product;
        this.offersAvailable = offersAvailable;
        this.offerName = offerName;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    public BigDecimal calculateDiscount(Basket basket) {
        if (offersAvailable == null) {
            return  BigDecimal.ZERO;
        }
        product.offers.stream().map(offer -> {
            if(offer.equalsIgnoreCase(offerName)
                    && offer.equalsIgnoreCase("buyOneGetOneFree"))
                return offersAvailable.buyOneGetOneFree(product.pricePerUnit(), product.getProductId(), basket, this);
            else if (offer.equalsIgnoreCase(offerName)
                    && offer.equalsIgnoreCase("buyThreeItemsForThePriceOfTwo"))
            return offersAvailable.buyThreeItemsForThePriceOfTwo(product.pricePerUnit(), basket, this);
            else return BigDecimal.ZERO;
        });

        return BigDecimal.ZERO;
    }

    public OffersAvailable getOffersAvailable() {
        return offersAvailable;
    }

    public void belongsToBasket(Basket basket) {
        this.basket = basket;
    }
    public Product getProduct() {
        return product;
    }
}
