package pro.kelu.missyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.kelu.missyou.model.BannerModel;

//@Repository
public interface BannerRepository extends JpaRepository<BannerModel, Long> {

    BannerModel findOneById(Long id);

    BannerModel findOneByName(String name);
}
