package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;

    boolean itemToBeAddedFlag;

    private Item itemToBeAdded;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        item.belongsToBasket(this);
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItemToBeAddedFlag(boolean itemToBeAddedFlag) {
        this.itemToBeAddedFlag = itemToBeAddedFlag;
    }

    public boolean isItemToBeAddedFlag() {
        return itemToBeAddedFlag;
    }

    public void setItemToBeAdded(Item itemToBeAdded) {
        this.itemToBeAdded = itemToBeAdded;
    }
    public Item getItemToBeAdded() {
        return itemToBeAdded;
    }

    private class TotalCalculator {
        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        /**
         * TODO: This could be a good place to apply the results of
         *  the discount calculations.
         *  It is not likely to be the best place to do those calculations.
         *  Think about how Basket could interact with something
         *  which provides that functionality.
         */
        private BigDecimal discounts() {
            BigDecimal discount = items.stream().map(i-> i.calculateDiscount(Basket.this)).reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO).setScale(2,RoundingMode.HALF_UP);

            if(Basket.this.isItemToBeAddedFlag())
                Basket.this.add(Basket.this.getItemToBeAdded());
            return discount;
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}