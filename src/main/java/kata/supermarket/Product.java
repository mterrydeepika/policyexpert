package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

    protected final BigDecimal pricePerUnit;
    List<String> offers;
    private final OffersAvailable offersAvailable;
    private String offerName;

    protected final long productId;

    public Product(final BigDecimal pricePerUnit, long productId, String offerName) {
        this.pricePerUnit = pricePerUnit;
        this.offersAvailable = new OffersAvailable();
        this.productId = productId;
        this.offerName = offerName;
        offers = new ArrayList<String>();
        offers.add("none");
        offers.add("buyOneGetOneFree");
        offers.add("buyThreeItemsForThePriceOfTwo");
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this, offersAvailable, offerName);
    }
    public long getProductId() {
        return productId;
    }
    public String getOfferName() {
        return offerName;
    }
}
