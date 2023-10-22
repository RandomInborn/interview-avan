package interview.avan.goods.service.controller;

import interview.avan.goods.service.model.Good;
import interview.avan.goods.service.repository.GoodsRepository;
import interview.avan.goods.service.repository.GoodsSpecifications;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static interview.avan.goods.service.parser.GoodParser.parseGoodsList;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @PostMapping()
    public void saveGoods(@RequestBody String goodsInfo) {
        List<Good> goods = parseGoodsList(goodsInfo);
        goodsRepository.saveAll(goods);
    }


    @GetMapping("/avg-price")
    public double getAveragePrice(
            @RequestParam("minWeight") float minWeight,
            @RequestParam("maxWeight") float maxWeight) {
        // Calculate the average price of goods within the specified weight range
        Specification<Good> spec = GoodsSpecifications.weightInRange(minWeight, maxWeight);
        return goodsRepository
                .findAll(spec)
                .stream()
                .mapToDouble(Good::getPrice)
                .average()
                .orElse(0.0);
    }
}