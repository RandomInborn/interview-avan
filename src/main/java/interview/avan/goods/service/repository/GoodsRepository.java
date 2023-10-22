package interview.avan.goods.service.repository;

import interview.avan.goods.service.model.Good;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepository extends CrudRepository<Good, Long>, JpaSpecificationExecutor<Good> {

    List<Good> findAll(Specification<Good> spec);
}
