package ir.rezazadeh.interview.avan;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OptimalPackerTest {

    @Test
    void givenNormalInput_whenPack_thenOneGoodIsChosen() {
        float maxWeight = 81f;

        List<Good> givenGoods = new ArrayList<>();
        givenGoods.add(new Good(1, 53.38f, 45f));
        givenGoods.add(new Good(2, 88.62f, 98f));
        givenGoods.add(new Good(3, 78.48f, 3f));
        givenGoods.add(new Good(4, 72.30f, 76f));
        givenGoods.add(new Good(5, 30.18f, 9f));
        givenGoods.add(new Good(6, 46.34f, 48f));

        List<Good> optimalGoods = new ArrayList<>();
        optimalGoods.add(new Good(4, 72.30f, 76f));

        assertPacking(maxWeight, givenGoods, optimalGoods);
    }

    @Test
    void givenNormalInput_whenPack_thenTwoGoodsAreChosen() {
        float maxWeight = 75f;

        List<Good> givenGoods = new ArrayList<>();
        givenGoods.add(new Good(1, 85.31f, 29f));
        givenGoods.add(new Good(2, 14.55f, 74f));
        givenGoods.add(new Good(3, 3.98f, 16f));
        givenGoods.add(new Good(4, 26.24f, 55f));
        givenGoods.add(new Good(5, 63.69f, 52f));
        givenGoods.add(new Good(6, 76.25f, 75f));
        givenGoods.add(new Good(7, 60.02f, 74f));
        givenGoods.add(new Good(8, 93.18f, 35f));
        givenGoods.add(new Good(9, 89.95f, 78f));

        List<Good> optimalGoods = new ArrayList<>();
        optimalGoods.add(new Good(2, 14.55f, 74f));
        optimalGoods.add(new Good(7, 60.02f, 74f));

        assertPacking(maxWeight, givenGoods, optimalGoods);
    }

    @Test
    void givenNormalInput_whenPack_thenTwoGoodsAreChosen2() {
        float maxWeight = 56f;

        List<Good> givenGoods = new ArrayList<>();
        givenGoods.add(new Good(1, 90.72f, 13f));
        givenGoods.add(new Good(2, 33.80f, 40f));
        givenGoods.add(new Good(3, 43.15f, 10f));
        givenGoods.add(new Good(4, 37.97f, 16f));
        givenGoods.add(new Good(5, 46.81f, 36f));
        givenGoods.add(new Good(6, 48.77f, 79f));
        givenGoods.add(new Good(7, 81.80f, 45f));
        givenGoods.add(new Good(8, 19.36f, 79f));
        givenGoods.add(new Good(9, 6.76f, 64f));

        List<Good> optimalGoods = new ArrayList<>();
        optimalGoods.add(new Good(8, 19.36f, 79f));
        optimalGoods.add(new Good(9, 6.76f, 64f));

        assertPacking(maxWeight, givenGoods, optimalGoods);
    }

    @Test
    void givenOneGoodHeavierThanMaxWeight_whenPack_thenNoGoodIsChosen() {
        float maxWeight = 8f;

        List<Good> givenGoods = new ArrayList<>();
        givenGoods.add(new Good(1, 15.3f, 34f));

        List<Good> optimalGoods = new ArrayList<>();

        assertPacking(maxWeight, givenGoods, optimalGoods);
    }

    private void assertPacking(float maxWeight, List<Good> givenGoods, List<Good> expectedOptimalPack) {
        List<Good> actualOptimalPack = OptimalPacker.pack(maxWeight, givenGoods);
        assertEquals(expectedOptimalPack.size(), actualOptimalPack.size());
        assertTrue(expectedOptimalPack.containsAll(actualOptimalPack));
    }
}