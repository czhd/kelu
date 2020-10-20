package pro.kelu.missyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.kelu.missyou.model.GridCategory;
import pro.kelu.missyou.repository.GridCategoryRepository;

import java.util.List;

@Service
public class GridCategoryService {

    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    public List<GridCategory> getALlGrid() {
        return gridCategoryRepository.findAll();
    }
}
