package ir.rezazadeh.interview.avan;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter max weight of package: ");
        float maxWeight = scanner.nextFloat();
        System.out.print("Please enter goods info: ");
        String goodsInfo = "";
        do {
            goodsInfo = scanner.nextLine();
        } while (goodsInfo.isEmpty());

        List<Good> givenGoods = GoodParser.parseGoodsList(goodsInfo);
        List<Good> optimalPack = OptimalPacker.pack(maxWeight, givenGoods);

        String result = optimalPack.stream()
                .map(good -> good.getId().toString())
                .collect(Collectors.joining(", "));

        System.out.println("Id of goods in optimal pack: " + result);
    }
}