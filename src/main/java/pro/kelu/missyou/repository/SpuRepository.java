package pro.kelu.missyou.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.kelu.missyou.model.Spu;

public interface SpuRepository extends JpaRepository<Spu, Long> {

    Spu findOneById(long id);

    Page<Spu> findByCategoryIdOrderByCreateTime(long cid, Pageable pageable);

    Page<Spu> findByRootCategoryIdOrderByCreateTime(long rootCid, Pageable pageable);
}
