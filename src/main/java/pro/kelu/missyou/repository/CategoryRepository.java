package pro.kelu.missyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.kelu.missyou.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByIsRootOrderByIndexAsc(Boolean isRoot);


}
