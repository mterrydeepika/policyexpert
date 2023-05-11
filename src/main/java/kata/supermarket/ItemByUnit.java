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
        BigDecimal[] discount = new BigDecimal[1];
        if (offersAvailable == null)
            discount[0] = BigDecimal.ZERO;

        product.offers.forEach(offer -> {
            switch(offerName.toLowerCase()) {
                case "buyonegetonefree" :
                    discount[0] = offersAvailable.buyOneGetOneFree(product.pricePerUnit(), product.getProductId(),
                            basket, this);
                    break;
                case "buythreeitemsforthepriceoftwo" :
                    discount[0] = offersAvailable.buyThreeItemsForThePriceOfTwo(product.pricePerUnit(),
                            basket, this);
                    break;
                    default :
                        discount[0] = BigDecimal.ZERO;
            }
        });

        return discount[0];
    }

    public void belongsToBasket(Basket basket) {
        this.basket = basket;
    }
    public Product getProduct() {
        return product;
    }
}
