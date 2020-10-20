package pro.kelu.missyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.kelu.missyou.model.Category;
import pro.kelu.missyou.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Map<Integer, List<Category>> getAll() {
        List<Category> roots = categoryRepository.findByIsRootOrderByIndexAsc(true);
        List<Category> subs = categoryRepository.findByIsRootOrderByIndexAsc(false);
        Map<Integer, List<Category>> categories = new HashMap<>();
        categories.put(1, roots);
        categories.put(2, subs);
        return categories;
    }
}
