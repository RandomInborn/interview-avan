package interview.avan.goods.service.repository;

import interview.avan.goods.service.model.Good;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class GoodsSpecifications {

    public static Specification<Good> weightInRange(double minWeight, double maxWeight) {
        return (Root<Good> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.between(root.get("weight"), minWeight, maxWeight);
        };
    }
}
