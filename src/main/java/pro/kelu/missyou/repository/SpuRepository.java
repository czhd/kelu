package pro.kelu.missyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.kelu.missyou.model.Spu;

public interface SpuRepository extends JpaRepository<Spu, Long> {

    Spu findOneById(long id);
}
