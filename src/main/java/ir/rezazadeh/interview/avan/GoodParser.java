package ir.rezazadeh.interview.avan;

import java.util.ArrayList;
import java.util.List;

public class GoodParser {

    /**
     * Creates a {@link Good} by parsing given good info.
     * @param goodInfo in (id,weight,price) format e.g. (1,12.5,$34)
     */
    public static Good parseGood(String goodInfo) {
        goodInfo = goodInfo.substring(1, goodInfo.length() - 1); // Removing '(' and ')'
        String[] info = goodInfo.split(",");
        Integer id = Integer.parseInt(info[0]);
        Float weight = Float.parseFloat(info[1]);
        Float price = Float.parseFloat(info[2].substring(1)); // Removing '$'
        return new Good(id, weight, price);
    }

    /**
     * Creates a list of {@link Good} by parsing given goods info.
     * @param goodsInfo a list of good info separated by space in (id,weight,price) format e.g. (1,12.5,$34)
     */
    public static List<Good> parseGoodsList(String goodsInfo) {
        List<Good> goodsList = new ArrayList<>();
        for (String goodInfo : goodsInfo.split(" ")) {
            goodsList.add(parseGood(goodInfo));
        }
        return goodsList;
    }
}
