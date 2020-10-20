package pro.kelu.missyou.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.kelu.missyou.exception.http.NotFoundException;
import pro.kelu.missyou.model.Category;
import pro.kelu.missyou.model.GridCategory;
import pro.kelu.missyou.service.CategoryService;
import pro.kelu.missyou.service.GridCategoryService;
import pro.kelu.missyou.vo.CategoriesAllVO;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GridCategoryService gridCategoryService;

    @GetMapping("/all")
    public CategoriesAllVO getAllCategory() {
        Map<Integer, List<Category>> categories = categoryService.getAll();
        return new CategoriesAllVO(categories);
    }

    @GetMapping("/grid/all")
    public List<GridCategory> getAllGridCategory() {
        List<GridCategory> gridCategories = gridCategoryService.getALlGrid();
        if (gridCategories.isEmpty()) {
            throw new NotFoundException(30009);
        }
        return gridCategories;
    }
}
