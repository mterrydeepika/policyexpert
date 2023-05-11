package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnitWithoutOffer(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                multipleItemsPricedPerUnitWithAnOffer(),
                twoItemsPricedPerUnit_withBuyOneGetOneFreeOffer()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnitWithoutOffer() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestivesWithoutOffer(), aPintOfMilk()));
    }

    private static Arguments multipleItemsPricedPerUnitWithAnOffer() {
        return Arguments.of("multiple items priced per unit with an offer", "2.04",
                Arrays.asList(aPackOfDigestivesWithOffer(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49"), 1, "none").oneOf();
    }

    private static Item aPackOfDigestivesWithOffer() {
        return new Product(new BigDecimal("1.55"), 2, "buyOneGetOneFree").oneOf();
    }

    private static Item aPackOfDigestivesWithoutOffer() {
        return new Product(new BigDecimal("1.55"), 2, "none").oneOf();
    }

    private static Arguments twoItemsPricedPerUnit_withBuyOneGetOneFreeOffer() {
        return Arguments.of("two items priced per unit", "1.55",
                Arrays.asList(aPackOfDigestivesWithOffer(), aPackOfDigestivesWithoutOffer()));
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    /*private static WeighedProduct aKiloOfAmericanSweetsWithOffer() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }*/


    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}