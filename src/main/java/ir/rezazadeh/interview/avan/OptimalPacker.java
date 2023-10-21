package ir.rezazadeh.interview.avan;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a pack method which chooses an optimized package from provided goods list in a way that maximize
 * total price while keeps total weight under given max weight.
 */
public class OptimalPacker {

    /**
     * Chooses an optimized package from provided goods list in a way that maximize total price while keeps total
     * weight under given max weight.
     */
    public static List<Good> pack(float maxWeight, List<Good> goodList) {
        return chooseOptimalPack(maxWeight, new ArrayList<>(), goodList);
    }

    /**
     * Chooses an optimized package from provided goods list by recursively remove a good from remaining goods list
     * and checking all possible packs containing or not-containing that good.
     * @param maxWeight Maximum package weight permitted
     * @param chosenGoods Goods chosen to be in optimal pack till now
     * @param remainingGoods Remaining goods which are going to choose
     * @return
     */
    private static List<Good> chooseOptimalPack(float maxWeight, List<Good> chosenGoods, List<Good> remainingGoods) {

        // This chosen pack and all packs which can be created by adding remaining goods to it are heavier than
        // max weight so an empty pack with zero total price is returned.
        if (calculateTotalWeight(chosenGoods) > maxWeight) {
            return new ArrayList<>();
        }

        // There is no remaining good to add to chosen pack so current chosen pack is returned to compare with other
        // chosen packs in previous steps.
        if (remainingGoods.isEmpty()) {
            return chosenGoods;
        }

        // Remove next good from remaining goods and add create two new pack from current chosen pack, one containing
        // this good and the other not containing it. Then call this method recursively to find the optimal pack created
        // from each one by adding remaining goods to them.
        List<Good> packWithNextGood = new ArrayList<>(chosenGoods);
        List<Good> packWithoutNextGood = new ArrayList<>(chosenGoods);
        Good nextGood = remainingGoods.remove(0);
        packWithNextGood.add(nextGood);
        List<Good> optimalPackWithNextGood =
                chooseOptimalPack(maxWeight, packWithNextGood, new ArrayList<>(remainingGoods));
        List<Good> optimalPackWithoutNextGood =
                chooseOptimalPack(maxWeight, packWithoutNextGood, new ArrayList<>(remainingGoods));

        // Compare total price and weight of the optimal pack containing next good with the one not-containing it.
        float withNextGoodPrice = calculateTotalPrice(optimalPackWithNextGood);
        float withoutNextGoodPrice = calculateTotalPrice(optimalPackWithoutNextGood);
        float withNextGoodWeight = calculateTotalWeight(optimalPackWithNextGood);
        float withoutNextGoodWeight = calculateTotalWeight(optimalPackWithoutNextGood);
        if (withNextGoodPrice == withoutNextGoodPrice) {
            if (withNextGoodWeight < withoutNextGoodWeight) {
                return optimalPackWithNextGood;
            } else {
                return optimalPackWithoutNextGood;
            }
        } else if (withNextGoodPrice > withoutNextGoodPrice) {
            return optimalPackWithNextGood;
        } else {
            return optimalPackWithoutNextGood;
        }
    }

    private static float calculateTotalWeight(List<Good> goodList) {
        return goodList.stream().map(Good::getWeight).reduce(Float::sum).orElse(0F);
    }

    private static float calculateTotalPrice(List<Good> goodList) {
        return goodList.stream().map(Good::getPrice).reduce(Float::sum).orElse(0F);
    }
}
